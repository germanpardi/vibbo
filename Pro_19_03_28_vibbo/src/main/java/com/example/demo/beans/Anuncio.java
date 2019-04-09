package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="anuncios")
public class Anuncio {
	@Id
	@Column(name="id_anuncio")
	private int id_anuncio;
	
	@Column(name="idcategorias")
	private int idcategorias;
	
	@Column(name="id_usuario")
	private String id_usuario;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="prioridad")
	private int prioridad;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="idcategorias",insertable = false, updatable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="id_usuario",insertable = false, updatable = false)
	private Usuario usuario;

	public int getId_anuncio() {
		return id_anuncio;
	}

	public void setId_anuncio(int id_anuncio) {
		this.id_anuncio = id_anuncio;
	}

	public int getIdcategorias() {
		return idcategorias;
	}

	public void setIdcategorias(int idcategorias) {
		this.idcategorias = idcategorias;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Anuncio [id_anuncio=" + id_anuncio + ", idcategorias=" + idcategorias + ", id_usuario=" + id_usuario
				+ ", titulo=" + titulo + ", precio=" + precio + ", prioridad=" + prioridad + ", descripcion="
				+ descripcion + ", categoria=" + categoria + ", usuario=" + usuario + "]";
	}
	
	
	
	

}
