package com.example.cep.nyam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity
{

	public static final String PAQUET = "com.example.cep.nyam";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ListView llistaPlats = findViewById(R.id.llistaMenjar);

		//Creo un nou adaptador(que és classe filla de ArrayAdapter), i li passo les dades que jo vull:
		AdaptadorPersonalitzat adapter = new AdaptadorPersonalitzat(this, ObtenirDades.getPlats());
		llistaPlats.setAdapter(adapter);

		llistaPlats.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
			{
				//Recupero l'objecte clicat:
				Plat platClicat = (Plat)llistaPlats.getItemAtPosition(i);

				//Creo l'intent. El primer paràmetre és l'origen, i el segon el destí:
				Intent intent = new Intent(MainActivity.this, PantallaPlat.class);

				//Poso una constant amb info de l'origen, i després l'objecte a enviar:
				/*Perquè funcioni amb un objecte creat per mi (i que no siguin tot strings), és
				 * fer que l'objecte a enviar sigui classe filla de Serializable. Llavors el deixa
				 * enviar. Per rebre'l s'ha de fer amb el getSerializableExtra
				 * Font: https://stackoverflow.com/questions/2736389/how-to-pass-an-object-from-one-activity-to-another-on-android
				 * */
				intent.putExtra(PAQUET, platClicat);
				//Inicio la nova activitat:
				startActivity(intent);
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*Aquest mètode serveix per col·locar la icona a la barra de menú.
		S'ha de posar aquest mètode i el següent a cada activity on volem que surti el botó a la barra.

		Pàgina d'on he tret aquest mètode i el següent:
		https://www.journaldev.com/9357/android-actionbar-example-tutorial */
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//Aquest mètode serveix per donar funcionalitat al botó de la barra superior:
		switch (item.getItemId())
		{
			case R.id.botoFletxa:
					Plat platPerDefecte = new Plat(R.drawable.spaghetti, "Spaghetti carbonara", 8.50, "Ingredients: pasta, parmesà, ou, cansalada");
					Intent intent = new Intent(MainActivity.this, PantallaPlat.class);
					intent.putExtra(PAQUET, platPerDefecte);
					startActivity(intent);

				return true;

			default:
				// If we got here, the user's action was not recognized.
				// Invoke the superclass to handle it.
				return super.onOptionsItemSelected(item);

		}
	}
}
