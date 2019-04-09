package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Anuncio;
import com.example.demo.beans.Categoria;
import com.example.demo.beans.Usuario;
import com.example.demo.dto.Anuncio_dto;
import com.example.demo.dto.Usuario_dto;
import com.example.demo.interfaces.IAnuncioSERVICE;
import com.example.demo.interfaces.ICategoriaSERVICE;
import com.example.demo.interfaces.IUsuarioSERVICE;




@Controller
@RequestMapping("/user")
public class Controlador_usuario {
	
	@Autowired
	ICategoriaSERVICE catservice;
	
	@Autowired
	IAnuncioSERVICE anservice;
	
	@Autowired
	IUsuarioSERVICE uservice;
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "login";
	}
	@RequestMapping("/entrar")
	public String entrar(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		String siguientepagina="";
		String mensaje="";
		
		String id_usuario= request.getParameter("id_usuario");
		String password = request.getParameter("password");
		Usuario_dto aux = uservice.buscar_id(id_usuario);
		
		if(aux==null) {
			siguientepagina = "login";
			mensaje="El usuario no existe, seleccione la opción "+"Registrarse "+" para crear un nuevo usuario.";
			request.setAttribute("mensaje", mensaje);
			return siguientepagina;
		}
		if ((id_usuario.equals(aux.getId_usuario()))&&(password.equals(aux.getPassword()))) {
			siguientepagina= "perfiluser";
			
			session.setAttribute("id_usuario", id_usuario);
			session.setAttribute("anuncios", aux.getAnuncios());
			session.setAttribute("email", aux.getEmail());
			session.setAttribute("telefono", aux.getTelefono());
			return siguientepagina;
		}else {
			siguientepagina = "login";
			mensaje="Password incorrecta.";
			request.setAttribute("mensaje", mensaje);
			return siguientepagina;
		}	
		
	}
	@RequestMapping("/registro")
	public String registro(HttpServletRequest request) {
		return "registro";
	}
	@RequestMapping("/registrar")
	public String registrar(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String siguientepagina= "";
		String mensaje1 = "";
		String id_usuario= request.getParameter("id_usuario");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		List<Anuncio> anuncios = new ArrayList<Anuncio>(); 
		Usuario usuario = new Usuario();
		
		usuario.setId_usuario(id_usuario);
		usuario.setPassword(password);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		
		session.setAttribute("email", email);
		session.setAttribute("telefono", telefono);
		//usuario.setAnuncios(anuncios);
		Usuario_dto aux = uservice.buscar_id(id_usuario);
		
		if (aux == null) {
			uservice.addusuario(usuario);
			mensaje1 = "El usuario se ha creado correctamente";
			request.setAttribute("mensaje1", mensaje1);
			return "login";
		}else {
			mensaje1 = "El usuario ya existe, intente con otro";
			request.setAttribute("mensaje1", mensaje1);
			return "registro";
		}
		
	}
	@RequestMapping("/perfiluser")
	public String perfiluser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		 List<Anuncio_dto> anuncios = uservice.listaranunciosDeusuario((String) session.getAttribute("id_usuario"));
		 session.setAttribute("anuncios", anuncios);
		
		return "perfiluser";
	}
	@RequestMapping("/anunciouser")
	public String anunciouser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String id_anuncio = request.getParameter("id_anuncio");
		String titulo =  request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		
		session.setAttribute("anunciouser", anservice.buscaranuncio(Integer.parseInt(id_anuncio)));
		session.setAttribute("titulo", titulo);
		session.setAttribute("descripcion", descripcion);
		session.setAttribute("precio", precio);
		session.setAttribute("id_anuncio", id_anuncio);
		return "anunciouser";
	}
	
	@RequestMapping("/modifyanuncio")
	public String modifyanuncio(HttpServletRequest request) {
		//HttpSession session = request.getSession(true);
		return "modifyanuncio";
	}
	@RequestMapping("/modificar")
	public String modificar(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		String titulo =  request.getParameter("titulo");
		String idcategorias = request.getParameter("idcategorias");
		String descripcion = request.getParameter("descripcion");
		String prioridad = request.getParameter("prioridad");
		String precio = request.getParameter("precio");
		String mensaje2 = "";
		System.out.println(idcategorias);
		
		Anuncio_dto adto = (Anuncio_dto)session.getAttribute("anunciouser");
		Anuncio aux = new Anuncio();
		aux.setId_usuario(adto.getId_usuario());
		aux.setId_anuncio(adto.getId_anuncio());
		aux.setTitulo(titulo);
		aux.setIdcategorias(Integer.parseInt(idcategorias));
		aux.setDescripcion(descripcion);
		aux.setPrioridad(Integer.parseInt(prioridad));
		aux.setPrecio(Double.parseDouble(precio));
		aux.setCategoria(adto.getCategoria());
		aux.setUsuario(adto.getUsuario());
		anservice.addanuncio(aux);
		mensaje2= "El anuncio se ha modificado exitosamente";
		request.setAttribute("mensaje2", mensaje2);
		
		return "modifyanuncio";
	}
	@RequestMapping("/eliminar")
	public String eliminar(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String id_anuncio = (String) session.getAttribute("id_anuncio");
		String mensaje3= "Se ha eliminado correctamente el anuncio";
		anservice.borraranuncio(Integer.parseInt(id_anuncio));
		request.setAttribute("mensaje3", mensaje3);
		return "anunciouser";
	}
	@RequestMapping("/crearanuncio")
	public String crearanuncio(HttpServletRequest request) {
		//HttpSession session = request.getSession(true);
		return "crearanuncio";
	}	
	@RequestMapping("/actioncrear")
	public String actioncrear(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		String titulo =  request.getParameter("titulo");
		String idcategorias = request.getParameter("idcategorias");
		String descripcion = request.getParameter("descripcion");
		String prioridad = request.getParameter("prioridad");
		String precio = request.getParameter("precio");
		String mensaje3 = "";
		String id_usuario = (String) session.getAttribute("id_usuario");
		System.out.println(idcategorias);
		
		//Anuncio_dto adto = (Anuncio_dto)session.getAttribute("anunciouser");
		Anuncio aux = new Anuncio();
		aux.setId_usuario(id_usuario);
		aux.setTitulo(titulo);
		aux.setIdcategorias(Integer.parseInt(idcategorias));
		aux.setDescripcion(descripcion);
		aux.setPrioridad(Integer.parseInt(prioridad));
		aux.setPrecio(Double.parseDouble(precio));
		
		anservice.addanuncio(aux);
		mensaje3= "El anuncio se ha creado exitosamente";
		request.setAttribute("mensaje3", mensaje3);
		
		return "crearanuncio";
	}
	
	
	
	
	
	
	
	
	
	
	

}	
