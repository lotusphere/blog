package com.lotusphere.user_management;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
// @Entity: Marks the class as a JPA entity, which means it is a persistent Java object and should be mapped to a database table.
@Table(indexes = {@Index(name = "uk_email",columnList = "email",unique = true)})
// @Table: Specifies the details of the table that the entity is mapped to. This includes the table name and any indexes.
// @Index: Used within the @Table annotation to define indexes on columns.
public class User {

    @Id
    // @Id: Specifies the primary key of an entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GenerateValue: Provides the specification for the generation strategy of primary key values.
    private int id;

    @Column(nullable = false, columnDefinition = "varchar(20) comment 'name'")
    // @Column: Specifies the details of the column to which a field or property is mapped. This includes the column name, whether it's nullable, its length, etc.
    private String name;

    @Transient
    // @Transient: Specifies that a field or property is not persistent and should not be mapped to the database.
    private int age;

    @Column(nullable = false, length = 50)
    private String email;

    private LocalDate birthday;
}


