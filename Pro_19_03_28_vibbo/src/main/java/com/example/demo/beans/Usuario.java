package com.example.demo.beans;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.excepciones.ExcepcionDomain;
import com.example.demo.util.Validator;
@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	private String id_usuario;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="id_usuario")
	private List<Anuncio> anuncios;

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
		this.id_usuario = id_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", password=" + password + ", email=" + email + ", telefono="
				+ telefono + "]";
	}
	
	
	
	
	
	

}
