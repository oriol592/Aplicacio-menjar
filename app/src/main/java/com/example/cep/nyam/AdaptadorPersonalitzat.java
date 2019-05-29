package com.example.cep.nyam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonalitzat extends ArrayAdapter<Plat>
{
	private ArrayList<Plat> llistaPlats;

	public AdaptadorPersonalitzat(Context context, ArrayList<Plat> llistaPlats) {
		super(context, R.layout.plat, llistaPlats);
		this.llistaPlats = llistaPlats;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
	{
		//Creo l'inflater i la view:
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View item = inflater.inflate(R.layout.plat, null);

		//Recupero l'element a la posició corresponent:
		Plat platVisualitzar = llistaPlats.get(position);

		/*Poso la imatge a cada element*/
		ImageView imatge = item.findViewById(R.id.imatge_plat);
		imatge.setImageResource(platVisualitzar.getImatge());

		/*Poso el nom a cada element*/
		TextView nom = item.findViewById(R.id.nom);
		nom.setText(platVisualitzar.getNom());

		//Poso els ingredients a cada element:
		TextView ingredients = item.findViewById(R.id.ingredients);
		ingredients.setText(platVisualitzar.getDescripcio());

		return item;
	}


}
