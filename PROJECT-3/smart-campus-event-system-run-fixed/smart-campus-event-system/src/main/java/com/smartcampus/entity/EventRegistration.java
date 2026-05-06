package com.smartcampus.entity;
import jakarta.persistence.*;import jakarta.validation.constraints.*;import java.time.LocalDateTime;
@Entity @Table(name="registrations")
public class EventRegistration{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne private User user; @ManyToOne private Event event;
 @NotBlank private String fullName; @Email @NotBlank private String personalEmail;
 @NotBlank private String phone; @NotBlank private String department; @NotBlank private String rollNo;
 @Min(1) @Max(10) private int attendees=1; private String academicYear; private String specialRequirements;
 private LocalDateTime registeredAt=LocalDateTime.now(); private String feedback; private String status="CONFIRMED";
 public Long getId(){return id;} public void setId(Long id){this.id=id;} public User getUser(){return user;} public void setUser(User user){this.user=user;} public Event getEvent(){return event;} public void setEvent(Event event){this.event=event;}
 public String getFullName(){return fullName;} public void setFullName(String fullName){this.fullName=fullName;} public String getPersonalEmail(){return personalEmail;} public void setPersonalEmail(String personalEmail){this.personalEmail=personalEmail;}
 public String getPhone(){return phone;} public void setPhone(String phone){this.phone=phone;} public String getDepartment(){return department;} public void setDepartment(String department){this.department=department;}
 public String getRollNo(){return rollNo;} public void setRollNo(String rollNo){this.rollNo=rollNo;} public int getAttendees(){return attendees;} public void setAttendees(int attendees){this.attendees=attendees;}
 public String getAcademicYear(){return academicYear;} public void setAcademicYear(String academicYear){this.academicYear=academicYear;} public String getSpecialRequirements(){return specialRequirements;} public void setSpecialRequirements(String specialRequirements){this.specialRequirements=specialRequirements;}
 public LocalDateTime getRegisteredAt(){return registeredAt;} public void setRegisteredAt(LocalDateTime registeredAt){this.registeredAt=registeredAt;} public String getFeedback(){return feedback;} public void setFeedback(String feedback){this.feedback=feedback;} public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
}
