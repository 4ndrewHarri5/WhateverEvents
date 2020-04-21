package com.machesterdigital.event_manager.repository;

import com.machesterdigital.event_manager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {


}
