package com.iplanner.abordagens.service;



import com.iplanner.abordagens.model.Abordagem;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AbordagemService {
	
	public Flux<Abordagem> buscarTodasAbordagens();
	
	public Mono<Abordagem> buscarAbordagens(Integer id);
	
	public Mono<Abordagem> inserirAbordagem(Abordagem abordagem);
	
	public Mono<Abordagem> atualizarAbordagem(Integer id, Abordagem abordagem);
	
	public Mono<Void> deletarAbordagem(Integer id);
	
	public Mono<Abordagem> classificarAbordagem(Integer idAbordagem, Integer classificacaoAbordagem);

}
