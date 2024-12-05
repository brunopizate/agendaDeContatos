import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public boolean removeContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                return true; // Contato removido
            }
        }
        return false; // Contato não encontrado
    }

    public Contact findContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact; // Contato encontrado
            }
        }
        return null; // Contato não encontrado
    }

    public void editContact(String name, String newPhoneNumber, String newEmail) {
        Contact contact = findContact(name);
        if (contact != null) {
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
        }
    }

    public void listContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
