package com.smartcampus.entity;
import jakarta.persistence.*;import jakarta.validation.constraints.*;import java.time.LocalDate;
@Entity @Table(name="events")
public class Event{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String title; @NotBlank private String department; @NotBlank private String type;
 @NotNull private LocalDate eventDate; @NotBlank private String venue; @Min(1) private int seats;
 @Column(length=1200) private String description; private String imageUrl;
 public Event(){}
 public Event(String title,String department,String type,java.time.LocalDate eventDate,String venue,int seats,String imageUrl,String description){this.title=title;this.department=department;this.type=type;this.eventDate=eventDate;this.venue=venue;this.seats=seats;this.imageUrl=imageUrl;this.description=description;}
 public Long getId(){return id;} public void setId(Long id){this.id=id;} public String getTitle(){return title;} public void setTitle(String title){this.title=title;} public String getDepartment(){return department;} public void setDepartment(String department){this.department=department;} public String getType(){return type;} public void setType(String type){this.type=type;} public LocalDate getEventDate(){return eventDate;} public void setEventDate(LocalDate eventDate){this.eventDate=eventDate;} public String getVenue(){return venue;} public void setVenue(String venue){this.venue=venue;} public int getSeats(){return seats;} public void setSeats(int seats){this.seats=seats;} public String getDescription(){return description;} public void setDescription(String description){this.description=description;} public String getImageUrl(){return imageUrl;} public void setImageUrl(String imageUrl){this.imageUrl=imageUrl;}
}
