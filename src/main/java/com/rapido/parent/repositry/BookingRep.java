package com.rapido.parent.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapido.parent.entity.Booking;

public interface BookingRep extends JpaRepository<Booking, Integer>{

}
