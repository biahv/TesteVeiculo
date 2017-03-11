package br.edu.iff.pooa20162.testeveiculo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.testeveiculo.R;
import br.edu.iff.pooa20162.testeveiculo.adapter.ProprietarioAdapter;
import br.edu.iff.pooa20162.testeveiculo.model.Proprietarios;

public class ListaPropriActivity extends AppCompatActivity {

    public void chamaCadastradosP(View v){
        Intent intentP1 = new Intent(ListaPropriActivity.this, CadastroActivity.class);
        startActivity(intentP1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_propri);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaPropriActivity.this,CadastroActivity.class);
                intent.putExtra("id",0);
                intent.putExtra("nome","");
                intent.putExtra("endereco","");
                intent.putExtra("telefone","");
                intent.putExtra("dataNasc","");

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_propri, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Proprietarios> proprietarios  = (ArrayList) Proprietarios.listAll(Proprietarios.class);

        ListView lista = (ListView) findViewById(R.id.lvProprietarios);
        ArrayAdapter adapter = new ProprietarioAdapter(this,proprietarios);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaPropriActivity.this,CadastroActivity.class);

                intent.putExtra("id",proprietarios.get(i).getId().intValue());
                intent.putExtra("nome",proprietarios.get(i).getNome());
                intent.putExtra("endereco",proprietarios.get(i).getEndereco());
                intent.putExtra("telefone",proprietarios.get(i).getTelefone());
                intent.putExtra("dataNasc",proprietarios.get(i).getDataNasc());

                startActivity(intent);

            }
        });


    }


}
