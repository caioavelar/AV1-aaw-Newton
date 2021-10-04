package br.newtonpaiva.livro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.livro.api.LivroDto;
import br.newtonpaiva.livro.domain.entity.Livro;
import br.newtonpaiva.livro.service.LivroService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/livros")
public class LivroController {

private final LivroService livroService;
	
	@GetMapping("/{id}")
	public LivroDto getById(@PathVariable String id) {
		var livro = livroService.get(id);
		
		return new LivroDto(livro);
	}
	
	@GetMapping("")
	public List<LivroDto> getAll() {
		var livros = livroService.getAll();
		
		var livroDtos = new ArrayList<LivroDto>();
		
		for (var livro: livros) {
			livroDtos.add(new LivroDto(livro));
		}
		
		return livroDtos;
	}
	
	@PostMapping("")
	public LivroDto create(@RequestBody LivroDto livroDto) {
		var livro = new Livro(livroDto);
		
		livro = livroService.create(livro);
		
		return new LivroDto(livro);
	}

	@PutMapping("/{id}")
	public LivroDto create(@PathVariable String id, @RequestBody LivroDto livroDto) {
		var livro = new Livro(livroDto);
		
		livro = livroService.update(id, livro);
		
		return new LivroDto(livro);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> delete(@PathVariable String id) {
		livroService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
