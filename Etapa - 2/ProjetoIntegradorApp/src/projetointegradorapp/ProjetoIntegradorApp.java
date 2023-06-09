/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetointegradorapp;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Windows
 */
public class ProjetoIntegradorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Criação dos objetos Livro
        Livro livro1 = new Livro("Livro 1", "Autor 1", "Editora 1", 2021);
        Livro livro2 = new Livro("Livro 2", "Autor 2", "Editora 2", 2022);
        Livro livro3 = new Livro("Livro 3", "Autor 3", "Editora 3", 2023);

        Usuario usuario1 = new Usuario("Usuário 1", "Endereço 1", "Telefone 1");
        Usuario usuario2 = new Usuario("Usuário 2", "Endereço 2", "Telefone 2");

        Biblioteca biblioteca = new Biblioteca("Minha Biblioteca", "Rua A, 123", "123456789");

        biblioteca.adicionarLivro(livro1, 5);
        biblioteca.adicionarLivro(livro2, 3);
        biblioteca.adicionarLivro(livro3, 2);

        Emprestimo emprestimo1 = new Emprestimo(livro1, usuario1, new Date(), new Date(), biblioteca);
        Emprestimo emprestimo2 = new Emprestimo(livro2, usuario2, new Date(), new Date(), biblioteca);
        Emprestimo emprestimo3 = new Emprestimo(livro3, usuario1, new Date(), new Date(), biblioteca);

        
        biblioteca.adicionarEmprestimo(emprestimo1);
        biblioteca.adicionarEmprestimo(emprestimo2);
        biblioteca.adicionarEmprestimo(emprestimo3);

        
        System.out.println("Livros disponíveis na biblioteca:");
        for (QuantidadeLivro quantidadeLivro : biblioteca.getQuantidadeLivros()) {
            Livro livro = quantidadeLivro.getLivro();
            int quantidade = quantidadeLivro.getQuantidade();
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Ano: " + livro.getAno());
            System.out.println("Quantidade: " + quantidade);
            System.out.println("------------------------");
        }
   
        System.out.println("Empréstimos realizados na biblioteca:");
        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
            Livro livro = emprestimo.getLivro();
            Usuario usuario = emprestimo.getUsuario();
            Date dataEmprestimo = emprestimo.getDataEmprestimo();
            Date dataDevolucaoPrevista = emprestimo.getDataDevolucaoPrevista();
            Biblioteca bibliotecaEmprestimo = emprestimo.getBiblioteca();
            System.out.println("Título do livro: " + livro.getTitulo());
            System.out.println("Nome do usuário: " + usuario.getNome());
            System.out.println("Data de empréstimo: " + dataEmprestimo);
            System.out.println("Data de devolução prevista: " + dataDevolucaoPrevista);
            System.out.println("Biblioteca: " + bibliotecaEmprestimo.getNome());
            System.out.println("------------------------");
        }
        List<Emprestimo> emprestimosDoUsuario = biblioteca.listarEmprestimosDoUsuario(usuario1);

        System.out.println("Empréstimos do usuário " + usuario1.getNome() + ":");
        for (Emprestimo emprestimo : emprestimosDoUsuario) {
            System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
        }
    }
    
    
}
