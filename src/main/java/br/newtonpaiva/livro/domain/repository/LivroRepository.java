package br.newtonpaiva.livro.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.newtonpaiva.livro.domain.entity.Livro;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String>{

}
