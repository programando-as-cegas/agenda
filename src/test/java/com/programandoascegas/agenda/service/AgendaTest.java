package com.programandoascegas.agenda.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void setUp() {
        this.agenda = new Agenda();
    }

    @Test
    @DisplayName("Testar a adição de um contato na lista tamanho deve ser igual a 1")
    void adicionar() {
        String nome = "Matheus";
        String telefone = "999887765";

        agenda.criar(nome, telefone);

        assertEquals(1, agenda.getContatos().size());
        assertEquals(nome, agenda.getContatos().get(0).getNome());
        assertEquals(telefone, agenda.getContatos().get(0).getTelefone());
    }

    @Test
    @DisplayName("Testando a exclusão do contato deve retornar true")
    void excluir() {
        String nome = "Matheus";
        String telefone = "999887765";

        agenda.criar(nome, telefone);

        assertEquals(1, agenda.getContatos().size());

        boolean excluido = agenda.excluir(0);

        assertTrue(excluido);
        assertEquals(0, agenda.getContatos().size());
    }

    @Test
    @DisplayName("Testando a exclusão de um contato passando uma posição inválida deve retornar false")
    void excluirPosicaoInvalida() {
        String nome = "Matheus";
        String telefone = "999887765";

        agenda.criar(nome, telefone);

        assertEquals(1, agenda.getContatos().size());

        boolean excluido = agenda.excluir(1);

        assertFalse(excluido);
        assertEquals(1, agenda.getContatos().size());
    }

}