package br.newtonpaiva.livro.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import br.newtonpaiva.livro.api.LivroDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

	@Id
	private String id;
	private String titulo;
	private String autor;
	private String editora;
	private LocalDate dataDePublicacao;
	private LivroStatus status;
	
	private LocalDateTime createdAt; // yyyy-mm-dd HH:mm:ss
	
	private LocalDateTime modifiedAt;
	

	public Livro(LivroDto livroDto) {
		this.id = livroDto.getId();
		this.titulo = livroDto.getTitulo();
		this.autor = livroDto.getAutor();
		this.editora = livroDto.getEditora();
		this.dataDePublicacao = livroDto.getDataDePublicacao();
		this.status = livroDto.getStatus();
		this.createdAt = livroDto.getCreatedAt();
		this.modifiedAt = livroDto.getModifiedAt();
	}
}
