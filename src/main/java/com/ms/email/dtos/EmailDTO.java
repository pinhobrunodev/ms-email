package com.ms.email.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDTO {

    @NotBlank(message = "Mandatory Field")
    private String ownerRef;
    @NotBlank(message = "Mandatory Field")
    @Email(message = "Please sent a valid Email")
    private String emailFrom;
    @NotBlank(message = "Mandatory Field")
    @Email(message = "Please sent a valid Email")
    private String emailTo;
    @NotBlank(message = "Mandatory Field")
    private String subject;
    @NotBlank(message = "Mandatory Field")
    private String text;



}
