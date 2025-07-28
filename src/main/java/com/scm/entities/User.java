package com.scm.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

//spring recommends making userDetails for all methods of users
// so we make our User class implements UserDetails so we can its obj(User) in its place;
public class User implements UserDetails {
     @Id 
     @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     private boolean enable=true;
     private boolean emailVerified=false;
     private boolean phoneVerified=false;

    //User signed in using Google,Facebook,Twitter,LinkedIn,Github
    @Enumerated(EnumType.STRING) 
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

	@ElementCollection(fetch=FetchType.EAGER)
    public ArrayList<String> roleList=new ArrayList<>();
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection <SimpleGrantedAuthority> roles=roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		return roles;
	}
     //for this project username is email so this.email means this class email
	@Override
	public String getUsername() {
		return this.email;
	}
	
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is locked or unlocked. A locked user cannot be
	 * authenticated.
	 * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
	 */
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Indicates whether the user's credentials (password) has expired. Expired
	 * credentials prevent authentication.
	 * @return <code>true</code> if the user's credentials are valid (ie non-expired),
	 * <code>false</code> if no longer valid (ie expired)
	 */
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is enabled or disabled. A disabled user cannot be
	 * authenticated.
	 * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
	 */

public boolean isEnabled() {
		return this.enable;
	}
    
    
}
