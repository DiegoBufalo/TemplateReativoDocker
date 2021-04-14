package com.iplanner.abordagens.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.iplanner.abordagens.entity.AbordagemEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Abordagem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer cdAbordagem;
	
	@Size(max = 255,message = "descricao ultrapassou 255 caracteres")
	@NotBlank(message = "campo descricao nao pode ser vazio")
	@NotNull(message = "campo descricao nao pode ser nulo")
	private String dsAbordagem;
	
	private LocalDate dtAbordagem;
	
	@NotBlank(message = "campo ChaveFamRepR nao pode ser vazio")
	@NotNull(message = "campo ChaveFamRepR nao pode ser nulo")
	private String dsChaveFamRepR;
	
	@NotBlank(message = "campo nmFamiliar nao pode ser vazio")
	@NotNull(message = "campo nmFamiliar nao pode ser nulo")
	private String nmFamiliar;
	
	private Integer classificacao;
	
	
	public static AbordagemEntity fromModel(Abordagem model) {
		return new AbordagemEntity(model.getCdAbordagem(),
				model.getDsAbordagem(),
				model.getDtAbordagem(),
				model.getDsChaveFamRepR(),
				model.getNmFamiliar(),
				model.getClassificacao());
	}
	
	public static Mono<Abordagem> fromEntity(Mono<AbordagemEntity> entity){
		return entity.flatMap(x ->{
				Abordagem abordagem = new Abordagem();
				
				abordagem.setCdAbordagem(x.getCdAbordagem());
				abordagem.setDsAbordagem(x.getDsAbordagem());
				abordagem.setDtAbordagem(x.getDtAbordagem());
				abordagem.setDsChaveFamRepR(x.getDsChaveFamRepR());
				abordagem.setNmFamiliar(x.getNmFamiliar());
				abordagem.setClassificacao(x.getClassificacao());
				
				return Mono.just(abordagem);
		});
	}
	
	public static Mono<Abordagem> fromEntity(AbordagemEntity entity){
		return Mono.just(entity)
					.flatMap(x ->{
						Abordagem abordagem = new Abordagem();
						
						abordagem.setCdAbordagem(x.getCdAbordagem());
						abordagem.setDsAbordagem(x.getDsAbordagem());
						abordagem.setDtAbordagem(x.getDtAbordagem());
						abordagem.setDsChaveFamRepR(x.getDsChaveFamRepR());
						abordagem.setNmFamiliar(x.getNmFamiliar());
						abordagem.setClassificacao(x.getClassificacao());

						
						return Mono.just(abordagem);
		});
	}
	
	
	
}
