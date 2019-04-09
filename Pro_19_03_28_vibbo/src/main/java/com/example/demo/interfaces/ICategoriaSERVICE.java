package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.beans.Categoria;
import com.example.demo.dto.Anuncio_dto;
import com.example.demo.dto.Categoria_dto;



public interface ICategoriaSERVICE {
	
	public List<Categoria_dto> listarcategorias();
	public void borrarcategoria(int idcategorias);
	public void addcategoria(Categoria categoria);
	public Categoria_dto buscar_id(int idcategorias);
	
	public List<Anuncio_dto> listaranunciosDecategoria(int idcategorias);

}
