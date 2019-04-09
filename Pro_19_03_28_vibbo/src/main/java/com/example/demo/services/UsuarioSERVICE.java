package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Anuncio;
import com.example.demo.beans.Categoria;
import com.example.demo.beans.Usuario;
import com.example.demo.dao.UsuariosRepository;
import com.example.demo.dto.Anuncio_dto;
import com.example.demo.dto.Categoria_dto;
import com.example.demo.dto.Usuario_dto;
import com.example.demo.interfaces.IUsuarioSERVICE;


@Service
public class UsuarioSERVICE implements IUsuarioSERVICE {
	
	@Autowired
	UsuariosRepository usuariosRepository;

	@Override
	public List<Usuario_dto> listarusuarios() {
		List<Usuario_dto> usuarios_salida_dto = new ArrayList<Usuario_dto>();
		Iterable<Usuario> usuarios = usuariosRepository.findAll();
		for (Usuario usuario : usuarios) {
			Usuario_dto usuario_dto = new Usuario_dto(usuario.getId_usuario(),usuario.getPassword(), usuario.getEmail(), usuario.getTelefono(),usuario.getAnuncios());
			usuarios_salida_dto.add(usuario_dto);
		}
		return usuarios_salida_dto;
	}

	@Override
	public void borrarusuario(String id_usuario) {
		// TODO Auto-generated method stub
		usuariosRepository.deleteById(id_usuario);
	}

	@Override
	public void addusuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuariosRepository.save(usuario);

	}

	@Override
	public Usuario_dto buscar_id(String id_usuario) {
		Optional<Usuario> usuario = usuariosRepository.findById(id_usuario);
		if(usuario.isPresent()) {
			Usuario uaux = usuario.get();
			Usuario_dto usuario_dto = new Usuario_dto(uaux.getId_usuario(),uaux.getPassword(),uaux.getEmail(),uaux.getTelefono(),uaux.getAnuncios());
			return usuario_dto;
		}
		return null;
	}


	@Override
	public List<Anuncio_dto> listaranunciosDeusuario(String id_usuario) {
		List<Anuncio_dto> anuncios_salida = new ArrayList<Anuncio_dto>();
		Optional<Usuario> usuarios = usuariosRepository.findById(id_usuario);
		if(usuarios.isPresent()) {
			Usuario uaux = usuarios.get();
			List<Anuncio> anuncios = uaux.getAnuncios();
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
