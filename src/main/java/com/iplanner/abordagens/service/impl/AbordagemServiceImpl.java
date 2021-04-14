package com.iplanner.abordagens.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iplanner.abordagens.entity.AbordagemEntity;
import com.iplanner.abordagens.model.Abordagem;
import com.iplanner.abordagens.repository.AbordagemRepository;
import com.iplanner.abordagens.service.AbordagemService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AbordagemServiceImpl implements AbordagemService {
	
	@Autowired
	private AbordagemRepository abordagemRepository;

	@Override
	@Transactional(readOnly = true)
	public Flux<Abordagem> buscarTodasAbordagens() {
		return this.abordagemRepository.findAll().flatMap(Abordagem::fromEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public Mono<Abordagem> buscarAbordagens(Integer id) {
		return abordagemRepository.findById(id)
						.switchIfEmpty(Mono.error(new Exception("Abordagem nao encontrada")))
						.flatMap(Abordagem::fromEntity);
	}

	@Override
	@Transactional
	public Mono<Abordagem> inserirAbordagem(Abordagem abordagem) {
		
		return Mono.just(new AbordagemEntity(abordagem))
					.flatMap(x ->{
						x.setDtAbordagem(LocalDate.now());
						x.setClassificacao(0);
						return abordagemRepository.save(x);
					})
					.flatMap(Abordagem::fromEntity);
	}
	//teste
	@Override
	@Transactional
	public Mono<Abordagem> atualizarAbordagem(Integer id, Abordagem abordagem) {
		return this.abordagemRepository.findById(id)
					.switchIfEmpty(Mono.error(new Exception("Abordagem nao encontrada")))
					.flatMap(x -> {
						x.setDsAbordagem(abordagem.getDsAbordagem());
					
						return Mono.just(x);
					})
					.flatMap(x -> this.abordagemRepository.save(x))
					.flatMap(Abordagem::fromEntity);
				
	}

	@Override
	@Transactional
	public Mono<Void> deletarAbordagem(Integer id) {
		return this.abordagemRepository.findById(id)
				.switchIfEmpty(Mono.error(new Exception("Abordagem nao encontrada")))
				.flatMap(x -> this.abordagemRepository.delete(x));
	}

	@Override
	public Mono<Abordagem> classificarAbordagem(Integer idAbordagem, Integer classificacaoAbordagem) {
		return this.abordagemRepository.findById(idAbordagem)
				.switchIfEmpty(Mono.error(new Exception("Abordagem nao encontrada")))
				.flatMap(x ->{
					x.setClassificacao(classificacaoAbordagem);
					
					return	Mono.just(x);
				})
				.flatMap(x -> this.abordagemRepository.save(x))
				.flatMap(Abordagem::fromEntity);
	}

}
