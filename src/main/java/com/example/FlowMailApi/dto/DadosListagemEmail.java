package com.example.FlowMailApi.dto;

import com.example.FlowMailApi.entity.Email;

public record DadosListagemEmail(String remetente, String destinatario, String assunto, String conteudo) {
	public DadosListagemEmail(Email email) {
        this(email.getRemetente(), email.getDestinatario(), email.getAssunto(), email.getConteudo());
    }
}
