package com.example.alumnosdanielhung.restaurantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListRestaurantesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<ArrayList<RestauranteBean>> restaurantesTipo;
    private ListView listRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurantes);

        listRest = (ListView) findViewById(R.id.listRest);
        restaurantesTipo = new ArrayList<>();

        ArrayList<RestauranteBean> italianos = new ArrayList<>();
        italianos.add(new RestauranteBean("Calle Gran Via nº10", R.drawable.restaurante_italiano, "Restaurante Pepe", "916662263"));
        italianos.add(new RestauranteBean("Calle Gran Via nº15", R.drawable.restaurante_italiano,"Pizzeria Di Mama", "914652823"));
        italianos.add(new RestauranteBean("Calle Gran Via nº20", R.drawable.restaurante_italiano,"Pasta al Diente", "917891428"));

        ArrayList<RestauranteBean> espanioles = new ArrayList<>();
        espanioles.add(new RestauranteBean("Calle Gran Via nº40", R.drawable.restaurante_espaniol,"Restaurante Paco", "917419435"));
        espanioles.add(new RestauranteBean("Calle Gran Via nº45", R.drawable.restaurante_espaniol,"Restaurante random", "919721451"));
        espanioles.add(new RestauranteBean("Calle Gran Via nº50", R.drawable.restaurante_espaniol,"Bar Come", "919414172"));

        ArrayList<RestauranteBean> comidaRapida = new ArrayList<>();
        comidaRapida.add(new RestauranteBean("Calle Gran Via nº108", R.drawable.fastfood,"Burger King", "910317127"));
        comidaRapida.add(new RestauranteBean("Calle Gran Via nº175", R.drawable.fastfood,"McDonalds", "9191034283"));
        comidaRapida.add(new RestauranteBean("Calle Gran Via nº125", R.drawable.fastfood,"Telepizza", "919034725"));

        restaurantesTipo.add(italianos);
        restaurantesTipo.add(espanioles);
        restaurantesTipo.add(comidaRapida);

        Intent intent = getIntent();
        int posicion = intent.getIntExtra("TIPO_KEY", 0);

        ArrayList<RestauranteBean> restaurantes = restaurantesTipo.get(posicion);

        RestaurantesAdapter adapter = new RestaurantesAdapter(ListRestaurantesActivity.this, R.layout.item, restaurantes);

        listRest.setAdapter(adapter);

        listRest.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        RestauranteBean restauranteBean = restaurantesTipo.get(posicion);

        Intent intent = new Intent(ListRestaurantesActivity.this, RestauranteActivity.class);
        intent.putExtra("RESTAURANTE_KEY", restauranteBean);
    }
}
