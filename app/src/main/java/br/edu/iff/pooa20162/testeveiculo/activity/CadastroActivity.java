package br.edu.iff.pooa20162.testeveiculo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.testeveiculo.R;
import br.edu.iff.pooa20162.testeveiculo.model.Proprietarios;

public class CadastroActivity extends Activity {

    EditText nome, endereco, telefone, dataNasc;
    Button btsalvar,btalterar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");

        String nomep     = (String) intent.getSerializableExtra("nome");
        String enderecop = (String) intent.getSerializableExtra("endereco");
        String telefonep    = (String) intent.getSerializableExtra("telefone");
        String dataNascp     = (String) intent.getSerializableExtra("dataNasc");

        EditText nome = (EditText) findViewById(R.id.etNomeP);
        nome.setText(nomep);

        EditText endereco = (EditText) findViewById(R.id.etEnderecoP);
        endereco.setText(enderecop);

        EditText telefone = (EditText) findViewById(R.id.etTelefoneP);
        telefone.setText(telefonep);

        EditText data = (EditText) findViewById(R.id.etDataNascP);
        dataNasc.setText(dataNascp);


        btsalvar = (Button) findViewById(R.id.btSalvarP);
        btalterar = (Button) findViewById(R.id.btAlterarP);


        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);

        }


    }

    public void salvar() {

        nome = (EditText) findViewById(R.id.etNomeP);
        endereco = (EditText) findViewById(R.id.etEnderecoP);
        telefone = (EditText) findViewById(R.id.etTelefoneP);
        dataNasc = (EditText) findViewById(R.id.etDataNascP);

        Proprietarios proprietarios = new Proprietarios(nome.getText().toString(),endereco.getText().toString(),
                telefone.getText().toString(),dataNasc.getText().toString());

        proprietarios.save();

        Toast.makeText(this,"Proprietário Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        nome = (EditText) findViewById(R.id.etNomeP);
        endereco = (EditText) findViewById(R.id.etEnderecoP);
        telefone = (EditText) findViewById(R.id.etTelefoneP);
        dataNasc = (EditText) findViewById(R.id.etDataNascP);

        Proprietarios proprietarios= Proprietarios.findById(Proprietarios.class, id);

        proprietarios.setNome(nome.getText().toString());
        proprietarios.setEndereco(endereco.getText().toString());
        proprietarios.setTelefone(telefone.getText().toString());
        proprietarios.setDataNasc(dataNasc.getText().toString());

        proprietarios.save();

        Toast.makeText(this,"Proprietário Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
