package com.mocos.mocos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    private String productName;
    private String description;
    private Double price;
    private String duration;



    public Admin(Admin newUpdate) {
        this.productName = newUpdate.getProductName();
        this.description = newUpdate.getDescription();
        this.price = newUpdate.getPrice();
        this.duration = newUpdate.getDuration();
    }
}
