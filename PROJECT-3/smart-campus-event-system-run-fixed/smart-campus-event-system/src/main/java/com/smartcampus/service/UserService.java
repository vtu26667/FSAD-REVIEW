package com.smartcampus.service;
import com.smartcampus.entity.*;import com.smartcampus.repository.UserRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Service;import java.util.*;
@Service
public class UserService{
 @Autowired private UserRepository repo; @Autowired private PasswordEncoder encoder; @Autowired private MailService mail;
 public User register(User u){ u.setPassword(encoder.encode(u.getPassword())); u.setRole(Role.STUDENT); u.setVerified(false); String otp=String.valueOf(new Random().nextInt(900000)+100000); u.setOtp(otp); User saved=repo.save(u); mail.sendOtp(saved.getEmail(),otp); return saved; }
 public boolean verify(String email,String otp){ Optional<User> ou=repo.findByEmail(email); if(ou.isPresent() && otp.equals(ou.get().getOtp())){ User u=ou.get(); u.setVerified(true); u.setOtp(null); repo.save(u); return true;} return false; }
 public Optional<User> byEmail(String email){ return repo.findByEmail(email); }
}
