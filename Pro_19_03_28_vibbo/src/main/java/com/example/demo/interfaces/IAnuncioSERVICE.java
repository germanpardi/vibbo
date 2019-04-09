package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.beans.Anuncio;
import com.example.demo.dto.Anuncio_dto;





public interface IAnuncioSERVICE {
	
	public Anuncio_dto buscaranuncio(int id_anuncio);
	public void addanuncio(Anuncio anuncio);
	public void borraranuncio(int id_anuncio);
	public List listaranuncios();
	public List buscarByprior(int prioridad);
	public List buscarbybusqueda(String busqueda);
}
