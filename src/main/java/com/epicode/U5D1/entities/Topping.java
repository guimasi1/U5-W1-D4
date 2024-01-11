package com.epicode.U5D1.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "toppings")
public class Topping extends Item {

	private String name;
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;
	@ManyToMany
	@JoinTable(name= "toppings_pizzas",joinColumns = @JoinColumn( name = "toppings"), inverseJoinColumns =@JoinColumn( name = "pizzas"))
	private List<Pizza> pizzas;

	public Topping(String name, int calories, double price) {
		super(calories, price);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Topping{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				'}';
	}
}
