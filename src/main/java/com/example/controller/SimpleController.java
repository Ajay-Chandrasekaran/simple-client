package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@RequestMapping({"${simple.controller.prefix.version.v1}/simple"})
public class SimpleController {

    @Value("${message}")
    private String message;

    @GetMapping("/message")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>(this.message, HttpStatus.OK);
    }
}
