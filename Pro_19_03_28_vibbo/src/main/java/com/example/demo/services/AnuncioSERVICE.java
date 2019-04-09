package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Anuncio;
import com.example.demo.beans.Categoria;
import com.example.demo.dao.AnunciosRepository;
import com.example.demo.dao.CategoriasRepository;
import com.example.demo.dto.Anuncio_dto;
import com.example.demo.dto.Categoria_dto;
import com.example.demo.interfaces.IAnuncioSERVICE;

@Service
public class AnuncioSERVICE implements IAnuncioSERVICE {
	
	@Autowired
	AnunciosRepository anunciosRepository;

	@Override
	public Anuncio_dto buscaranuncio(int id_anuncio) {
		Optional<Anuncio> anuncio_opt = anunciosRepository.findById(id_anuncio);
		if(anuncio_opt.isPresent()) {
			Anuncio anuncio = anuncio_opt.get();
			Anuncio_dto anuncio_dto = new Anuncio_dto(anuncio.getId_anuncio(), anuncio.getIdcategorias(), anuncio.getId_usuario(), anuncio.getTitulo(), anuncio.getPrecio(), anuncio.getPrioridad(),
					anuncio.getDescripcion(), anuncio.getCategoria(), anuncio.getUsuario());
			return anuncio_dto;
		}
		return null;
	}

	@Override
	public void addanuncio(Anuncio anuncio) {
		// TODO Auto-generated method stub
		anunciosRepository.save(anuncio);
	}

	@Override
	public void borraranuncio(int id_anuncio) {
		// TODO Auto-generated method stub
		anunciosRepository.deleteById(id_anuncio);
	}

	@Override
	public List listaranuncios() {
		List<Anuncio_dto> anuncio_salida = new ArrayList<Anuncio_dto>();
		Iterable<Anuncio> anuncios = anunciosRepository.findAll();
		for (Anuncio anuncio : anuncios) {
			Anuncio_dto anuncio_dto = new Anuncio_dto(anuncio.getId_anuncio(), anuncio.getIdcategorias(), anuncio.getId_usuario(), anuncio.getTitulo(), anuncio.getPrecio(), anuncio.getPrioridad(),
					anuncio.getDescripcion(), anuncio.getCategoria(), anuncio.getUsuario());
			anuncio_salida.add(anuncio_dto);
		}
		return anuncio_salida;
	}

	@Override
	public List buscarByprior(int prioridad) {
		List<Anuncio_dto> anuncio_salida = new ArrayList<Anuncio_dto>();
		List<Anuncio> anuncios = anunciosRepository.findAllByPrioridad(prioridad);
		for (Anuncio anuncio : anuncios) {
			Anuncio_dto anuncio_dto = new Anuncio_dto(anuncio.getId_anuncio(), anuncio.getIdcategorias(), anuncio.getId_usuario(), anuncio.getTitulo(), anuncio.getPrecio(), anuncio.getPrioridad(),
					anuncio.getDescripcion(), anuncio.getCategoria(), anuncio.getUsuario());
			anuncio_salida.add(anuncio_dto);
		}
		return anuncio_salida;
	}

	@Override
	public List buscarbybusqueda(String busqueda) {
		List<Anuncio_dto> anuncios_salida = new ArrayList<Anuncio_dto>();
		List<Anuncio> anuncios = anunciosRepository.findanunciosbybusqueda(busqueda);
		for (Anuncio anuncio : anuncios) {
			Anuncio_dto anuncio_dto = new Anuncio_dto(anuncio.getId_anuncio(), anuncio.getIdcategorias(), anuncio.getId_usuario(), anuncio.getTitulo(), anuncio.getPrecio(), anuncio.getPrioridad(),
					anuncio.getDescripcion(), anuncio.getCategoria(), anuncio.getUsuario());
			anuncios_salida.add(anuncio_dto);
		}
		return anuncios_salida;
	}


}
