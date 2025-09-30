package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.IContactService;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Contact> create(@RequestBody Contact contact) {
        Contact created = contactService.create(contact);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> read(@PathVariable Long id) {
        return contactService.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact) {
        contact = new Contact(contact.getEmail(), contact.getPhoneNumber(), contact.getAddress(), contact.getPassword());
        contactService.update(contact);
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = contactService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAll() {
        return ResponseEntity.ok(contactService.getAll());
    }
}



