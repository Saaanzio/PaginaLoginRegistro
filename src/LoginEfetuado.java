
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginEfetuado {
    JFrame frame;
    JLabel sucesso;
    public LoginEfetuado(String usuario){
        frame = new JFrame();
        sucesso = new JLabel("Bem-Vindo!");
        sucesso.setText("Olá "+ usuario);

        sucesso.setBounds(0,0,200,35);
        sucesso.setFont(new Font(null,Font.PLAIN,25));

        frame.add(sucesso);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,430);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
