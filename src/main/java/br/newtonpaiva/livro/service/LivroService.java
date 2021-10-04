package br.newtonpaiva.livro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.newtonpaiva.livro.domain.entity.Livro;
import br.newtonpaiva.livro.domain.repository.LivroRepository;
import br.newtonpaiva.livro.exception.NotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroService {
	private final LivroRepository livroRepository;
	
	
	public Livro create(Livro l) {
		var now  = LocalDateTime.now();
		
		l.setCreatedAt(now);
		l.setModifiedAt(now);
		
		livroRepository.save(l);
		
		return l;
	}
	
	public Livro update(String id, Livro l) {
		var existing = get(id);
		
		existing.setAutor(l.getAutor());
		existing.setDataDePublicacao(l.getDataDePublicacao());
		existing.setEditora(l.getEditora());
		existing.setStatus(l.getStatus());
		existing.setTitulo(l.getTitulo());
		
		livroRepository.save(existing);
		
		return existing; 
	}
	
	public Livro get(String id) {
		var livro = livroRepository.findById(id);
		
		if (livro.isEmpty()) {
			throw new NotFoundException("Livro with ID " + id + " not found");
		}
		
		return livro.get();
	}
	
	public List<Livro> getAll() {
		return livroRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		
		livroRepository.deleteById(id);
	}
}
