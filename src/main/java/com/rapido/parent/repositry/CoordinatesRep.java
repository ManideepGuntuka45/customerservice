package com.rapido.parent.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapido.parent.entity.Coordinates;

@Repository
public interface CoordinatesRep extends JpaRepository<Coordinates, Integer>{
	

}
