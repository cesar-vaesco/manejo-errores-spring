package com.vaescode.springboot.error.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vaescode.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = Arrays.asList(new Usuario(1, "César", "Vargas"), new Usuario(2, "Verónica", "Cortez"),
				new Usuario(3, "Raúl", "Lopéz"), new Usuario(4, "Martha", "Cortazar"),
				new Usuario(5, "Selene", "Goméz"), new Usuario(6, "Gloria", "Martínez"),
				new Usuario(7, "Vanessa", "Vargas"));
	}

	@Override
	public List<Usuario> listar() {

		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;  
		
		for (Usuario u : this.lista) {
			
			if(u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}
		
		return resultado;
	}

}
