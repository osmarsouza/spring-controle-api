package br.com.osmarsouza.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class PessoaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private BigInteger qtdOS;
	private String cpfCnpj;
	
	public PessoaDTO() {
    }

	public PessoaDTO(Integer id, String nome, String cpfCnpj, BigInteger qtdOS) {
        this.id = id;
        this.nome = nome;
        this.qtdOS = qtdOS;
        this.cpfCnpj = cpfCnpj;
        
    }

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigInteger getQtdOS() {
		return qtdOS;
	}
	public void setQtdOS(BigInteger qtdOS) {
		this.qtdOS = qtdOS;
	}
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
}
