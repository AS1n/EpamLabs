package com.netcracker.edu.backend.lab2.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "map")
public class NumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num")
    private Long num;
    @ManyToOne
    @JoinColumn(name = "entity_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ResEntity entity;

    public NumEntity() {
    }

    public NumEntity(Long num, ResEntity entity) {
        this.num = num;
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public ResEntity getEntity() {
        return entity;
    }

    public void setEntity(ResEntity entity) {
        this.entity = entity;
    }
}
