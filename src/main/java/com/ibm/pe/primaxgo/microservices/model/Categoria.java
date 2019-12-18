package com.ibm.pe.primaxgo.microservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "categoria" )
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id" )
	private Integer id;
	
	@Column( name = "codigo" )
	private String codigo;
	
	@Column( name = "estado" )
	private String estado;
	
	@Column( name = "fechacreacion" )
	private Date fechacreacion;
	
	@Column( name = "fechamodificacion" )
	private Date fechamodificacion;
	
	@Column( name = "nombre" )
	private String nombre;
	
	@Column( name = "usernamecreacion" )
	private String usuariocreacion;
	
	@Column( name = "usernamemodificacion" )
	private String usuariomodificacion;
	
	@Column( name = "imagen" )
	private String imagen;
	
	@Column( name = "orden" )
	private Integer orden;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public Date getFechamodificacion() {
		return fechamodificacion;
	}
	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuariocreacion() {
		return usuariocreacion;
	}
	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}
	public String getUsuariomodificacion() {
		return usuariomodificacion;
	}
	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}
