package br.com.osmarsouza.api.repository;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipogarantia") 
public class TipoGarantia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	private String tipogarantia;
	private Date created_at;
	private Date updated_at;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipogarantia() {
		return tipogarantia;
	}
	public void setTipogarantia(String tipogarantia) {
		this.tipogarantia = tipogarantia;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
