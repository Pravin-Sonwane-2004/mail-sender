package com.pk.send.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class EmailDetials {
  // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
  // private String attachment;
}
