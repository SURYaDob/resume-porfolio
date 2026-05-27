package com.portfolio.controller;

import com.portfolio.model.ContactMessage;
import com.portfolio.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * POST /api/contact - Submit a new contact form message.
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> submitMessage(@Valid @RequestBody ContactMessage message) {
        try {
            ContactMessage saved = contactService.saveMessage(message);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "success", true,
                    "message", "Thank you for reaching out! I'll get back to you within 24 hours.",
                    "id", saved.getId()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "success", false,
                    "message", "Failed to send message. Please email me directly at surajdobale29@gmail.com."
            ));
        }
    }

    /**
     * GET /api/contact/messages - Retrieve all messages (admin endpoint).
     */
    @GetMapping("/messages")
    public ResponseEntity<?> getAllMessages() {
        return ResponseEntity.ok(contactService.getAllMessages());
    }

    /**
     * GET /api/contact/unread-count - Get count of unread messages.
     */
    @GetMapping("/unread-count")
    public ResponseEntity<Map<String, Long>> getUnreadCount() {
        return ResponseEntity.ok(Map.of("count", contactService.getUnreadCount()));
    }

    /**
     * PUT /api/contact/{id}/read - Mark a message as read.
     */
    @PutMapping("/{id}/read")
    public ResponseEntity<ContactMessage> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.markAsRead(id));
    }
}
