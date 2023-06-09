/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetointegradorapp;

/**
 *
 * @author Windows
 */
import java.util.Date;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;
    private Date dataDevolucaoPrevista;
    private Date dataDevolucaoEfetiva;
    private Biblioteca biblioteca;

    
    // Construtor
    public Emprestimo(Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucaoPrevista, Biblioteca biblioteca) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.biblioteca = biblioteca;

    }
    
    // Getters e Setters
    public Livro getLivro() {
        return livro;
    }
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
    
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }
    
    public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
    
    public Date getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }
    
    public void setDataDevolucaoEfetiva(Date dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }
    
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    // Método para verificar se o empréstimo está atrasado
    public boolean estaAtrasado() {
        Date dataAtual = new Date();
        return dataAtual.after(dataDevolucaoPrevista) && dataDevolucaoEfetiva == null;
    }
    
    // Método para registrar a devolução do livro
    public void registrarDevolucao(Date dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }
    public int calcularAtrasoEmDias() {
    if (dataDevolucaoEfetiva != null && dataDevolucaoEfetiva.after(dataDevolucaoPrevista)) {
        long diffMillis = dataDevolucaoEfetiva.getTime() - dataDevolucaoPrevista.getTime();
        long diffDays = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
        return (int) diffDays;
    }
    return 0;
}
}

