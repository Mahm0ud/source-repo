package com.example.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@SpringBootApplication
@Controller
public class SourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SourceApplication.class, args);
    }

    @GetMapping(value = "/get-file")
    public ResponseEntity<byte[]> getFile() throws IOException {
        byte[] resource = getClass().getResourceAsStream("/myFile.pdf").readAllBytes();
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(resource.length)
                .body(resource);

    }
}
