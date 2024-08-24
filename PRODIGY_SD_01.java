import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

class ContactManager {
    private List<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Add contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, emailAddress);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println((i + 1) + ". " + contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmailAddress());
            }
        }
    }

    private void editContact() {
        System.out.print("Enter the contact number to edit: ");
        int contactNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (contactNumber > 0 && contactNumber <= contacts.size()) {
            Contact contact = contacts.get(contactNumber - 1);
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new email address: ");
            String emailAddress = scanner.nextLine();

            contact.setName(name);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmailAddress(emailAddress);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private void deleteContact() {
        System.out.print("Enter the contact number to delete: ");
        int contactNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (contactNumber > 0 && contactNumber <= contacts.size()) {
            contacts.remove(contactNumber - 1);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        contactManager.run();
    }
}