package com.example.demo.dto;


import java.util.List;

import com.example.demo.beans.Anuncio;
import com.example.demo.excepciones.ExcepcionDomain;
import com.example.demo.util.Validator;

public class Usuario_dto {
	
	private String id_usuario;
	private String password;
	private String email;
	private String telefono;
	private List<Anuncio> anuncios;
	

	public Usuario_dto(String id_usuario, String password, String email, String telefono, List<Anuncio> anuncios) {
		super();
		this.id_usuario = id_usuario;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.anuncios = anuncios;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		
		this.id_usuario= id_usuario;
		
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		this.password= password;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
			this.email = email;	
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", password=" + password + ", email=" + email + "]";
	}
	
	

}
