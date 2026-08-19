import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "111",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);

        assertEquals(contact, service.getContact("111"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "222",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);
        service.deleteContact("222");

        assertNull(service.getContact("222"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "333",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);

        service.updateContact(
                "333",
                "David",
                "Brown",
                "0987654321",
                "456 Oak Street");

        Contact updated = service.getContact("333");

        assertEquals("David", updated.getFirstName());
        assertEquals("Brown", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Oak Street", updated.getAddress());
    }

    @Test
    public void testDuplicateContactId() {
        ContactService service = new ContactService();

        Contact firstContact = new Contact(
                "444",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        Contact duplicateContact = new Contact(
                "444",
                "David",
                "Brown",
                "0987654321",
                "456 Oak Street");

        service.addContact(firstContact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicateContact);
        });
    }
}