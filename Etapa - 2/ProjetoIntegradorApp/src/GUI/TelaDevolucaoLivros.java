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
import projetointegradorapp.Emprestimo;

public class TelaDevolucaoLivros extends JFrame {
    private DefaultListModel<String> emprestimosListModel;
    private JList<String> emprestimosList;

    public TelaDevolucaoLivros(Biblioteca biblioteca) {
        setTitle("Devolução de Livros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        emprestimosListModel = new DefaultListModel<>();
        emprestimosList = new JList<>(emprestimosListModel);

        List<Emprestimo> emprestimos = biblioteca.getEmprestimos();
        for (Emprestimo emprestimo : emprestimos) {
            emprestimosListModel.addElement(emprestimo.getLivro().getTitulo() + " - " + emprestimo.getUsuario().getNome());
        }

        JScrollPane scrollPane = new JScrollPane(emprestimosList);

        JButton btnRegistrarDevolucao = new JButton("Registrar Devolução");
        btnRegistrarDevolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = emprestimosList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Emprestimo emprestimo = emprestimos.get(selectedIndex);

                    biblioteca.registrarDevolucao(emprestimo);

                    emprestimosListModel.remove(selectedIndex);

                    JOptionPane.showMessageDialog(null, "Devolução registrada!");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnRegistrarDevolucao, BorderLayout.SOUTH);

        setVisible(true);
    }
}