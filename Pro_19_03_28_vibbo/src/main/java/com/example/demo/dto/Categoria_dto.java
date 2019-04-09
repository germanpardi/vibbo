package com.example.demo.dto;

public class Categoria_dto {
	private int idcategorias;
	private String Descripcion;
	
	
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
	public Categoria_dto(int idcategorias, String descripcion) {
		super();
		this.idcategorias = idcategorias;
		Descripcion = descripcion;
	}
	
	
		
	

}
