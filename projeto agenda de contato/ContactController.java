import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @PostMapping(value = "")
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @PostMapping("/{name}")
    public Contact updateContact(@PathVariable String name, @RequestBody Contact updatedContact) {
        Contact contact = contactRepository.findByName(name);
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        contact.setEmail(updatedContact.getEmail());
        return contactRepository.save(contact);
    }

    @DeleteMapping("/{name}")
    public void deleteContact(@PathVariable String name) {
        contactRepository.deleteByName(name);
    }

    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
