package com.smartcampus.repository;
import com.smartcampus.entity.*;import org.springframework.data.jpa.repository.*;import java.util.*;
public interface RegistrationRepository extends JpaRepository<EventRegistration,Long>{
 List<EventRegistration> findByUser(User user); boolean existsByUserAndEvent(User user, Event event); long countByEvent(Event event);
 @Query("select r.event.title, count(r) from EventRegistration r group by r.event.title") List<Object[]> countByEventTitle();
}
