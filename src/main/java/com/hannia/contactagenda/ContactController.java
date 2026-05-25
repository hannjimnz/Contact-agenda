package com.hannia.contactagenda;


import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getContacts(){
        return contactService.getAllContacts();
    }

    @PostMapping
    public String addContact(@RequestBody  Contact contact){
        contactService.addContact(contact);
        return "Contacto Agregado: " + contact.getName();

    }
    @DeleteMapping("/{name}")
    public String deleteContact(@PathVariable String name){
        contactService.deleteContact(name);
        return "Contacto Eliminado: " + name;
    }
    @PutMapping("/{name}")
    public String updateContact(@PathVariable String name, @RequestBody  Contact contact){
        boolean updated = contactService.updateContact(name, contact);
        if(updated){
            return "Contacto Actualizado: " + name;
        }else{
            return "Contacto no encontrado: " + name;
        }
    }


}
