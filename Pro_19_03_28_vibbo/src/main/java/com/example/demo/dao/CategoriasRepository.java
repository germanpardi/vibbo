package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.Categoria;


public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {

}
