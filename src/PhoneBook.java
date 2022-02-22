import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    // key - name of the group, value - list of contacts
    private HashMap<String, List<Contact>> group = new HashMap<>();

    // to add contact to the group in the phone book
    static Contact createContact(String name, String number) {
        return new Contact(name, number);
    }

    // adding a group name
    void addGroup(String groupName) {
        if (group.containsKey(groupName)) return;
        group.put(groupName, new ArrayList<>());
    }

    // adding a contact
    void addContact(Contact contact, String... groupNames) {
        for (String groupName : groupNames) {
            if (!group.containsKey(groupName)) return;
            group.get(groupName).add(contact);
        }
    }

    // to show group list
    List<Contact> getAllByGroup(String groupName) {
        return group.get(groupName);
    }

    // to show contacts by entering a phone number
    Contact getByPhone(String number) {
        for(List<Contact> contactList : group.values()) {
            for (Contact contact : contactList) {
                if (contact.getNumber().equals(number)) return contact;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Contact>> fromGroup : group.entrySet()) {
            sb
                    .append(fromGroup.getKey())
                    .append("\n");
            for (Contact contact : fromGroup.getValue()) {
                sb
                        .append("\t")
                        .append(contact)
                        .append("\n");
            }
        }
        return sb.toString();
    }
}
