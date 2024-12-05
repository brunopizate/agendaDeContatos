import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        ContactDatabaseManager contactManager = new ContactDatabaseManager();
        try (Scanner scanner = new Scanner(System.in)) {
            int option;
            
            do {
                System.out.println("\n1. Adicionar Contato");
                System.out.println("2. Editar Contato");
                System.out.println("3. Remover Contato");
                System.out.println("4. Listar Contatos");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                option = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha
                
                switch (option) {
                    case 1 : {
                        System.out.print("Nome: ");
                        String name = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        contactManager.addContact(new Contact(name, phoneNumber, email));
                        System.out.println("Contato adicionado com sucesso!");
                    }
                    case 2 : {
                        System.out.print("Nome do contato a editar: ");
                        String nameToEdit = scanner.nextLine();
                        System.out.print("Novo Telefone: ");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.print("Novo Email: ");
                        String newEmail = scanner.nextLine();
                        contactManager.editContact(nameToEdit, newPhoneNumber, newEmail);
                        System.out.println("Contato editado com sucesso!");
                    }
                    case 3 : {
                        System.out.print("Nome do contato a remover: ");
                        String nameToRemove = scanner.nextLine();
                        if (contactManager.removeContact(nameToRemove)) {
                            System.out.println("Contato removido com sucesso!");
                        } else {
                            System.out.println("Contato não encontrado!");
                        }
                    }
                    case 4 : {
                        System.out.println("Lista de Contatos:");
                        contactManager.listContacts();
                    }
                    case 5 : System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } while (option != 5);
        }
    }
}


