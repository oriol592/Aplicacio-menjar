package com.example.cep.nyam;

import java.io.Serializable;

public class Plat implements Serializable
{
	private int imatge;
	private String nom;
	private double preu;
	private String descripcio;

	public Plat(int img, String nom, double preu, String descr) {
		this.imatge = img;
		this.nom = nom;
		this.preu = preu;
		this.descripcio = descr;
	}

	public int getImatge() {
		return imatge;
	}

	public String getNom() {
		return nom;
	}

	public double getPreu() { return preu; }

	public String getDescripcio() {
		return descripcio;
	}
}
