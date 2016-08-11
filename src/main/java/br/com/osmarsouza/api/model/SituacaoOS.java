package br.com.osmarsouza.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="situacao_os")
public class SituacaoOS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="situacao_os_id_seq",
    sequenceName="situacao_os_id_seq",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
 	generator="situacao_os_id_seq")
	@Column(updatable=false)	
	private long id;
	
	/*
	@ManyToOne
	@JoinColumn(name="os_id")
	private OS os;
	*/
	private long os_id;
	
	@ManyToOne
	@JoinColumn(name="tipo_situacao_id")
	private TipoSituacao tipoSituacao;
	@ManyToOne
	@JoinColumn(name="tecnico_id")
	private Users tecnico;
	@ManyToOne
	@JoinColumn(name="users_id")	
	private Users usuario;
	private String observacoes;
	
	@Basic(optional=false)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", columnDefinition="Timestamp DEFAULT CURRENT_Timestamp", insertable=false, updatable = false)
	private Date created_at;
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="Timestamp DEFAULT CURRENT_Timestamp")
	private Date updated_at;
	private Date deleted_at;
	
	public SituacaoOS() {
		
	}
	
	public SituacaoOS(long os_id, int tipoSituacao_id, long user_id) {
		this.os_id = os_id;
		this.tipoSituacao = new TipoSituacao(tipoSituacao_id);
		this.usuario = new Users(user_id);
		this.created_at = new Date();
		this.updated_at = new Date();
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	/*
	public OS getOs() {
		return os;
	}
	public void setOs(OS os) {
		this.os = os;
	}
	*/
	public long getOs_id() {
		return os_id;
	}
	
	public void SetOs_id(long os_id) {
		this.os_id = os_id;
	}
	
	public TipoSituacao getTipoSituacao() {
		return tipoSituacao;
	}
	public void setTipoSituacao(TipoSituacao tipoSituacao) {
		this.tipoSituacao = tipoSituacao;
	}
	public Users getTecnico() {
		return tecnico;
	}
	public void setTecnico(Users tecnico) {
		this.tecnico = tecnico;
	}
	public Users getUsuario() {
		return usuario;
	}
	public void setUsuario(Users usuario) {
		this.usuario = usuario;
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
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	
}
