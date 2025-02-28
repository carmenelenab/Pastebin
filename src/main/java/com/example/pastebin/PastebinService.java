package com.example.pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PastebinService {
    private final TextRepository textRepository;

    @Autowired
    public PastebinService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public List<Text> getAllTexts() {
        return textRepository.findAll();
    }

    public void addText(Text text) {
        textRepository.save(text);
    }

    public Optional<Text> getTextById(String id) {
        return textRepository.findById(id);
    }
}