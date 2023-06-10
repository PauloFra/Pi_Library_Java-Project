/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetointegradorapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Emprestimo> emprestimos;
    private List<QuantidadeLivro> quantidadeLivros;
    private List<Usuario> usuarios;

    public Biblioteca(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();
        this.quantidadeLivros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Métodos getters e setters para nome, endereco e telefone

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<QuantidadeLivro> getQuantidadeLivros() {
        return quantidadeLivros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarLivro(Livro livro, int quantidade) {
        QuantidadeLivro quantidadeLivro = new QuantidadeLivro(livro, quantidade);
        quantidadeLivros.add(quantidadeLivro);
    }

    public void removerLivro(Livro livro) {
        QuantidadeLivro livroRemovido = null;
        for (QuantidadeLivro quantidadeLivro : quantidadeLivros) {
            if (quantidadeLivro.getLivro().equals(livro)) {
                livroRemovido = quantidadeLivro;
                break;
            }
        }
        if (livroRemovido != null) {
            quantidadeLivros.remove(livroRemovido);
        }
    }

    public void atualizarQuantidadeLivro(Livro livro, int novaQuantidade) {
        for (QuantidadeLivro quantidadeLivro : quantidadeLivros) {
            if (quantidadeLivro.getLivro().equals(livro)) {
                quantidadeLivro.setQuantidade(novaQuantidade);
                break;
            }
        }
    }

    public Livro getLivroByTitle(String titulo) {
        for (QuantidadeLivro quantidadeLivro : quantidadeLivros) {
            Livro livro = quantidadeLivro.getLivro();
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public boolean isAtrasado(Date dataDevolucao) {
        Date dataAtual = new Date();
        return dataDevolucao != null && dataDevolucao.before(dataAtual);
    }

    public int getQuantidadeLivro(Livro livro) {
        for (QuantidadeLivro quantidadeLivro : quantidadeLivros) {
            if (quantidadeLivro.getLivro().equals(livro)) {
                return quantidadeLivro.getQuantidade();
            }
        }
        return 0;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void registrarDevolucao(Emprestimo emprestimo) {
        emprestimo.devolverLivro();
        emprestimos.remove(emprestimo);
    }

    public List<Emprestimo> listarEmprestimosDoUsuario(Usuario usuario) {
        List<Emprestimo> emprestimosDoUsuario = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                emprestimosDoUsuario.add(emprestimo);
            }
        }
        return emprestimosDoUsuario;
    }
public void realizarEmprestimo(Usuario usuario, Livro livro) {
    if (verificarDisponibilidadeEmprestimo(livro)) {
        Date dataAtual = new Date();
        Date dataDevolucao = new Date(dataAtual.getTime() + (7 * 24 * 60 * 60 * 1000)); // Adiciona uma semana

        Emprestimo emprestimo = new Emprestimo(usuario, livro, dataDevolucao);
        adicionarEmprestimo(emprestimo);

        // Reduz a quantidade disponível do livro
        atualizarQuantidadeLivro(livro, getQuantidadeLivro(livro) - 1);
    } else {
        System.out.println("O livro não está disponível para empréstimo.");
    }
}
    public boolean verificarDisponibilidadeEmprestimo(Livro livro) {
        int quantidadeDisponivel = getQuantidadeLivro(livro);
        return quantidadeDisponivel > 0;
    }
}