package com.example.alumnosdanielhung.restaurantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listTipos;
    private ArrayList<String> tiposComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiposComida = new ArrayList<>();
        tiposComida.add("Italiana");
        tiposComida.add("Española");
        tiposComida.add("Comida Rapida");

        listTipos = (ListView) findViewById(R.id.listTipos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, tiposComida);

        listTipos.setAdapter(adapter);

        listTipos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        Intent intent2 = new Intent(MainActivity.this, ListRestaurantesActivity.class);
        intent2.putExtra("TIPO_KEY", posicion);
        startActivity(intent2);
    }
}
