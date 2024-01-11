package com.epicode.U5D1.dao;

import com.epicode.U5D1.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuDAO extends JpaRepository<Menu,Long> {

}
