package com.hannia.contactagenda;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
    private List <Contact> contacts = new ArrayList<>();

    public List<Contact> getAllContacts() {
        return contacts;
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    public void deleteContact(String name){
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }
}
