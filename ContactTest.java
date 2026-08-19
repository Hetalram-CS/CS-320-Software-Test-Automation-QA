import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Christopher", "Smith", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Christopher", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Smith", null, "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Smith", "12345", "123 Main Street");
        });
    }

    @Test
    public void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Smith", "1234567890", null);
        });
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        contact.setFirstName("David");

        assertEquals("David", contact.getFirstName());
    }
}