package br.com.osmarsouza.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="os_id_seq",
     sequenceName="os_id_seq",
     allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
  	generator="os_id_seq")
	@Column(updatable=false)
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
	private String numeroserie;
	@Column(name="defeitoreclamado")
	private String defeitoreclamado;
	@Column(name="retirado", columnDefinition="String DEFAULT 'N'")
	private String retirado;
	@ManyToOne
	@JoinColumn(name="tipogarantia_id")
	private TipoGarantia tipoGarantia;
	@Column(nullable = true)
	private Integer os_anterior_id;
	private String notafiscal;
	private String observacoes;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="Timestamp DEFAULT CURRENT_Timestamp", insertable=false, updatable = false)
	private Date created_at;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="Timestamp DEFAULT CURRENT_Timestamp", insertable=false)
	private Date updated_at;
	@Temporal(TemporalType.TIMESTAMP)
	private Date deleted_at;
	
	/*
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="situacao_os", joinColumns=
	{@JoinColumn(name="os_id")}, inverseJoinColumns=
  	{@JoinColumn(name="id")})
	private List<SituacaoOS> situacoes;
	*/
	
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
	public String getNumeroSerie() {
		return numeroserie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroserie = numeroSerie;
	}
	public String getDefeitoReclamado() {
		return defeitoreclamado;
	}
	public void setDefeitoReclamado(String defeitoReclamado) {
		this.defeitoreclamado = defeitoReclamado;
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
	
	/*
	public List<SituacaoOS> getSituacoes() {
		return situacoes;
	}
	public void setSituacoes(List<SituacaoOS> situacoes) {
		this.situacoes = situacoes;
	}
	*/
	
}
