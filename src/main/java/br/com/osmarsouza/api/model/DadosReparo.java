package br.com.osmarsouza.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dadosreparo") 
public class DadosReparo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="dadosreparo_id_seq",
     sequenceName="dadosreparo_id_seq",
     allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
  	generator="dadosreparo_id_seq")
	@Column(updatable=false)
	private long id;
	private long os_id;
	private String descricao;
	private BigDecimal valorservico;
	private BigDecimal valorpecas;
	private BigDecimal taxatransporte;
	private long users_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="Timestamp DEFAULT CURRENT_Timestamp", insertable=false, updatable = false)
	private Date created_at;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="Timestamp DEFAULT CURRENT_Timestamp", insertable=false, updatable = false)
	private Date updated_at;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deleted_at;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOs_id() {
		return os_id;
	}
	public void setOs_id(long os_id) {
		this.os_id = os_id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValorservico() {
		return valorservico;
	}
	public void setValorservico(BigDecimal valorservico) {
		this.valorservico = valorservico;
	}
	public BigDecimal getValorpecas() {
		return valorpecas;
	}
	public void setValorpecas(BigDecimal valorpecas) {
		this.valorpecas = valorpecas;
	}
	public BigDecimal getTaxatransporte() {
		return taxatransporte;
	}
	public void setTaxatransporte(BigDecimal taxatransporte) {
		this.taxatransporte = taxatransporte;
	}
	public long getUsers_id() {
		return users_id;
	}
	public void setUsers_id(long users_id) {
		this.users_id = users_id;
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
	public Date getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}


