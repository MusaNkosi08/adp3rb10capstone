package za.ac.cput.service;

import za.ac.cput.domain.Contact;
import java.util.List;
import java.util.Optional;

public interface IContactService {
    Contact create(Contact contact);
    Optional<Contact> read(Long contactId);
    Contact update(Contact contact);
    boolean delete(Long contactId);
    List<Contact> getAll();
}

