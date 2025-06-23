package com.example.bshop42.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID registration_id;

    @ManyToMany
    @JoinTable(
            name = "registration_office",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    private List<Office> offices;

    @Column(name = "registration_date")
    private Date date;
    @Column(name = "registration_time")
    private Integer time;

    @ManyToOne
    @JoinColumn(name = "registration_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "registration_barber")
    private Barber barber;
}
