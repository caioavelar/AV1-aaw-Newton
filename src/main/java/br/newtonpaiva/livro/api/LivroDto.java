package br.newtonpaiva.livro.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.newtonpaiva.livro.domain.entity.Livro;
import br.newtonpaiva.livro.domain.entity.LivroStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {
	
	private String id;
	private String titulo;
	private String autor;
	private String editora;
	private LocalDate dataDePublicacao;
	private LivroStatus status;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.editora = livro.getEditora();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.status = livro.getStatus();
		this.createdAt = livro.getCreatedAt();
		this.modifiedAt = livro.getModifiedAt();
	}
	
	

}
