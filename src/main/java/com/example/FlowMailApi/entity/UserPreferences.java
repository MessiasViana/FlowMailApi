package com.example.FlowMailApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_UserPreferences")
public class UserPreferences {
    @Id
    @Column(name = "ID_UserPreferences")
    @GeneratedValue(generator = "SQ_UserPreferences", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_UserPreferences", sequenceName = "SQ_UserPreferences", allocationSize = 1)
    private Long id;

    @Column(name = "Tema")
    private String tema;

    @Column(name = "CorDeFundo")
    private String corDeFundo;

    @Column(name = "CorDeTexto")
    private String corDeTexto;

	public UserPreferences() {
		super();
	}

	public UserPreferences(String tema, String corDeFundo, String corDeTexto) {
		super();
		this.tema = tema;
		this.corDeFundo = corDeFundo;
		this.corDeTexto = corDeTexto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getCorDeFundo() {
		return corDeFundo;
	}

	public void setCorDeFundo(String corDeFundo) {
		this.corDeFundo = corDeFundo;
	}

	public String getCorDeTexto() {
		return corDeTexto;
	}

	public void setCorDeTexto(String corDeTexto) {
		this.corDeTexto = corDeTexto;
	}
    
    

}
