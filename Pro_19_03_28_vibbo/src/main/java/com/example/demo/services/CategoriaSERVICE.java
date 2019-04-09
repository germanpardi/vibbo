package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Anuncio;
import com.example.demo.beans.Categoria;

import com.example.demo.beans.Usuario;
import com.example.demo.dao.CategoriasRepository;
import com.example.demo.dto.Anuncio_dto;
import com.example.demo.dto.Categoria_dto;
import com.example.demo.interfaces.ICategoriaSERVICE;

@Service
public class CategoriaSERVICE implements ICategoriaSERVICE {
	
	@Autowired
	CategoriasRepository categoriasRepository;

	@Override
	public List<Categoria_dto> listarcategorias() {
		//List<Categoria> categorias_salida = new ArrayList<Categoria>();
		List<Categoria_dto> categorias_salida_dto = new ArrayList<Categoria_dto>();
		Iterable<Categoria> categorias = categoriasRepository.findAll();
		for (Categoria categoria : categorias) {
			Categoria_dto categoria_dto = new Categoria_dto(categoria.getIdcategorias(),categoria.getDescripcion());
			categorias_salida_dto.add(categoria_dto);
		}
		return categorias_salida_dto;
		
	}

	@Override
	public void borrarcategoria(int idcategorias) {
		// TODO Auto-generated method stub
		categoriasRepository.deleteById(idcategorias);
	}

	@Override
	public void addcategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriasRepository.save(categoria);
	}
	
	@Override
	public Categoria_dto buscar_id(int idcategorias) {
		Optional<Categoria> categoria = categoriasRepository.findById(idcategorias);
		if(categoria.isPresent()) {
			Categoria cataux = categoria.get();
			Categoria_dto categoria_dto = new Categoria_dto(cataux.getIdcategorias(),cataux.getDescripcion());
			return categoria_dto;
		}
		return null;
	}
	

	

	@Override
	public List<Anuncio_dto> listaranunciosDecategoria(int idcategorias) {
		List<Anuncio_dto> anuncios_salida = new ArrayList<Anuncio_dto>();
		Optional<Categoria> categorias = categoriasRepository.findById(idcategorias);
		if(categorias.isPresent()) {
			Categoria cataux = categorias.get();
			List<Anuncio> anuncios = cataux.getAnuncios();
			for (Anuncio anuncio : anuncios) {
				Anuncio_dto anuncio_dto = new Anuncio_dto(anuncio.getId_anuncio(), anuncio.getIdcategorias(), anuncio.getId_usuario(), anuncio.getTitulo(), anuncio.getPrecio(), anuncio.getPrioridad(),
			anuncio.getDescripcion(), anuncio.getCategoria(), anuncio.getUsuario());
				anuncios_salida.add(anuncio_dto);
				
			}
			return anuncios_salida;
		}
		return null;
	}

}
