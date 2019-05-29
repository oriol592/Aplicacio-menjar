package com.example.cep.nyam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.cep.nyam.MainActivity.PAQUET;

public class PantallaPlat extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dades_plat);

		final ImageView imatge = findViewById(R.id.foto_plat);
		final TextView nomPlat = findViewById(R.id.nom_plat);
		final TextView preuPlat = findViewById(R.id.preu_plat);
		final TextView descripcioPlat = findViewById(R.id.descripcio_plat);

		//Poso les dades dins de l'Spinner (desplegable):
		final Spinner spinner = findViewById(R.id.quantitatDesplegable);
		//Utilitzo l'arrayAdapter per defecte per ficar les dades a l'Spinner:
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantitat,
				android.R.layout.simple_spinner_item);
		//Defineixo l'estètica del desplegable:
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Adjudico l'adapter a l'spinner:
		spinner.setAdapter(adapter);

		//Recullo l'intent enviat:
		Intent intent = getIntent();
		//Recullo l'objecte enviat. La string del nom del paquet no cal recollir-la:
		Plat objecteRebut = (Plat)intent.getSerializableExtra(PAQUET);


		//Poso les dades rebudes a l'xml:
		imatge.setImageResource(objecteRebut.getImatge());
		nomPlat.setText(objecteRebut.getNom());
		preuPlat.setText(String.valueOf(objecteRebut.getPreu()));
		descripcioPlat.setText(objecteRebut.getDescripcio());


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//Aquest mètode serveix per col·locar la icona a la barra de menú
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
					//La T de "Toast.make..." ha d'anar amb majúscula, sinó no funciona
					Toast toast = Toast.makeText(getApplicationContext(), "Ja ets a la segona activity", Toast.LENGTH_LONG);
					toast.show();

				return true;

			default:
				// If we got here, the user's action was not recognized.
				// Invoke the superclass to handle it.
				return super.onOptionsItemSelected(item);
		}
	}
}
