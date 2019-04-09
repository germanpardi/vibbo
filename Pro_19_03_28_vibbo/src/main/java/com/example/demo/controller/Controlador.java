package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Usuario;
import com.example.demo.dto.Anuncio_dto;
import com.example.demo.dto.Usuario_dto;
import com.example.demo.interfaces.IAnuncioSERVICE;
import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.interfaces.IUsuarioSERVICE;


@Controller
public class Controlador {
	
	@Autowired
	ICategoriaSERVICE catservice;
	
	@Autowired
	IAnuncioSERVICE anservice;
	
	@Autowired
	IUsuarioSERVICE uservice;
	
	@RequestMapping("/INDEX2")
	public String INDEX2(HttpServletRequest request) {
		request.setAttribute("categorias", catservice.listarcategorias());
		request.setAttribute("anunciosprior", anservice.buscarByprior(1));
		return "INDEX2";
	}
	@RequestMapping("/index")
	public String inicio(HttpServletRequest request) {
		request.setAttribute("categorias", catservice.listarcategorias());
		request.setAttribute("anunciosprior", anservice.buscarByprior(1));
		return "index";
	}
	
	@RequestMapping("/buscaranuncios")
	public String buscaranuncios(HttpServletRequest request) {
		String busqueda = request.getParameter("busqueda");
		System.out.println(busqueda);
		List<Anuncio_dto> anun_busq = anservice.buscarbybusqueda(busqueda);
		request.setAttribute("anun_busq", anun_busq);
		return "anunciosbusqueda";
	}
	
	
	@RequestMapping("/anuncioprior")
	public String anuncioprior(HttpServletRequest request) {
		String id_anuncio = request.getParameter("id_anuncio");
		Anuncio_dto aprior = anservice.buscaranuncio(Integer.parseInt(id_anuncio));
		request.setAttribute("anuncioprior", anservice.buscaranuncio(Integer.parseInt(id_anuncio)));
		String id_usuario = aprior.getId_usuario();
		Usuario_dto user = uservice.buscar_id(id_usuario);
		request.setAttribute("id_usuario", uservice.buscar_id(id_usuario));
		request.setAttribute("telefono", user.getTelefono());
		request.setAttribute("email", user.getEmail());
		return "anuncioprior";
	}
	
	@RequestMapping("/anuncioscategoria")
	public String anunciocat(HttpServletRequest request) {
		String dcat = request.getParameter("descripcioncategoria");
		int idcategorias = Integer.parseInt(request.getParameter("idcategorias"));
		request.setAttribute("anuncios", catservice.listaranunciosDecategoria(idcategorias));
		request.setAttribute("descripcioncategoria", dcat);
		return "anuncioscategoria";
	}


}
