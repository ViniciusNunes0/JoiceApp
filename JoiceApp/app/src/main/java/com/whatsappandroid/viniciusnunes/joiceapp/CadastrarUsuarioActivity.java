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
import android.widget.Toast;

import com.whatsappandroid.viniciusnunes.joiceapp.Model.Usuario;
import com.whatsappandroid.viniciusnunes.joiceapp.controller.UsuarioController;

public class CadastrarUsuarioActivity extends AppCompatActivity {

    private Spinner spinner;
    private int posicao;
    private EditText nome;
    private EditText telefone;
    private EditText senha;
    private Button botaoSalvar;
    private Button botaoVoltar;
    private Button botaoListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);


        spinner = findViewById(R.id.tipoLoginC);
        telefone = findViewById(R.id.editTelefone);
        nome = findViewById(R.id.editNome);
        senha = findViewById(R.id.editSenhaC);
        botaoSalvar = findViewById(R.id.btnCadastar);
        botaoVoltar = findViewById(R.id.btnVoltar);
        botaoListar = findViewById(R.id.btnListar);

        tipoLoginSpinner();

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (posicao == 0) {
                    Toast.makeText(getApplication(), "Selecione o tipo de login", Toast.LENGTH_LONG).show();
                }
                else if(nome.getText().toString().isEmpty() || telefone.getText().toString().isEmpty() || senha.getText().toString().isEmpty()){
                    Toast.makeText(getApplication(), "Preencha os campos vazios", Toast.LENGTH_LONG).show();
                }
                else {
                    Usuario usuario = new Usuario();
                    usuario.setTelefone(telefone.getText().toString());
                    usuario.setSenha(senha.getText().toString());
                    usuario.setNome(nome.getText().toString());
                    String valor = (posicao==1)?"Cuidador":"Cliente";
                    usuario.setTipoLogin(valor);

                    UsuarioController usuarioController = new UsuarioController(getApplicationContext());
                    usuarioController.CadastrarUsuario(usuario, getApplication());
                }

            }

        });

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        botaoListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), listarUsuarioActivity.class);
                startActivity(intent);
            }
        });

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

}