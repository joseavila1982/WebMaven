package com.webmaven.entity;

public class Usuario {

	private int num;
	private String nombre;
	private String login;
	private String area;
	private String usuarioAlterno;

	
	public Usuario(int num, String nombre, String login, String area, String usuarioAlterno) {
		super();
		this.num = num;
		this.nombre = nombre;
		this.login = login;
		this.area = area;
		this.usuarioAlterno = usuarioAlterno;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUsuarioAlterno() {
		return usuarioAlterno;
	}

	public void setUsuarioAlterno(String usuarioAlterno) {
		this.usuarioAlterno = usuarioAlterno;
	}

	
	
}
