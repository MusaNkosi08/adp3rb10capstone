package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.IContactRepository;
import za.ac.cput.service.IContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {
    @Autowired
    private IContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> read(Long contactId) {
        return contactRepository.findById(contactId);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public boolean delete(Long contactId) {
        if (contactRepository.existsById(contactId)) {
            contactRepository.deleteById(contactId);
            return true;
        }
        return false;
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}

