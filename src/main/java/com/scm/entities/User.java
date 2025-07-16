package com.scm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user")
@Table(name="user_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
     @Id 
     private int userId;
     @Column(name="user_name",nullable=false)
     private String name;
     @Column(name="user_email",nullable=false)
     private String email;
     private String password;
     @Column(columnDefinition = "TEXT")
     private String about;
     @Column(columnDefinition = "TEXT")
     private String profilePic;
     private String phoneNumber;

     //information
     private boolean enable=false;
     private boolean emailVerified=false;
     private boolean phoneVerified=false;

    //User signed in using Google,Facebook,Twitter,LinkedIn,Github
    @Enumerated  
    private Providers provider=Providers.SELF;
      private String providerUserId;


}
