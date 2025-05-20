package org.cooksystem.models;

import java.util.List;

public class Meal {

    private final String name;
    private final List<String> ingredients;

    public Meal(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Meal: " + name + ", Ingredients: " + ingredients;
    }
}
