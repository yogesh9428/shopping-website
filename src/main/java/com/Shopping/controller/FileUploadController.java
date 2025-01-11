package com.Shopping.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping("/file")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            // Save the file or process it as needed
            return "Uploaded: " + fileName;
        }
        return "Failed to upload file because it was empty.";
    }
}
