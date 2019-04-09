package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.beans.Anuncio;
import com.example.demo.beans.Categoria;
import com.example.demo.dto.Anuncio_dto;

public interface AnunciosRepository extends CrudRepository<Anuncio, Integer> {
	List<Anuncio> findAllByPrioridad(int prioridad);
	
	@Query(value="SELECT * FROM ANUNCIOS WHERE DESCRIPCION LIKE %:busqueda% OR TITULO LIKE %:busqueda%", nativeQuery=true)
	public List<Anuncio> findanunciosbybusqueda(@Param("busqueda") String busqueda);
}
