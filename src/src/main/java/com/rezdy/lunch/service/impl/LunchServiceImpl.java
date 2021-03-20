package com.rezdy.lunch.service.impl;

import com.rezdy.lunch.service.ILunchService;
import com.rezdy.lunch.dao.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LunchServiceImpl implements ILunchService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Recipe> getNonExpiredRecipesOnDate(LocalDate date) {
     return loadRecipes(date);
    }

    @Override
    public Recipe getRecipeByTitle(String title) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recipe> criteriaQuery = cb.createQuery(Recipe.class);
        Root<Recipe> recipeRoot = criteriaQuery.from(Recipe.class);

        CriteriaQuery<Recipe> query = criteriaQuery.select(recipeRoot).where(cb.equal(recipeRoot.get("title"), title));
        return entityManager.createQuery(query).getResultList().stream().findFirst().orElse(null);
    }

    public List<Recipe> loadRecipes(LocalDate date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recipe> criteriaQuery = cb.createQuery(Recipe.class);
        Root<Recipe> recipeRoot = criteriaQuery.from(Recipe.class);
        CriteriaQuery<Recipe> query = criteriaQuery.select(recipeRoot);
        return entityManager.createQuery(query).getResultList();
    }

}
