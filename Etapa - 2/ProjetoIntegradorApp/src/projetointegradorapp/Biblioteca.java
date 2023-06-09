/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetointegradorapp;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Emprestimo> emprestimos;
    private List<QuantidadeLivro> quantidadeLivros;

    public Biblioteca(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();
        this.quantidadeLivros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<QuantidadeLivro> getQuantidadeLivros() {
        return quantidadeLivros;
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
    public List<Emprestimo> listarEmprestimosDoUsuario(Usuario usuario) {
        List<Emprestimo> emprestimosDoUsuario = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                emprestimosDoUsuario.add(emprestimo);
            }
        }
    return emprestimosDoUsuario;
    }
    public boolean verificarDisponibilidadeEmprestimo(Livro livro) {
        int quantidadeDisponivel = getQuantidadeLivro(livro);
    return quantidadeDisponivel > 0;
}
}