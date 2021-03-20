package com.rezdy.lunch.controller;

import com.rezdy.lunch.helper.LunchHelper;
import com.rezdy.lunch.dao.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpUtils;
import java.time.LocalDate;
import java.util.List;

@RestController
public class LunchController {

    @Autowired
    private LunchHelper lunchHelper;

    @GetMapping("/lunch")
    public List<Recipe> getRecipes(@RequestParam(value = "date") String date) {
        return lunchHelper.getNonExpiredRecipesOnDate(LocalDate.parse(date));
    }

    @GetMapping("/getRecipe")
    public ResponseEntity<Recipe> getRecipesByTitle(@RequestParam(value = "title") String title) {
        Recipe recipe = lunchHelper.getRecipeByTitle(title);
        return recipe == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(recipe, HttpStatus.OK);
    }
}
