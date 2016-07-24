package br.com.osmarsouza.api.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.osmarsouza.api.repository.TipoGarantia;

@Entity
public class OS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	@ManyToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name="aparelho_id")
	private Aparelho aparelho;
	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marca;	
	private String modelo;
	@Column(name="numeroserie")
	private String numerSerie;
	@Column(name="defeitoreclamado")
	private String defeitoReclamado;
	private String retirado;
	@ManyToOne
	@JoinColumn(name="tipogarantia_id")
	private TipoGarantia tipoGarantia;
	@Column(nullable = true)
	private Integer os_anterior_id;
	private String notafiscal;
	private String observacoes;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	
	@ManyToMany
	@JoinTable(name="situacao_os", joinColumns=
	{@JoinColumn(name="os_id")}, inverseJoinColumns=
  	{@JoinColumn(name="id")})
	private List<SituacaoOS> situacoes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Aparelho getAparelho() {
		return aparelho;
	}
	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumerSerie() {
		return numerSerie;
	}
	public void setNumerSerie(String numerSerie) {
		this.numerSerie = numerSerie;
	}
	public String getDefeitoReclamado() {
		return defeitoReclamado;
	}
	public void setDefeitoReclamado(String defeitoReclamado) {
		this.defeitoReclamado = defeitoReclamado;
	}
	public String getRetirado() {
		return retirado;
	}
	public void setRetirado(String retirado) {
		this.retirado = retirado;
	}
	public TipoGarantia getTipoGarantia() {
		return tipoGarantia;
	}
	public void setTipoGarantia(TipoGarantia tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}
	public Integer getOs_anterior_id() {
		return os_anterior_id;
	}
	public void setOs_anterior_id(Integer os_anterior_id) {
		this.os_anterior_id = os_anterior_id;
	}
	public String getNotafiscal() {
		return notafiscal;
	}
	public void setNotafiscal(String notafiscal) {
		this.notafiscal = notafiscal;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
	public void setUpdated_at(Date updatad_at) {
		this.updated_at = updatad_at;
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
	
	public List<SituacaoOS> getSituacoes() {
		return situacoes;
	}
	public void setSituacoes(List<SituacaoOS> situacoes) {
		this.situacoes = situacoes;
	}
	
}
