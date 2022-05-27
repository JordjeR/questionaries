package com.homework.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}
