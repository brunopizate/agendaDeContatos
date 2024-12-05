
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private final Map<String, User> users = new HashMap<>();

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Usuário já existe
        }
        users.put(username, new User(username, password));
        return true; // Registro bem-sucedido
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        // Falha no login
        return user != null && user.getPassword().equals(password); 
    }
    
    
}
