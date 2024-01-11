package com.epicode.U5D1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*
@jakarta.persistence.Table(name = "tables")
*/
public class Table {
    @Id
    @GeneratedValue
    long tableNumber;

    @OneToMany(mappedBy = "table")
    List<Order> orders;

    int maxNumberOfGuests;
    boolean isOccupied;

    public Table(long tableNumber, int maxGuests) {
        this.tableNumber = tableNumber;
        this.maxNumberOfGuests = maxGuests;
        this.isOccupied = false;
    }
    public Table(int maxGuests) {
        this.maxNumberOfGuests = maxGuests;
        this.isOccupied = false;
    }
}
