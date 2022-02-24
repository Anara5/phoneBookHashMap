import java.util.List;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        fillGroups(phoneBook);

        fillContacts(phoneBook);

        System.out.println(phoneBook);

        System.out.println("Contacts from the group:");
        final List<Contact> byGroup = phoneBook.getAllByGroup("Friends");
        for (Contact friend : byGroup) {
            System.out.println(friend);
        }

        System.out.println("\nContact by phone number:");
        final Contact byPhone = phoneBook.getByPhone("+46 123 456 78 90");
        System.out.println(byPhone);
    }

    private static void fillGroups(PhoneBook phoneBook) {
        phoneBook.addGroup("Family");
        phoneBook.addGroup("Friends");
        phoneBook.addGroup("Work");
    }

    private static void fillContacts(PhoneBook phoneBook) {
        phoneBook.addContact(
                PhoneBook.createContact("Anara", "+46 123 456 78 90"), "Family");
        phoneBook.addContact(
                PhoneBook.createContact("Alex", "+46 876 123 45 67"), "Family");
        phoneBook.addContact(
                PhoneBook.createContact("Josef", "+46 932 123 45 98"), "Friends", "Work");
        phoneBook.addContact(
                PhoneBook.createContact("Sophia", "+7 932 123 45 30"), "Friends");
        phoneBook.addContact(
                PhoneBook.createContact("Maria", "+46 123 456 78 90"), "Work");
    }
}