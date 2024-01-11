package com.epicode.U5D1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
/*@jakarta.persistence.Table(name = "orders")*/
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long orderNumber;

    @ManyToMany
    @JoinTable(name = "items_orders",
            joinColumns = @JoinColumn(name = "item"),
            inverseJoinColumns = @JoinColumn(name = "order"))
    List<Item> items;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "table_id")
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
