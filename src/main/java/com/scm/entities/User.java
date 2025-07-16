package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
     @Column(length = 1000)
     private String about;
     @Column(length = 1000)
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
      
   //cascade if user is deleted all contacts are also deleted 
  //if user is added all contacts are also added
 //fetch type = lazy  will only fetch contacts of user when required else it will not 
//In JPA (Java Persistence API), orphanRemoval = true within a @OneToMany or @ManyToMany annotation 
//signifies that when a child entity is removed from the parent's collection,
//it should be automatically deleted from the database.  
 //orphanRemoval specifically removes child entities from the database when they are no longer 
//referenced by their parent. CascadeType.ALL propagates all operations (including remove) from the parent 
//to the child, but doesn't automatically remove orphans.
 
      
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true )
     private List<Contact> contacts=new ArrayList<>();
    
    
}
