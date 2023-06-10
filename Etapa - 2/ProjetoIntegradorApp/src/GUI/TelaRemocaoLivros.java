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
import projetointegradorapp.QuantidadeLivro;

public class TelaRemocaoLivros extends JFrame {
    private DefaultListModel<String> livrosListModel;
    private JList<String> livrosList;

    public TelaRemocaoLivros(Biblioteca biblioteca) {
        setTitle("Remoção de Livros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        livrosListModel = new DefaultListModel<>();
        livrosList = new JList<>(livrosListModel);

        List<QuantidadeLivro> quantidadeLivros = biblioteca.getQuantidadeLivros();
        for (QuantidadeLivro quantidadeLivro : quantidadeLivros) {
            Livro livro = quantidadeLivro.getLivro();
            int quantidade = quantidadeLivro.getQuantidade();
            livrosListModel.addElement(livro.getTitulo() + " - Quantidade: " + quantidade);
        }

        JScrollPane scrollPane = new JScrollPane(livrosList);

        JButton btnRemoverLivro = new JButton("Remover Livro");
        btnRemoverLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = livrosList.getSelectedIndex();
                if (selectedIndex != -1) {
                    QuantidadeLivro quantidadeLivro = quantidadeLivros.get(selectedIndex);
                    Livro livro = quantidadeLivro.getLivro();

                    biblioteca.removerLivro(livro);

                    livrosListModel.remove(selectedIndex);

                    JOptionPane.showMessageDialog(null, "Livro removido da biblioteca!");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnRemoverLivro, BorderLayout.SOUTH);

        setVisible(true);
    }
}
