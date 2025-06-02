package com.pk.send.controllers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmailDetails {
  private String recipient;
  private String msgBody;
  private String subject;
  private String attachment;

} 
