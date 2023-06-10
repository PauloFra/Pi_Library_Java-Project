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
import projetointegradorapp.Usuario;

public class TelaCadastroUsuarios extends JFrame {
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;

    public TelaCadastroUsuarios(Biblioteca biblioteca) {
        setTitle("Cadastro de Usuários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        JLabel lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField();

        JLabel lblTelefone = new JLabel("Telefone:");
        txtTelefone = new JTextField();

        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String endereco = txtEndereco.getText();
                String telefone = txtTelefone.getText();

                Usuario usuario = new Usuario(nome, endereco, telefone);

                biblioteca.cadastrarUsuario(usuario);

                JOptionPane.showMessageDialog(null, "Usuário cadastrado no sistema!");

                // Limpar campos de entrada
                txtNome.setText("");
                txtEndereco.setText("");
                txtTelefone.setText("");
            }
        });

        add(lblNome);
        add(txtNome);
        add(lblEndereco);
        add(txtEndereco);
        add(lblTelefone);
        add(txtTelefone);
        add(new JLabel()); // Espaço vazio
        add(btnCadastrarUsuario);

        setVisible(true);
    }
}