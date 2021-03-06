package com.example.pc3_moviles.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pc3_moviles.R;
import com.example.pc3_moviles.entity.Sala;
import java.util.List;

public class SalaAdapter extends ArrayAdapter<Sala> {


    private Context context;
    private List<Sala> lista;


    public SalaAdapter(@NonNull Context context, int resource,  @NonNull List<Sala> lista) {
        super(context, resource,  lista);
        this.context=context;
        this.lista=lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_lista_sala_item, parent, false);

        Sala obj= lista.get(position);
        TextView txtnombre = row.findViewById(R.id.iditemlistaSalaNombre);
        txtnombre.setText(obj.getRecursos());

        return row;


    }
}
