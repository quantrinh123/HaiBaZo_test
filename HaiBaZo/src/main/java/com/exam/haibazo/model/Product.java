package com.exam.haibazo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;

    String name;
    String description;
    BigDecimal price;
    BigDecimal originalPrice;
    String image;
    int stockQuantity;

    @Temporal(TemporalType.TIMESTAMP)
    Date offerEndTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore // Prevent circular reference if Category references Product
    Category category;

    @ManyToMany
    @JoinTable(
            name = "product_style",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "style_id")
    )
    List<Style> styles;

    @ManyToMany
    @JoinTable(
            name = "product_color",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    List<Color> colors;

    @ManyToMany
    @JoinTable(
            name = "product_size",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id")
    )
    List<Size> sizes;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore // Prevent circular reference
    private List<Cart> carts;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
