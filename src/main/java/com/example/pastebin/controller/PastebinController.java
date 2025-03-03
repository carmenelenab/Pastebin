package com.example.pastebin.controller;

import com.example.pastebin.model.PastebinService;
import com.example.pastebin.model.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PastebinController {
    private final PastebinService service;

    @Autowired
    public PastebinController(PastebinService service) {
        this.service = service;
    }

    @GetMapping("/texts")
    public List<Text> getAllTexts() {
        return service.getAllTexts();
    }

    @PostMapping("/texts")
    public ResponseEntity<String> addText(@RequestBody Text text) {
        if (text.getText() == null || text.getText().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Text cannot be empty!");
        }
        service.addText(text);
        return ResponseEntity.ok("Text saved succesfully!");
    }

    @GetMapping("/texts/{id}")
    public ResponseEntity<Text> getTextById(@PathVariable String id) {
        Optional<Text> text = service.getTextById(id);
        return text.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
