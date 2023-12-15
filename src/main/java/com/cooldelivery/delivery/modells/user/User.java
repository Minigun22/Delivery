package com.cooldelivery.delivery.modells.user;

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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int idUser;
    @Column(name = "name")
    @Size(min = 2,max = 100, message = "Ім'я має бути від 2 до 100 символів")
    @NotEmpty
    private String name;
    @Column(name = "surname")
    @Size(min = 2,max = 100, message = "Прізвище має бути від 2 до 100 символів")
    @NotEmpty
    private String surname;
    @Min(value = 10, message = "Вік має бути більшим ніж 10")
    @Max(value = 100, message = "Вік має бути меншим ніж 100")
    @Column(name = "age")
    @NotEmpty
    private int age;
    @OneToMany(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Order> orders;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getFullName(){
        return getSurname() + getName();
    }

    @Override
    public String toString() {
        return getIdUser() + ". " + getFullName() + ", " + getAge() + "(" + orders.size() + ")";
    }
}
