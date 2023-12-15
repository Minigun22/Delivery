package com.cooldelivery.delivery.modells.customer;

import com.cooldelivery.delivery.modells.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int idCustomer;
    @Column(name = "name")
    @Size(min = 2,max = 100, message = "Ім'я має бути від 2 до 100 символів")
    @NotEmpty(message = "Повинне бути ім'я")
    private String name;
    @Column(name = "surname")
    @Size(min = 2,max = 100, message = "Прізвище має бути від 2 до 100 символів")
    @NotEmpty(message = "Повинне бути прізвище")
    private String surname;
    @Column(name = "login")
    @NotEmpty(message = "Повинен бути логін")
    @Size(min = 2, max = 50, message = "Логін повинен бути від 2 до 50 символів")
    private String username;
    @Column(name = "password")
    @Size(min = 8,max = 100,message = "Пароль має бути розміром від 8 да 100 символів")
    @NotEmpty(message = "Повинен бути пароль")
    private String password;
    @Min(value = 10, message = "Вік має бути більшим ніж 10")
    @Max(value = 100, message = "Вік має бути меншим ніж 100")
    @Column(name = "age")
    @NotEmpty(message = "Повинний бути вік")
    private int age;
    @OneToMany(mappedBy = "customer")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Order> orders;

    public Customer(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getFullName(){
        return getSurname() + getName();
    }

    @Override
    public String toString() {
        return getIdCustomer() + ". " + getFullName() + ", " + getAge() + "(" + orders.size() + ")";
    }
}
