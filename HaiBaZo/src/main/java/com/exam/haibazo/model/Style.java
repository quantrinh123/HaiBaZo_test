package com.exam.haibazo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="style")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long styleId;

     String name;

    @ManyToMany(mappedBy = "styles")
    List<Product> products;
}
