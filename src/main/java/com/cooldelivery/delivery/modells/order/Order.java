package com.cooldelivery.delivery.modells.order;

import com.cooldelivery.delivery.modells.food.Food;
import com.cooldelivery.delivery.modells.user.User;
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
    @NotEmpty
    @Size(min = 2,max = 100,message = "Назва замовлення має бути від 2 до 100 символів")
    private String name;
    @Column(name = "description")
    @Size(max = 800,message = "Назва замовлення має бути від 0 до 800 символів")
    private String description;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name = "order_food",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> foods;

    public Order(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }
}
