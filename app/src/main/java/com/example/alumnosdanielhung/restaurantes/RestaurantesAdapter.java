package com.example.alumnosdanielhung.restaurantes;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ALUMNOS on 06/02/2017.
 */
public class RestaurantesAdapter extends ArrayAdapter<RestauranteBean>{

    Context context;
    int resource;
    List<RestauranteBean> objects;

    public RestaurantesAdapter(Context context, int resource, List<RestauranteBean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = convertView;
        ViewHolder viewHolder = new ViewHolder();

        if (item == null) {
            item = inflater.inflate(resource, null);

            viewHolder.imgRestaurante = (ImageView) item.findViewById(R.id.imgRestaurante);
            viewHolder.txtNombre = (TextView) item.findViewById(R.id.txtNombre);
            viewHolder.txtTelefono = (TextView) item.findViewById(R.id.txtTelefono);

            item.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) item.getTag();
        }

        RestauranteBean restauranteBean = objects.get(posicion);

        viewHolder.imgRestaurante.setImageDrawable(ContextCompat.getDrawable(context, restauranteBean.getFoto()));
        viewHolder.txtNombre.setText(restauranteBean.getNombre());
        viewHolder.txtTelefono.setText(restauranteBean.getTelefono());
        return item;
    }

    class ViewHolder{
        ImageView imgRestaurante;
        TextView txtNombre;
        TextView txtTelefono;
    }
}
