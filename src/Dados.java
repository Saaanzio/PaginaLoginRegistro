
import java.util.HashMap;

public class Dados {
    private HashMap<String , String> dadosLogin;

    public Dados() {
        dadosLogin = new HashMap<>();
        dadosLogin.put("usuario", "senha");
    }
    protected HashMap<String,String> getDadosLogin() {
        return dadosLogin;
    }
    public void adicionarDados(String usuario, String senha) {
        dadosLogin.put(usuario,senha);
    }
    //verificarUsuario mantido para a verificação somente de usuario presente nesta e em outras classes
    protected boolean verificarUsuario(String usuario) {
        if(dadosLogin.containsKey(usuario))
            return true;
        return false;
    }
    protected boolean verificarSenha(String usuario, String senha) {
        if(verificarUsuario(usuario)) {
            if(dadosLogin.get(usuario).equals(senha))
                return true;
        }
        return false;
    }
}
