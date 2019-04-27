package com.netcracker.edu.backend.lab2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entity")
public class ResEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_even")
    private boolean isEven;
    @Column(name = "is_simple")
    private boolean isSimple;

    public ResEntity() {
    }

    public ResEntity(boolean isEven, boolean isSimple) {
        this.isEven = isEven;
        this.isSimple = isSimple;
    }

    public ResEntity(Long num) {
        this(getEven(num), getSimple(num));
    }

    private static boolean getEven(Long num) {
        return num % 2 == 0;
    }

    private static boolean getSimple(Long num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public void setSimple(boolean simple) {
        isSimple = simple;
    }

    @Override
    public String toString() {
        return "ResEntity{" +
                "isEven=" + isEven +
                ", isSimple=" + isSimple +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResEntity entity = (ResEntity) o;
        return isEven == entity.isEven &&
                isSimple == entity.isSimple;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isEven, isSimple);
    }
}
