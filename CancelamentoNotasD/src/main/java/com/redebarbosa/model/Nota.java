package com.redebarbosa.model;

import java.io.Serializable;



public class Nota implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer numero;
	private Integer serie;
	private Integer empresa;
	private Integer mesMov;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getSerie() {
		return serie;
	}
	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	public Integer getMesMov() {
		return mesMov;
	}
	public void setMesMov(Integer mesMov) {
		this.mesMov = mesMov;
	}
}
