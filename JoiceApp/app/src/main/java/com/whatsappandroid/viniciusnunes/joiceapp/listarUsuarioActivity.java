package com.whatsappandroid.viniciusnunes.joiceapp;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.whatsappandroid.viniciusnunes.joiceapp.Model.Usuario;
import com.whatsappandroid.viniciusnunes.joiceapp.controller.UsuarioController;

import java.util.ArrayList;
import java.util.List;


public class listarUsuarioActivity extends AppCompatActivity {

    private EditText pesquisarUsuario;
    private Button botaoPesquidar;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuario);

        linearLayout = findViewById(R.id.objetoContatos);
        pesquisarUsuario = findViewById(R.id.pesquisarID);
        botaoPesquidar = findViewById(R.id.btnPesquisarID);

        botaoPesquidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioLogin = pesquisarUsuario.getText().toString();
                if(!usuarioLogin.isEmpty()){
                    buscarUsuario(usuarioLogin);
                }

            }
        });


        atualizarListaUsuarios();


    }

    public void atualizarListaUsuarios(){


        linearLayout.removeAllViews();

        List<Usuario> usuarios = new UsuarioController(this).listarUsuario();

        if(usuarios.size() > 0){

            for(Usuario obj : usuarios){

                int id = obj.getId();
                String nome = obj.getNome();
                String telefone = obj.getTelefone();
                String tipologin = obj.getTipoLogin();

                String texto = id +" - "+ nome +" - "+ telefone +" - "+ tipologin;

                TextView textViewUsuario = new TextView(this);
                textViewUsuario.setPadding(0,10,0,10);
                textViewUsuario.setText(texto);
                textViewUsuario.setTag(Integer.toString(id));
                textViewUsuario.setTextSize(16);
                textViewUsuario.setTextColor(Color.BLACK);


                linearLayout.addView(textViewUsuario);
                textViewUsuario.setOnLongClickListener(new RetrieveOnLongClickListener());

            }
        }
    }

    public void buscarUsuario (String usuarioLogin) {

        linearLayout.removeAllViews();

        List<Usuario> usuarios = new UsuarioController(this).Pesquisar(usuarioLogin);

        if (usuarios.size() > 0) {

            for (Usuario obj : usuarios) {
                int id = obj.getId();
                String nome = obj.getNome();
                String telefone = obj.getTelefone();
                String tipologin = obj.getTipoLogin();

                String texto = id + " - " + nome + " - " + telefone + " - " + tipologin;

                TextView textViewUsuario = new TextView(this);
                textViewUsuario.setPadding(0, 10, 0, 10);
                textViewUsuario.setText(texto);
                textViewUsuario.setTag(Integer.toString(id));
                textViewUsuario.setTextSize(16);
                textViewUsuario.setTextColor(Color.BLACK);


                linearLayout.addView(textViewUsuario);
                textViewUsuario.setOnLongClickListener(new RetrieveOnLongClickListener());

            }

        }
    }

}

