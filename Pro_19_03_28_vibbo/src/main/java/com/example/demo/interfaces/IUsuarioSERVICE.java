package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.beans.Usuario;
import com.example.demo.dto.Anuncio_dto;
import com.example.demo.dto.Usuario_dto;



public interface IUsuarioSERVICE {
	
	public List<Usuario_dto> listarusuarios();
	public void borrarusuario(String id_usuario);
	public void addusuario(Usuario usuario);
	public Usuario_dto buscar_id(String id_usuario);
	public List<Anuncio_dto> listaranunciosDeusuario(String id_usuario);

}
