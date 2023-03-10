package com.acc.accenfarm.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="chicken", schema="public")
public class Chicken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer buyprice;
    private Integer sellprice;
    private Character activeind;
    private String state;
    private String createdttm;
    private String enddttm;

}
