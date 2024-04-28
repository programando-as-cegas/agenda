package com.programandoascegas.agenda.service;

import com.programandoascegas.agenda.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos;

    public List<Contato> getContatos() {
        return contatos;
    }

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void criar(String nome, String telefone) {
        var contato = new Contato(nome, telefone);
        contatos.add(contato);
    }

    public boolean atualizar(int posicao, String nome, String telefone) {
        if (posicao >= contatos.size() || posicao < 0) {
            return false;
        }

        contatos.get(posicao).setNome(nome);
        contatos.get(posicao).setTelefone(telefone);

        return true;
    }

    public boolean excluir(int posicao) {
        if (posicao >= contatos.size() || posicao < 0) {
            return false;
        }

        contatos.remove(posicao);

        return true;
    }
}
