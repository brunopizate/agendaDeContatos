


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Cadastro de Usuário");
            System.out.print("Nome de Usuário: ");
            String username = scanner.nextLine();
            System.out.print("Senha: ");
            String password = scanner.nextLine();
            
            if (authService.register(username, password)) {
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.out.println("Usuário já existe. Tente novamente.");
                return;
            }
            
            System.out.println("\nPágina de Login");
            System.out.print("Nome de Usuário: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Senha: ");
            String loginPassword = scanner.nextLine();
            
            if (authService.login(loginUsername, loginPassword)) {
                System.out.println("Login bem-sucedido! Bem-vindo à página inicial.");
            } else {
                System.out.println("Falha no login. Verifique suas credenciais.");
            }
        }
    }
}
  

