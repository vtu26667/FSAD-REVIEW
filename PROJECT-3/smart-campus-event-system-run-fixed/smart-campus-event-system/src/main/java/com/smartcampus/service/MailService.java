package com.smartcampus.service;
import org.springframework.beans.factory.annotation.*;import org.springframework.mail.SimpleMailMessage;import org.springframework.mail.javamail.JavaMailSender;import org.springframework.stereotype.Service;
@Service
public class MailService{
 @Autowired(required=false) private JavaMailSender sender; @Value("${app.mail.enabled:false}") private boolean enabled; @Value("${spring.mail.username:}") private String from;
 public void sendOtp(String to,String otp){
  if(!enabled || sender==null){ System.out.println("DEMO OTP for "+to+" = "+otp); return; }
  SimpleMailMessage m=new SimpleMailMessage(); m.setFrom(from); m.setTo(to); m.setSubject("Smart Campus Email OTP Verification"); m.setText("Your Smart Campus OTP is: "+otp+"\nThis OTP verifies your student account."); sender.send(m);
 }
}
