package com.rezdy.lunch.service;

import com.rezdy.lunch.dao.entities.Recipe;

import java.time.LocalDate;
import java.util.List;


public interface ILunchService {
    List<Recipe> getNonExpiredRecipesOnDate(LocalDate date);

    Recipe getRecipeByTitle(String title);

}
