package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.storage.StorageService;



@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;


    @PostMapping("/file")
    public String[] upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("FileController.upload() : " + multipartFile.getOriginalFilename());
        return storageService.uploadFile(multipartFile);
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Object> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws Exception {
        return storageService.downloadFile(fileName, request);
    }

}
