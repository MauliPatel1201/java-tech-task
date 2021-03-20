package com.rezdy.lunch.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="ingredient")
public class Ingredient {

    @Id
    @Column(name="ingredient_id")
    private int ingredientId;

    @Column(name="title")
    private String title;

    @Column(name="best_before")
    private LocalDate bestBefore;

    @Column(name="use_by")
    private LocalDate useBy;

    public String getTitle() {
        return title;
    }

    public Ingredient setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public Ingredient setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
        return this;
    }

    public LocalDate getUseBy() {
        return useBy;
    }

    public Ingredient setUseBy(LocalDate useBy) {
        this.useBy = useBy;
        return this;
    }
}
