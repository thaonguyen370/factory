package com.fa.factory.configuration.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "factory")
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "factory_name")
    private String factoryName;

}
