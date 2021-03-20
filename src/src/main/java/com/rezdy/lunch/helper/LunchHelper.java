package com.rezdy.lunch.helper;

import com.rezdy.lunch.service.ILunchService;
import com.rezdy.lunch.dao.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class LunchHelper {
    @Autowired
    private ILunchService lunchServiceImpl;

    public List<Recipe> getNonExpiredRecipesOnDate(LocalDate date) {
        List<Recipe> recipeList = lunchServiceImpl.getNonExpiredRecipesOnDate(date);
        return sortRecipes(recipeList, date);
    }

    public Recipe getRecipeByTitle(String title) {
        return lunchServiceImpl.getRecipeByTitle(title);
    }

    private List<Recipe> sortRecipes(List<Recipe> recipes, LocalDate date) {
        List<Recipe> sortedRecipe = recipes.stream().filter(recipe -> recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getUseBy().isAfter(date))
                .collect(Collectors.toList()).size() == recipe.getIngredients().size())
                .collect(Collectors.toList());

        if (sortedRecipe.size() > 0) {
            sortedRecipe.stream().filter(recipe -> recipe.getIngredients().stream()
                    .filter(ingredient -> ingredient.getBestBefore().isBefore(date))
                    .filter(ingredient -> ingredient.getUseBy().isAfter(date))
                    .collect(Collectors.toList()).size() == recipe.getIngredients().size())
                    .collect(Collectors.toList());
        }
        return sortedRecipe;
    }
}
