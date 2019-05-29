package com.example.cep.nyam;

import java.util.ArrayList;

public class ObtenirDades
{
	public static ArrayList<Plat> getPlats() {
		ArrayList<Plat> llistaPlats = new ArrayList<>();
		llistaPlats.add(new Plat(R.drawable.spaghetti, "Spaghetti carbonara", 8.50, "Ingredients: pasta, parmesà, ou, cansalada"));
		llistaPlats.add(new Plat(R.drawable.pizzavegetal, "Pizza vegetal", 9.80, "Ingredients: carbassó, pebrot, albergínia"));
		llistaPlats.add(new Plat(R.drawable.pizzabarbacoa, "Pizza barbacoa", 10.50, "Ingredients: carn, tomàquet, quètxup"));
		llistaPlats.add(new Plat(R.drawable.pizzaromana, "Pizza romana", 8.90, "Ingredients: olives negres, tàperes, julivert i ceba"));
		llistaPlats.add(new Plat(R.drawable.ravioliformatge, "Ravioli de tres formatges", 12.20,"Ravioli farcits d'Emmental, Cheddar i Roquefort"));
		llistaPlats.add(new Plat(R.drawable.lambrusco, "Ampolla de Lambrusco", 15.0, "Lambrusco d'importació"));

		return llistaPlats;
	}
}
