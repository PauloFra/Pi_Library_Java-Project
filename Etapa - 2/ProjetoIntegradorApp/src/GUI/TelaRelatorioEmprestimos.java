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
import projetointegradorapp.Usuario;

public class TelaRelatorioEmprestimos extends JFrame {
    private DefaultComboBoxModel<String> usuariosComboBoxModel;
    private DefaultListModel<String> emprestimosListModel;
    private JComboBox<String> usuariosComboBox;
    private JList<String> emprestimosList;

    public TelaRelatorioEmprestimos(Biblioteca biblioteca) {
        setTitle("Relatório de Empréstimos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        usuariosComboBoxModel = new DefaultComboBoxModel<>();
        usuariosComboBox = new JComboBox<>(usuariosComboBoxModel);

        List<Usuario> usuarios = biblioteca.getUsuarios();
        for (Usuario usuario : usuarios) {
            usuariosComboBoxModel.addElement(usuario.getNome());
        }

        emprestimosListModel = new DefaultListModel<>();
        emprestimosList = new JList<>(emprestimosListModel);

        JScrollPane usuariosScrollPane = new JScrollPane(usuariosComboBox);
        JScrollPane emprestimosScrollPane = new JScrollPane(emprestimosList);

        JButton btnSelecionarUsuario = new JButton("Selecionar Usuário");
        btnSelecionarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = usuariosComboBox.getSelectedIndex();
                if (selectedIndex != -1) {
                    Usuario usuario = usuarios.get(selectedIndex);

                    List<Emprestimo> emprestimos = biblioteca.listarEmprestimosDoUsuario(usuario);
                    emprestimosListModel.clear();

                    for (Emprestimo emprestimo : emprestimos) {
                        String status = emprestimo.isAtrasado() ? "Atrasado" : "Não atrasado";
                        emprestimosListModel.addElement(emprestimo.getLivro().getTitulo() + " - Status: " + status);
                    }
                }
            }
        });

        panel.add(usuariosScrollPane);
        panel.add(btnSelecionarUsuario);
        panel.add(emprestimosScrollPane);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}