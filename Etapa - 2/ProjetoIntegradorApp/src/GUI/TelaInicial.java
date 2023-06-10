/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import projetointegradorapp.Biblioteca;

public class TelaInicial extends JFrame {
    public TelaInicial(Biblioteca biblioteca) {
        setTitle("Sistema Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));
        
        JButton btnCadastroLivros = new JButton("Cadastro de Livros");
        btnCadastroLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroLivros(biblioteca);
            }
        });

        JButton btnCadastroUsuarios = new JButton("Cadastro de Usuários");
        btnCadastroUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroUsuarios(biblioteca);
            }
        });
        
         // Cor de fundo
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Mensagem de boas-vindas
        JLabel lblBoasVindas = new JLabel("Bem-vindo à Biblioteca ");
        lblBoasVindas.setFont(new Font("Arial", Font.BOLD, 20));
        lblBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblBoasVindas);
            
        JButton btnEmprestimoLivros = new JButton("Empréstimo de Livros");
        btnEmprestimoLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaEmprestimoLivros(biblioteca);
            }
        });

        JButton btnDevolucaoLivros = new JButton("Devolução de Livros");
        btnDevolucaoLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaDevolucaoLivros(biblioteca);
            }
        });

        JButton btnRelatorioEmprestimos = new JButton("Relatório de Empréstimos");
        btnRelatorioEmprestimos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaRelatorioEmprestimos(biblioteca);
            }
        });

        JButton btnRemocaoLivros = new JButton("Remoção de Livros");
        btnRemocaoLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaRemocaoLivros(biblioteca);
            }
        });

        add(btnCadastroLivros);
        add(btnCadastroUsuarios);
        add(btnEmprestimoLivros);
        add(btnDevolucaoLivros);
        add(btnRelatorioEmprestimos);
        add(btnRemocaoLivros);

        setVisible(true);
    }

   public static void main(String[] args) {
    String libraryName = "My Library";
    String libraryAddress = "123 Main Street";
    String libraryPhoneNumber = "123-456-7890";

    Biblioteca biblioteca = new Biblioteca(libraryName, libraryAddress, libraryPhoneNumber);

    TelaInicial telaInicial = new TelaInicial(biblioteca);
}
}