package com.vaescode.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vaescode.springboot.error.app.errors.UsuarioNoEncontradoException;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticError(ArithmeticException ex, Model model) {
		
		model.addAttribute("error", "Error de aritmetica");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatException(NumberFormatException ex, Model model) {
		
		model.addAttribute("error", "Formato númerico inválido!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/formato-numero";
	}
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String usuarioNoEncontradoExceptionn(UsuarioNoEncontradoException ex, Model model) {
		
		model.addAttribute("error", "Usuario no encontrado!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/usuario-no-encontrado";
	}
	


}
