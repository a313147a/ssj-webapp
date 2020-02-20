package com.pl.ay.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by lemon_bar on 15/7/13.
 */
@Data
@MappedSuperclass
public class BaseEntity extends AbstractEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
