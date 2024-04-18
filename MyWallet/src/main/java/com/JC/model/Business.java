package com.JC.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, message = "Business name must be at least 3 characters long")
    private String businessName;

    @NotNull
    @Size(min = 3, message = "Owner name must be at least 3 characters long")
    private String ownerName;

    @NotNull
    @Size(min = 8, max = 20, message = "PIN must be between 8 and 20 characters long")
    private String pin;

    @NotNull
    @Email(message = "Invalid email format")
    private String email;

    @NotNull
    @Pattern(regexp = "\\d{12}", message = "Invalid National ID format. Must be 12 digits")
    private String nationalId;
}

