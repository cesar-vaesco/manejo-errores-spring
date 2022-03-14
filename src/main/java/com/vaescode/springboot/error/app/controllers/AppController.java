package com.vaescode.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vaescode.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.vaescode.springboot.error.app.models.domain.Usuario;
import com.vaescode.springboot.error.app.service.UsuarioService;

@Controller
public class AppController {

	@Autowired
	private UsuarioService service;

	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {

		Integer valor = 100 / 0;
		// Integer valor = Integer.parseInt("10x");
		return "index";
	}

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {

		Usuario usuario = service.obtenerPorId(id);

		if (usuario == null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: " + usuario.getNombre());
		model.addAttribute("detalle", "Detalle usuario: ".concat(usuario.getNombre()));

		return "ver";

	}

}
