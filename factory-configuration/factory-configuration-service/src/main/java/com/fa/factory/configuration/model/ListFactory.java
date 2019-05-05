package com.fa.factory.configuration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "list_factory")
public class ListFactory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "factory_name")
    String factoryName;
    @Column(name = "country")
    String country;
    @Column(name = "city")
    String city;
    @Column(name = "task_contact")
    String taskContact;
    @Column(name = "eandon")
    String eadon;
    @Column(name = "time_zone")
    String timeZone;
}


