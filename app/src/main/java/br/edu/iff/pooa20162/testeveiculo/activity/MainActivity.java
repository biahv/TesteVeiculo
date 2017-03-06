package br.edu.iff.pooa20162.testeveiculo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import br.edu.iff.pooa20162.testeveiculo.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamaTelaCadastros(View v){

        Toast.makeText(this,"",Toast.LENGTH_SHORT);
    }
}
