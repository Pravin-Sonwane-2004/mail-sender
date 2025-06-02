package com.pk.send.controllers;

import com.pk.send.services.EmailService;
import com.pk.send.controllers.EmailDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class EmailController {

  @Autowired
  private EmailService emailService;

  // Sending a simple Email
  @PostMapping("/sendMail")
  public ResponseEntity<String> sendMail(@RequestBody EmailDetails details) {
    try {
      CompletableFuture<Boolean> future = emailService.sendSimpleMail(details);
      Boolean status = future.get(); // waits for async result

      if (Boolean.TRUE.equals(status)) {
        return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully");
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to send email");
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
    }
  }

  // Sending email with attachment
  @PostMapping("/sendMailWithAttachment")
  public ResponseEntity<String> sendMailWithAttachment(@RequestBody EmailDetails details) {
    try {
      CompletableFuture<String> future = emailService.sendMailWithAttachment(details);
      String result = future.get(); // waits for async result

      return ResponseEntity.status(HttpStatus.OK).body(result);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email with attachment");
    }
  }
}
