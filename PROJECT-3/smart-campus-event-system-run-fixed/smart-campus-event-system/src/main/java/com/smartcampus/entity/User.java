package com.smartcampus.entity;
import jakarta.persistence.*;import jakarta.validation.constraints.*;
@Entity @Table(name="users")
public class User{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; @Email @NotBlank @Column(unique=true) private String email;
 @NotBlank private String password; @Enumerated(EnumType.STRING) private Role role=Role.STUDENT;
 private boolean verified=false; private String otp;
 public Long getId(){return id;} public void setId(Long id){this.id=id;} public String getName(){return name;} public void setName(String name){this.name=name;} public String getEmail(){return email;} public void setEmail(String email){this.email=email;} public String getPassword(){return password;} public void setPassword(String password){this.password=password;} public Role getRole(){return role;} public void setRole(Role role){this.role=role;} public boolean isVerified(){return verified;} public void setVerified(boolean verified){this.verified=verified;} public String getOtp(){return otp;} public void setOtp(String otp){this.otp=otp;}
}
