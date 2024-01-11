package com.epicode.U5D1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	int calories;
	double price;
	@ManyToMany
	@JoinTable(name = "items_orders",
			joinColumns = @JoinColumn(name = "order"),
			inverseJoinColumns = @JoinColumn(name = "item"))
	List<Order> orders;

	public Item(int calories, double price) {
		this.calories = calories;
		this.price = price;
	}


}
