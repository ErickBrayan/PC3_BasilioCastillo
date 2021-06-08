package com.example.pc3_moviles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc3_moviles.adapter.SalaAdapter;
import com.example.pc3_moviles.api.ServiceSalaApi;
import com.example.pc3_moviles.entity.Sala;
import com.example.pc3_moviles.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listaSalaActivity extends AppCompatActivity {

    List<Sala> lstData = new ArrayList<Sala>();
    SalaAdapter adaptador = null;
    ListView listView=null;
    ServiceSalaApi api=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sala);
        listView=findViewById(R.id.ididlistaSalalistado);
        adaptador=new SalaAdapter(this,R.layout.activity_lista_sala_item,lstData);
        listView.setAdapter(adaptador);
        api= ConnectionRest.getConnection().create(ServiceSalaApi.class);

        lista();


    }

    public void lista(){
        mensaje("LOG  MEtodo1" );

        Call<List<Sala>> call = api.lisataSala();
        call.enqueue(new Callback<List<Sala>>() {
            @Override
            public void onResponse(Call<List<Sala>> call, Response<List<Sala>> response) {
                mensaje("LOG  MEtodo1" );
                if(response.isSuccessful()){
                    List<Sala> lista = response.body();
                    mensaje("LOG --> size "+ lista.size());
                    lstData.clear();
                    lstData.addAll(lista);
                    adaptador.notifyDataSetChanged();

                }else {
                    mensaje("Error -- "+ "Error en la respuesta");
                }

            }

            @Override
            public void onFailure(Call<List<Sala>> call, Throwable t) {
                mensaje("Error -- "+ "Error en la respuesta");

            }
        });

    }
    void mensaje(String msg){
        Toast toast = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
        toast.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.idMenuCrudSala){
            Intent intent = new Intent(this,listaSalaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}