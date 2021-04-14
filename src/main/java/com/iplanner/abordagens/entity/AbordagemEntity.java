package com.iplanner.abordagens.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.iplanner.abordagens.model.Abordagem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("tb_abordagem")
public class AbordagemEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column("cd_abordagem")
	private Integer cdAbordagem;
	
	@Column("ds_abordagem")
	private String dsAbordagem;
	
	@Column("dt_abordagem")
	private LocalDate dtAbordagem;
	
	@Column("ds_chavefamrepr")
	private String dsChaveFamRepR;
	
	@Column("nm_repfamilia")
	private String nmFamiliar;
	
	@Column("classificacao")
	private Integer classificacao;
	
	public AbordagemEntity (Abordagem abordagem) {
		super();
		this.cdAbordagem = abordagem.getCdAbordagem();
		this.dsAbordagem = abordagem.getDsAbordagem();
		this.dtAbordagem = abordagem.getDtAbordagem();
		this.dsChaveFamRepR = abordagem.getDsChaveFamRepR();
		this.nmFamiliar = abordagem.getNmFamiliar();
		this.classificacao = abordagem.getClassificacao();
	}
	
}
