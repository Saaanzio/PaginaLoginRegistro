
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PaginaLogin implements ActionListener{
    private Dados dadosLogin;
    JFrame frame = new JFrame();
    JButton botaoLogin = new JButton("Login");
    JButton registrar = new JButton("Registrar");
    JTextField campoUsuario = new JTextField();
    JPasswordField campoSenha = new JPasswordField();
    JLabel usuarioLabel = new JLabel("Usuário:");
    JLabel senhaLabel = new JLabel("Senha:");
    JLabel mensagem = new JLabel("");
    public PaginaLogin() {
        dadosLogin = new Dados();

        mensagem.setBounds(125,250,250,35);
        mensagem.setFont(new Font(null,Font.ITALIC,25));

        usuarioLabel.setBounds(50,100,75,25);
        senhaLabel.setBounds(50,150,75,25);

        campoUsuario.setBounds(125,100,200,25);
        campoSenha.setBounds(125,150,200,25);

        botaoLogin.setBounds(125,200,100,25);
        botaoLogin.addActionListener(this);
        botaoLogin.setFocusable(false);
        registrar.setBounds(225,200,100,25);
        registrar.addActionListener(this);
        registrar.setFocusable(false);

        frame.add(usuarioLabel);
        frame.add(senhaLabel);
        frame.add(mensagem);
        frame.add(campoSenha);
        frame.add(campoUsuario);
        frame.add(botaoLogin);
        frame.add(registrar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,430);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = campoUsuario.getText();
        String senha = String.valueOf(campoSenha.getPassword());
        //Verifica se o botão registrar é clicado para criar uma nova conta
        if(e.getSource()==registrar) {
            if(!usuario.isEmpty() && !senha.isEmpty()) {
                dadosLogin.adicionarDados(usuario,senha);
                campoUsuario.setText("");
                campoSenha.setText("");
                mensagem.setForeground(Color.green);
                mensagem.setText("Registrado!");
            }
            else {
                mensagem.setForeground(Color.red);
                mensagem.setText("Dados inválidos!");
            }
        }
        if(e.getSource()==botaoLogin) {
            //Verifica se o usuário existe, se existir compara com a senha armazenada no hashmap
            if(dadosLogin.verificarUsuario(usuario)) {
                if(dadosLogin.verificarSenha(usuario, senha)) {
                    mensagem.setForeground(Color.green);
                    mensagem.setText("Login efetuado!");
                    frame.dispose();
                    LoginEfetuado paginaLoginEfetuado = new LoginEfetuado(usuario);
                }
                else {
                    mensagem.setForeground(Color.red);
                    mensagem.setText("Senha incorreta!");
                }
            }
            else {
                mensagem.setForeground(Color.red);
                mensagem.setText("Usuário inválido!");
            }

        }

    }
}
