package com.Shopping.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping("/file")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Failed to upload file because it was empty.";
        }
        
        String fileName = file.getOriginalFilename();
        
        // Implement the logic to save or process the file
        try {
           
            return "Uploaded successfully: " + fileName;
        } catch (Exception e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }
}