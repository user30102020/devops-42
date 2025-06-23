package com.example.bshop42.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "workplaces")
public class Workplace {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID workplace_id;

    @Column(name = "workplace_address")
    private String address;

    @OneToMany(mappedBy = "workplace", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Barber> barbers;
}
