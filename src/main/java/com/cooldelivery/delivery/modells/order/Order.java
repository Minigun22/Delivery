package com.cooldelivery.delivery.modells.order;

import com.cooldelivery.delivery.modells.food.Food;
import com.cooldelivery.delivery.modells.customer.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int idOrder;
    @Column(name = "name")
    @NotEmpty(message = "Повинна бути назва")
    @Size(min = 2,max = 100,message = "Назва замовлення має бути від 2 до 100 символів")
    private String name;
    @Column(name = "description")
    @Size(max = 800,message = "Назва замовлення має бути від 0 до 800 символів")
    private String description;
    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "order_food",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> foods;

    public Order(String name, String description, Customer user) {
        this.name = name;
        this.description = description;
        this.customer = user;
    }
}
