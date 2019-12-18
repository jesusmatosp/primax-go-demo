package com.ibm.pe.primaxgo.microservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.pe.primaxgo.microservices.dto.CategoriaDTO;
import com.ibm.pe.primaxgo.microservices.exception.CategoriaNotFoundException;
import com.ibm.pe.primaxgo.microservices.exception.CategoriaParamEmptyException;
import com.ibm.pe.primaxgo.microservices.model.Categoria;
import com.ibm.pe.primaxgo.microservices.repository.CategoriaRepository;

@Service
public class CategoriaService {

	 private static final Logger LOG = LoggerFactory.getLogger(CategoriaService.class); 
	
	 @Autowired
	 private CategoriaRepository repository;
	 
	 public List<CategoriaDTO> getListaCategoria() throws Exception {
		 List<CategoriaDTO> list = new ArrayList<CategoriaDTO>();
		 try {
			List<Categoria> categorias = repository.findAll();
			categorias.forEach( categoria -> {
				try {
					CategoriaDTO categoriaDTO = new CategoriaDTO();
					BeanUtils.copyProperties(categoriaDTO, categoria);
					list.add(categoriaDTO);
				} catch (Exception e) {
					LOG.error(e.getLocalizedMessage(), e.getCause());
				}
			});
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
		}
		 return list;
	 }
	 
	 public CategoriaDTO getCategoriaById(Integer id) throws CategoriaParamEmptyException, CategoriaNotFoundException, Exception {
		 CategoriaDTO categoriaDTO = null;
		 try {
			if(id == null) throw new CategoriaParamEmptyException("El campo identificador no puede estar vacío");
			Optional<Categoria> oCategoria = repository.findById(id);
			if(oCategoria == null || oCategoria.isPresent() == false) throw new CategoriaNotFoundException("No se encontró la categoría solicitada");
			Categoria categoria = oCategoria.get();
			categoriaDTO = new CategoriaDTO();
			BeanUtils.copyProperties(categoriaDTO, categoria);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e.getCause());
			throw new Exception(e.getLocalizedMessage(), e.getCause());
		}
		 return categoriaDTO;
	 }
	 
	
}
