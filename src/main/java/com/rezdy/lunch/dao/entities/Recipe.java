package com.rezdy.lunch.dao.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @Column(name="recipe_id")
    private int recipeId;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    public String getTitle() {
        return title;
    }

    public Recipe setTitle(String title) {
        this.title = title;
        return this;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
