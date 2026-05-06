package com.smartcampus.repository;
import com.smartcampus.entity.Event;import org.springframework.data.jpa.repository.JpaRepository;import java.time.LocalDate;import java.util.List;
public interface EventRepository extends JpaRepository<Event,Long>{ List<Event> findByDepartmentContainingIgnoreCaseAndTypeContainingIgnoreCase(String department,String type); List<Event> findByEventDateAfter(LocalDate date); }
