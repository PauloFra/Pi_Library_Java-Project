/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Windows
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import projetointegradorapp.Biblioteca;
import projetointegradorapp.Livro;

public class TelaCadastroLivros extends JFrame {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtEditora;
    private JTextField txtAno;

    public TelaCadastroLivros(Biblioteca biblioteca) {
        setTitle("Cadastro de Livros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JLabel lblTitulo = new JLabel("Título:");
        txtTitulo = new JTextField();

        JLabel lblAutor = new JLabel("Autor:");
        txtAutor = new JTextField();

        JLabel lblEditora = new JLabel("Editora:");
        txtEditora = new JTextField();

        JLabel lblAno = new JLabel("Ano:");
        txtAno = new JTextField();

        JButton btnAdicionarLivro = new JButton("Adicionar Livro");
        btnAdicionarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String editora = txtEditora.getText();
                int ano = Integer.parseInt(txtAno.getText());

                Livro livro = new Livro(titulo, autor, editora, ano);

                biblioteca.adicionarLivro(livro, 1);

                JOptionPane.showMessageDialog(null, "Livro adicionado à biblioteca!");

                // Limpar campos de entrada
                txtTitulo.setText("");
                txtAutor.setText("");
                txtEditora.setText("");
                txtAno.setText("");
            }
        });

        add(lblTitulo);
        add(txtTitulo);
        add(lblAutor);
        add(txtAutor);
        add(lblEditora);
        add(txtEditora);
        add(lblAno);
        add(txtAno);
        add(new JLabel()); // Espaço vazio
        add(btnAdicionarLivro);

        setVisible(true);
    }
}