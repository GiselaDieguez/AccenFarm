package com.acc.accenfarm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name="chicken", schema="public")
public class Chicken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private Integer Quantity;
    private String Date;
}
