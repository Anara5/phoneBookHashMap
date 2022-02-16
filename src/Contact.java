import java.util.Objects;

public class Contact {

    private String name;
    private String number;

    Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    /**
     * in equals and hashCode I return just fields that shouldn't repeat when creating accounts
     * not sure that it's correct, though it gotta return all fields
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return number.equals(contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return name + " - " + number;
    }

    String getNumber() {
        return number;
    }
}