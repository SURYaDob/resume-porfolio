package com.portfolio.service;

import com.portfolio.model.ContactMessage;
import com.portfolio.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactMessageRepository repository;

    public ContactService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    /**
     * Save a new contact message from the portfolio contact form.
     */
    public ContactMessage saveMessage(ContactMessage message) {
        return repository.save(message);
    }

    /**
     * Retrieve all messages ordered by most recent first.
     */
    public List<ContactMessage> getAllMessages() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    /**
     * Get unread messages count.
     */
    public long getUnreadCount() {
        return repository.countByRead(false);
    }

    /**
     * Mark a message as read.
     */
    public ContactMessage markAsRead(Long id) {
        ContactMessage message = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
        message.setRead(true);
        return repository.save(message);
    }
}
