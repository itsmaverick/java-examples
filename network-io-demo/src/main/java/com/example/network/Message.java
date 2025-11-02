package com.example.network;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A serializable message class for object-based network communication.
 * Demonstrates how Java objects can be exchanged over network connections.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String content;
    private String sender;
    private LocalDateTime timestamp;

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s", timestamp, sender, content);
    }
}
