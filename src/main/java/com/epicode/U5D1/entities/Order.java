package com.epicode.U5D1.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@ToString
// Serve per specificare come si chiama il file con le var d'ambiente
public class Order {

    List<Item> items;
    int orderNumber;
    OrderStatus orderStatus;
    Table table;
    int numberOfGuests;
    LocalDateTime orderPlacementTime;
    double totalCost;

    public Order(List<Item> items, int orderNumber, OrderStatus orderStatus, Table table, int numberOfGuests, LocalDateTime orderPlacementTime,double coverFee) {
        if(numberOfGuests > table.getMaxNumberOfGuests()) throw new IllegalArgumentException("Il numero di ospiti deve essere minore di " + table.getMaxNumberOfGuests());

        this.items = items;
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;

        this.table = table;
        this.numberOfGuests = numberOfGuests;
        this.orderPlacementTime = orderPlacementTime;
        this.totalCost = (numberOfGuests * coverFee) + items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
