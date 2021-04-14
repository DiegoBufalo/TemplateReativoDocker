package com.iplanner.abordagens.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iplanner.abordagens.model.Abordagem;
import com.iplanner.abordagens.service.AbordagemService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("abordagem")
public class AbordagemController {

	@Autowired
	private AbordagemService service;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public Flux<Abordagem> buscarTodasAbordagens(){
		return service.buscarTodasAbordagens();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Mono<Abordagem> buscarAbordagens(@PathVariable Integer id){
		return service.buscarAbordagens(id);
	}
	
	@PostMapping("/inserir")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<Abordagem> inserirAbordagem(@RequestBody @Valid Abordagem abordagem){
		return service.inserirAbordagem(abordagem);
	}
	
	@PutMapping("/{id}/atualizar")
	@ResponseStatus(value = HttpStatus.OK)
	public Mono<Abordagem> atualizarAbordagem(@PathVariable Integer id, @RequestBody Abordagem abordagem){
		return service.atualizarAbordagem(id, abordagem);
	}
	
	@DeleteMapping("/{id}/deletar")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public Mono<Void> deletarAbordagem(@PathVariable Integer id){
		return service.deletarAbordagem(id);
	}
	
	@PutMapping("/{idAbordagem}/classificar/{classificacaoAbordagem}")
	public Mono<Abordagem> classificarAbordagem(@PathVariable Integer idAbordagem,@PathVariable Integer classificacaoAbordagem){
		return service.classificarAbordagem(idAbordagem, classificacaoAbordagem);
	}
}
