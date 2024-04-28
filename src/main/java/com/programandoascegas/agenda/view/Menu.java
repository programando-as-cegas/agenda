package com.programandoascegas.agenda.view;

import com.programandoascegas.agenda.model.Contato;
import com.programandoascegas.agenda.service.Agenda;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        String nome;
        String telefone;
        int posicao;
        int opcao = 0;
        Agenda agenda = new Agenda();

        while (opcao != 5) {
            System.out.println("Digite o número da opção correspondente");
            System.out.println("1 - Criar contato\n2 - Listar todos os contatos\n3 - Atualizar um contato\n4 - Excluir um contato\n5 - Sair do programa");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato a adicionar: ");
                    nome = teclado.next();

                    System.out.println("Digite o telefone do contato a adicionar: ");
                    telefone = teclado.next();

                    agenda.criar(nome, telefone);

                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    listarContatos(agenda.getContatos());
                    break;
                case 3:
                    System.out.println("Escolha um contato a a baixo");
                    listarContatos(agenda.getContatos());

                    System.out.println("Digite a posição referente ao contato a atualizar: ");
                    posicao = teclado.nextInt();

                    System.out.println("Digite o novo nome do contato:");
                    nome = teclado.next();

                    System.out.println("Digite o novo telefone do contato: ");
                    telefone = teclado.next();

                    if (agenda.atualizar(posicao, nome, telefone)) {
                        System.out.println("Contato atualizado com sucesso!");
                    } else {
                        System.out.println("Posição inválida, erro ao atualizar o contato");
                    }
                    break;
                case 4:
                    System.out.println("Escolha um contato a a baixo");
                    listarContatos(agenda.getContatos());

                    System.out.println("Digite a posição referente ao contato a excluir: ");
                    posicao = teclado.nextInt();

                    if (agenda.excluir(posicao)) {
                        System.out.println("Contato excluído com sucesso!");
                    } else {
                        System.out.println("Posição inválida, erro ao excluir o contato");
                    }
                    break;
                case 5:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private void listarContatos(List<Contato> contatos) {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println(String.format("%d - %s - %s", i, contatos.get(i).getNome(), contatos.get(i).getTelefone()));
        }
    }
}
