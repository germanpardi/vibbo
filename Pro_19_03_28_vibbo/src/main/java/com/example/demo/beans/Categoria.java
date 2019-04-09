package com.example.demo.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id
	@Column(name="idcategorias")
	private int idcategorias;
	
	@Column(name="descripcion")
	private String Descripcion;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="idcategorias")
	private List<Anuncio> anuncios;

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}
	
	public void setProductos(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}
	
	public int getIdcategorias() {
		return idcategorias;
	}
	public void setIdcategorias(int idcategorias) {
		this.idcategorias = idcategorias;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Categoria [idcategorias=" + idcategorias + ", Descripcion=" + Descripcion + "]";
	}
	
		
	

}
