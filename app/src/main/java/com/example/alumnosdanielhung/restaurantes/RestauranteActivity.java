package com.example.alumnosdanielhung.restaurantes;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RestauranteActivity extends AppCompatActivity {

    private ImageView imgRestaurante;
    private TextView txtNombre, txtTelefono, txtDireccion;
    private ListView listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        imgRestaurante = (ImageView) findViewById(R.id.imgRestaurante);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtDireccion = (TextView) findViewById(R.id.txtDireccion);
        listMenu = (ListView) findViewById(R.id.listMenu);

        Intent intent = getIntent();
        RestauranteBean restaurante = (RestauranteBean) intent.getSerializableExtra("RESTAURANTE_KEY");

        imgRestaurante.setImageDrawable(ContextCompat.getDrawable(RestauranteActivity.this, restaurante.getFoto()));

        txtNombre.setText(restaurante.getNombre());
        txtTelefono.setText(restaurante.getTelefono());
        txtDireccion.setText(restaurante.getDireccion());

    }
}
