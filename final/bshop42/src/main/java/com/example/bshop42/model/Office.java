package com.example.bshop42.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID office_id;

    @Column(name = "office_name")
    private String name;

    @Column(name = "office_price")
    private Integer price;

    @Column(name = "office_description")
    private String description;

    @ManyToMany(mappedBy = "offices")
    private List<Registration> registrations;
}
