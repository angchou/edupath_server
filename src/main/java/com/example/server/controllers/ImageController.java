package com.example.server.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/learner/image")
public class ImageController {

    private final String IMAGE_DIR = "uploads/";

    @GetMapping("/{fileName}")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) throws IOException {

        Path path = Paths.get(IMAGE_DIR).resolve(fileName);
        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        String contentType = Files.probeContentType(path);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}