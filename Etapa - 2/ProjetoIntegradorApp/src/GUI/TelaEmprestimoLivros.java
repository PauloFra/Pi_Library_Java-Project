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
import projetointegradorapp.Usuario;

public class TelaEmprestimoLivros extends JFrame {
    private DefaultComboBoxModel<String> usuariosComboBoxModel;
    private DefaultListModel<String> livrosListModel;
    private JComboBox<String> usuariosComboBox;
    private JList<String> livrosList;

    public TelaEmprestimoLivros(Biblioteca biblioteca) {
        setTitle("Empréstimo de Livros");
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

        livrosListModel = new DefaultListModel<>();
        livrosList = new JList<>(livrosListModel);

        JScrollPane usuariosScrollPane = new JScrollPane(usuariosComboBox);
        JScrollPane livrosScrollPane = new JScrollPane(livrosList);

        JButton btnSelecionarUsuario = new JButton("Selecionar Usuário");
        btnSelecionarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = usuariosComboBox.getSelectedIndex();
                if (selectedIndex != -1) {
                    Usuario usuario = usuarios.get(selectedIndex);

                    List<QuantidadeLivro> quantidadeLivros = biblioteca.getQuantidadeLivros();
                    livrosListModel.clear();

                    for (QuantidadeLivro quantidadeLivro : quantidadeLivros) {
                        Livro livro = quantidadeLivro.getLivro();
                        if (biblioteca.verificarDisponibilidadeEmprestimo(livro)) {
                            livrosListModel.addElement(livro.getTitulo());
                        }
                    }
                }
            }
        });

        JButton btnRealizarEmprestimo = new JButton("Realizar Empréstimo");
        btnRealizarEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = livrosList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Usuario usuario = usuarios.get(usuariosComboBox.getSelectedIndex());
                    Livro livro = biblioteca.getLivroByTitle(livrosListModel.getElementAt(selectedIndex));

                    biblioteca.realizarEmprestimo(usuario, livro);

                    JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");

                    livrosListModel.remove(selectedIndex);
                }
            }
        });

        panel.add(usuariosScrollPane);
        panel.add(btnSelecionarUsuario);
        panel.add(livrosScrollPane);

        add(panel, BorderLayout.CENTER);
        add(btnRealizarEmprestimo, BorderLayout.SOUTH);

        setVisible(true);
    }
}
