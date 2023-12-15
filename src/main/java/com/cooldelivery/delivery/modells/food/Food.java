package com.cooldelivery.delivery.modells.food;

import com.cooldelivery.delivery.modells.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private int idFood;
    @Column(name = "name")
    @NotEmpty(message = "Повинна бути назва")
    private String name;
    @NotEmpty(message = "Повинна бути ціна")
    @Column(name = "price")
    private int price;
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Повинна тип продукту")
    @Column(name = "type")
    private FoodType type;
    @ManyToMany(mappedBy = "foods")
    private List<Order> orders;

    public Food(String name, int price, FoodType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
