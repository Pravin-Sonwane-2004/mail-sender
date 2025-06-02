package com.pk.send.services;

import java.util.concurrent.CompletableFuture;

import com.pk.send.controllers.EmailDetails;
public interface EmailService {

  CompletableFuture<Boolean> sendSimpleMail(EmailDetails details);

  // Method
  // To send an email with attachment
  CompletableFuture<String> sendMailWithAttachment(EmailDetails details);
}
