package com.whatsappandroid.viniciusnunes.joiceapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.whatsappandroid.viniciusnunes.joiceapp.DAO.DatabaseAdapter;
import com.whatsappandroid.viniciusnunes.joiceapp.Model.Usuario;

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

    public boolean AlterarUsuario(Usuario usuario,Context context) {
        return true;
    }

    public boolean ExcluirUsuario(int id, Context context){

        return true;

    }

    public boolean ListarUsuarioNome(Usuario usuario, Context context){

        String sql = "SELECT * FROM usuario WHERE nome ='"+usuario.getNome()+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);

        return true;

    }

    public boolean ListarUsuarioTelefone(Usuario usuario, Context context){

        String sql = "SELECT * FROM usuario WHERE telefone ='"+usuario.getTelefone()+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);

        return true;

    }

}
