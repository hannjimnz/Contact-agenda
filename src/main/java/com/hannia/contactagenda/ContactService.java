package com.hannia.contactagenda;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }


    public boolean updateContact(String name, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.set(i, updatedContact);
                return true; // encontrado y actualizado
            }
        }
        return false; // no encontrado
    }
}
