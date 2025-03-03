package com.example.pastebin.model;

import jakarta.persistence.*;

@Entity
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Lob  // This allows storing large text
    @Column(columnDefinition = "TEXT")  // Works for MySQL & PostgreSQL
    private String text;

    public Text() {

    }

    public Text(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty or null!");
        }
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
