package com.example.demo.dto;

import com.example.demo.beans.Categoria;
import com.example.demo.beans.Usuario;

public class Anuncio_dto {
	
	private int id_anuncio;
	
	
	private int idcategorias;
	
	
	private String id_usuario;
	
	
	private String titulo;
	
	
	private Double precio;
	
	
	private int prioridad;
	
	
	private String descripcion;
	
	
	private Categoria categoria;
	
	
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

	public Anuncio_dto(int id_anuncio, int idcategorias, String id_usuario, String titulo, Double precio, int prioridad,
			String descripcion, Categoria categoria, Usuario usuario) {
		super();
		this.id_anuncio = id_anuncio;
		this.idcategorias = idcategorias;
		this.id_usuario = id_usuario;
		this.titulo = titulo;
		this.precio = precio;
		this.prioridad = prioridad;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.usuario = usuario;
	}
	
	
	
	
	

}