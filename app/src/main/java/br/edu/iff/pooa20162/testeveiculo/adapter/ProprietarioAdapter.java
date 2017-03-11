package br.edu.iff.pooa20162.testeveiculo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.testeveiculo.R;
import br.edu.iff.pooa20162.testeveiculo.model.Proprietarios;

/**
 * Created by bia on 10/03/17.
 */

public class ProprietarioAdapter extends ArrayAdapter<Proprietarios>  {

    private Context context = null;
    private ArrayList<Proprietarios> proprietarios = null;


    public ProprietarioAdapter(Context context, ArrayList<Proprietarios> proprietarios) {
        super(context, R.layout.linhaproprietario,proprietarios);
        this.context = context;
        this.proprietarios = proprietarios;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhaproprietario, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.tvllvNome);
        TextView endereco = (TextView) rowView.findViewById(R.id.tvllvEndereco);
        TextView telefone = (TextView) rowView.findViewById(R.id.tvllvTelefone);
        TextView dataNasc = (TextView) rowView.findViewById(R.id.tvllvDataNasc);

        nome.setText(proprietarios.get(position).getNome());
        endereco.setText(proprietarios.get(position).getEndereco());
        telefone.setText(proprietarios.get(position).getTelefone());
        dataNasc.setText(proprietarios.get(position).getDataNasc());
        return rowView;
    }


}
}
