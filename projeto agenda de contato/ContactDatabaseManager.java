import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDatabaseManager {
    private final String url = "jdbc:mysql://localhost:3306/ContactDB";
    private final String user = "root";
    private final String password = "yourpassword";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addContact(Contact contact) {
        String sql = "INSERT INTO Contacts (name, phoneNumber, email) VALUES (?, ?, ?)";
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhoneNumber());
            pstmt.setString(3, contact.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean removeContact(String name) {
        String sql = "DELETE FROM Contacts WHERE name = ?";
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Contact findContact(String name) {
        String sql = "SELECT * FROM Contacts WHERE name = ?";
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Contact(
                    rs.getString("name"),
                    rs.getString("phoneNumber"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void editContact(String name, String newPhoneNumber, String newEmail) {
        String sql = "UPDATE Contacts SET phoneNumber = ?, email = ? WHERE name = ?";
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPhoneNumber);
            pstmt.setString(2, newEmail);
            pstmt.setString(3, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listContacts() {
        String sql = "SELECT * FROM Contacts";
        List<Contact> contacts = new ArrayList<>();
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                contacts.add(new Contact(
                    rs.getString("name"),
                    rs.getString("phoneNumber"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
