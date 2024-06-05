package com.acme.hormonalcare.backend.calendar.infrastructure.persistence.jpa.repositories;

import com.acme.hormonalcare.backend.calendar.domain.model.aggregates.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long>{
}
