package com.scm.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserForm {
    @NotBlank(message="Username is Required")
    @Size(min=3,message="Min 3 character is required")
    private String name;
    @NotBlank(message="Email is Required")
    private String email;
    @NotBlank(message="Password is Required")
    @Size(min=6,message="Min 6 character is required")
    private String password;
    @Size(min=8,max=12,message="Invalid phone number")
    private String phoneNumber;
    @NotBlank(message="About is Required")
    private String about;




}
