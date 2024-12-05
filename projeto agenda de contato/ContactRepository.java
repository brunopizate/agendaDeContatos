
import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByName(String name);
    void deleteByName(String name);

    public Contact save(Contact contact);

    public List<Contact> findAll();

   
    
}
