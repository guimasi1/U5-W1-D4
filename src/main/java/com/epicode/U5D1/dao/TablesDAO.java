package com.epicode.U5D1.dao;

import com.epicode.U5D1.entities.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablesDAO extends JpaRepository<Table, Long> {
     List<Table> findByMaxNumberOfGuests(int maxNumberOfGuests);
}
