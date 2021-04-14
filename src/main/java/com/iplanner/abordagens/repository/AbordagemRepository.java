package com.iplanner.abordagens.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.iplanner.abordagens.entity.AbordagemEntity;

@Repository
public interface AbordagemRepository extends ReactiveCrudRepository<AbordagemEntity, Integer> {

}
