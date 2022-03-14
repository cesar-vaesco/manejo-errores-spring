package com.vaescode.springboot.error.app.service;

import java.util.List;

import com.vaescode.springboot.error.app.models.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> listar();

	public Usuario obtenerPorId(Integer id);

}
