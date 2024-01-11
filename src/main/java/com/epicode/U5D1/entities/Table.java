package com.epicode.U5D1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*
@jakarta.persistence.Table(name = "tables")
*/
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", maxNumberOfGuests=" + maxNumberOfGuests +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
