package com.ibm.pe.primaxgo.microservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.pe.primaxgo.microservices.dto.CategoriaDTO;
import com.ibm.pe.primaxgo.microservices.dto.ResponseDTO;
import com.ibm.pe.primaxgo.microservices.service.CategoriaService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/api/categoria")
public class CategoriaController {

	private static final Logger LOG = LoggerFactory.getLogger(CategoriaController.class);
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/all")
	@HystrixCommand(fallbackMethod = "faultResponseQuery")
	public @ResponseBody ResponseDTO getAll() {
		ResponseDTO response = new ResponseDTO();
		try {
			List<CategoriaDTO> categorias = service.getListaCategoria();
			response.setErrorCode(0);
			response.setData(categorias);
			response.setErrorMessage("Datos se obtuvieron correctamente");
			response.setHttpCode("" + HttpStatus.OK.value());
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			response.setErrorCode(1);
			response.setErrorMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod = "faultResponseQuery")
	public @ResponseBody ResponseDTO getById(@PathVariable("id") Integer id) {	
		ResponseDTO response = new ResponseDTO();
		try {
			CategoriaDTO categoria = service.getCategoriaById(id);
			response.setErrorCode(0);
			response.setData(categoria);
			response.setErrorMessage("La categoria se obtuvo correctamente");
			response.setHttpCode("" + HttpStatus.OK.value());
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			response.setErrorCode(1);
			response.setErrorMessage(e.getLocalizedMessage());
		}
		return response;
	}
	
	public ResponseDTO faultResponseQuery() {
		return new ResponseDTO(99, "Servicio No disponible", "" + HttpStatus.NOT_FOUND.value(), null);
	}
	
	public ResponseDTO faultResponseQuery(Integer id) {
		return new ResponseDTO(99, "Servicio No disponible id: " + id, "" + HttpStatus.NOT_FOUND.value(), null);
	}
	
	
}
