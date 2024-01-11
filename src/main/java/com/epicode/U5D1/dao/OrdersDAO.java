package com.epicode.U5D1.dao;

import com.epicode.U5D1.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDAO extends JpaRepository<Order,Long> {
}
