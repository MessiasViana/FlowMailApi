package com.example.FlowMailApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Email")
public class Email {
    @Id
    @Column(name = "ID_Email")
    @GeneratedValue(generator = "SQ_Email", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_Email", sequenceName = "SQ_Email", allocationSize = 1)
    private Long id;

    @Column (name = "Remetente")
    private String remetente;
    
    

    public Email() {
		super();
	}

	public Email(String remetente, String destinatario, String assunto, String conteudo) {
		super();
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.conteudo = conteudo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Column (name = "Destinatario")
    private String destinatario;

    @Column (name = "Assunto")
    private String assunto;

    @Column (name = "Conteudo")
    private String conteudo;
    
    
}
