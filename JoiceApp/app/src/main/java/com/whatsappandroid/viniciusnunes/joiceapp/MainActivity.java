package com.whatsappandroid.viniciusnunes.joiceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.whatsappandroid.viniciusnunes.joiceapp.Model.Usuario;
import com.whatsappandroid.viniciusnunes.joiceapp.controller.UsuarioController;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText login;
    private EditText senha;
    private Button botaoCancelar;
    private Button botaoLogar;
    private int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.tipoLogin);
        login = findViewById(R.id.editLogin);
        senha = findViewById(R.id.editSenha);
        botaoLogar = findViewById(R.id.btnLogar);
        botaoCancelar = findViewById(R.id.btnCancelar);

         tipoLoginSpinner();

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(posicao == 0){
                    Toast.makeText(MainActivity.this,"Selecione o tipo de login",Toast.LENGTH_LONG).show();
                }
                else {
                    Usuario usuario = new Usuario();
                    usuario.setTelefone(login.getText().toString());
                    usuario.setSenha(senha.getText().toString());
                    //usuario.setTipoLogin(posicao);
                    usuario.setNome("nunes");

                    UsuarioController usuarioController = new UsuarioController(getApplicationContext());
                    usuarioController.CadastrarUsuario(usuario, MainActivity.this);

                    Log.i("db", usuario.getTelefone());
                    Log.i("db", usuario.getSenha());
                    Log.i("db", String.valueOf(posicao));
                    Log.i("db", String.valueOf(usuario.getId()));
                }

            }

        });

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView texto = findViewById(R.id.textView9);

    }


    private void tipoLoginSpinner(){

        // PENCHE O SPINNER COM OS DADOS
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.usuario,
                R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posicao = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void abrirTelaCadastro(View view){
        Intent intent = new Intent(MainActivity.this, CadastrarUsuarioActivity.class);
        startActivity(intent);
    }


}
