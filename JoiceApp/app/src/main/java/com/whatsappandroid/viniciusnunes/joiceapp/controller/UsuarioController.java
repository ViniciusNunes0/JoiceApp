package com.whatsappandroid.viniciusnunes.joiceapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.whatsappandroid.viniciusnunes.joiceapp.DAO.DatabaseAdapter;
import com.whatsappandroid.viniciusnunes.joiceapp.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinicius Nunes on 18/12/2017.
 */

public class UsuarioController extends DatabaseAdapter {

    public UsuarioController(Context context) {
        super(context);
    }

    public boolean CadastrarUsuario(Usuario usuario,Context context){

        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("telefone", usuario.getTelefone());
        values.put("senha", usuario.getSenha());
        values.put("tipoLogin",usuario.getTipoLogin());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean cadatrado = db.insert("usuario",null, values) > 0;
        if(cadatrado){
            Toast.makeText(context,"Cadastrado com Sucesso",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context,"Erro ao Cadastrar",Toast.LENGTH_LONG).show();
        }

        db.close();

        return cadatrado;
    }

    public List<Usuario> listarUsuario(){

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM  usuario ORDER BY id DESC";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                String tipoLogin = cursor.getString(cursor.getColumnIndex("tipoLogin"));

                Usuario usuario = new Usuario();
                usuario.setId(id);
                usuario.setTelefone(telefone);
                usuario.setNome(nome);
                usuario.setTipoLogin(tipoLogin);

                usuarios.add(usuario);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return usuarios;
    }

    public boolean ValidarLogin(Usuario usuario, Context context){

        boolean logado = false;

        String senha="";
        String login="";
        String tipoLogin="";

        try {

            String sql = "SELECT * FROM  usuario where telefone =" + usuario.getTelefone()+"";

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery(sql, null);
            if (cursor.moveToFirst()) {
                do {
                    login = cursor.getString(cursor.getColumnIndex("telefone"));
                    senha = cursor.getString(cursor.getColumnIndex("senha"));
                    tipoLogin = cursor.getString(cursor.getColumnIndex("tipoLogin"));

                } while (cursor.moveToNext());
            }

            if (usuario.getTelefone().equals(login) && usuario.getSenha().equals(senha) && usuario.getTipoLogin().equals(tipoLogin)){
                Toast.makeText(context, "Login Realizado com Sucesso", Toast.LENGTH_LONG).show();
                logado = true;
            }
            else {
                Toast.makeText(context, "Usuario invalido", Toast.LENGTH_LONG).show();
            }

            cursor.close();
            db.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        return logado;
    }

    public List<Usuario> Pesquisar(String usuarioLogin){

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM  usuario where telefone ="+usuarioLogin+"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                String tipoLogin = cursor.getString(cursor.getColumnIndex("tipoLogin"));

                Usuario usuario = new Usuario();
                usuario.setId(id);
                usuario.setTelefone(telefone);
                usuario.setNome(nome);
                usuario.setTipoLogin(tipoLogin);

                usuarios.add(usuario);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return usuarios;
    }




}
