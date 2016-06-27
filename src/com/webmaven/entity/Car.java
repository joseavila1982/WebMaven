package com.webmaven.entity;

public class Car {

	private String id;
	private int ano;
	private String marca;
	private String color;
	

	public Car(String id, int ano, String marca, String color) {
		super();
		this.id = id;
		this.ano = ano;
		this.marca = marca;
		this.color = color;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
	
}
