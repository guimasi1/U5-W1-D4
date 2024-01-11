package com.epicode.U5D1.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
public class Table {
    int tableNumber;
    int maxNumberOfGuests;
    boolean isOccupied;

    public Table(int tableNumber, int maxGuests) {
        this.tableNumber = tableNumber;
        this.maxNumberOfGuests = maxGuests;
        this.isOccupied = false;
    }
}
