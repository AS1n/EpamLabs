package com.netcracker.edu.backend.lab2.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name = "entity")
public class ResMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num")
    private Long num;
    @ManyToOne
    @JoinColumn(name = "entity_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ResEntity resEntity;
}
