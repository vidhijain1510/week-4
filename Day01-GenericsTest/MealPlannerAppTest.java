package com.capgeminitraining.week4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MealPlannerAppTest {
    private MealPlanGenerator mealPlanGenerator;
    private Meal<VegetarianMeal> vegMeal;
    private Meal<VeganMeal> veganMeal;
    private Meal<KetoMeal> ketoMeal;
    private Meal<HighProteinMeal> proteinMeal;

    @BeforeEach
    void setUp() {
        mealPlanGenerator = new MealPlanGenerator();

        vegMeal = new Meal<>(
                "Vegetable Stir-Fry",
                List.of("Carrots", "Broccoli", "Tofu", "Soy Sauce"),
                new VegetarianMeal()
        );

        veganMeal = new Meal<>(
                "Quinoa Salad",
                List.of("Quinoa", "Chickpeas", "Cucumber", "Lemon"),
                new VeganMeal()
        );

        ketoMeal = new Meal<>(
                "Grilled potato with Avocado",
                List.of("Potato", "Avocado", "Olive Oil", "Garlic"),
                new KetoMeal()
        );

        proteinMeal = new Meal<>(
                "Spinach Soup",
                List.of("Spinach", "Cheese", "Olive Oil","Water"),
                new HighProteinMeal()
        );

        mealPlanGenerator.addMeal(vegMeal);
        mealPlanGenerator.addMeal(veganMeal);
        mealPlanGenerator.addMeal(ketoMeal);
        mealPlanGenerator.addMeal(proteinMeal);
    }

    @Test
    void testMealCreation() {
        assertEquals("Vegetable Stir-Fry", vegMeal.getMealName());
        assertEquals(List.of("Carrots", "Broccoli", "Tofu", "Soy Sauce"), vegMeal.getIngredients());
        assertEquals("Vegetarian", vegMeal.getMealType().getMealType());

        assertEquals("Quinoa Salad", veganMeal.getMealName());
        assertEquals(List.of("Quinoa", "Chickpeas", "Cucumber", "Lemon"), veganMeal.getIngredients());
        assertEquals("Vegan", veganMeal.getMealType().getMealType());

        assertEquals("Grilled potato with Avocado", ketoMeal.getMealName());
        assertEquals(List.of("Potato", "Avocado", "Olive Oil", "Garlic"), ketoMeal.getIngredients());
        assertEquals("Keto", ketoMeal.getMealType().getMealType());

        assertEquals("Spinach Soup", proteinMeal.getMealName());
        assertEquals(List.of("Spinach", "Cheese", "Olive Oil", "Water"), proteinMeal.getIngredients());
        assertEquals("High-Protein", proteinMeal.getMealType().getMealType());
    }

    @Test
    void testAddMealToMealPlanGenerator() {
        //Checking the number of meals in the generator
        assertEquals(4, mealPlanGenerator.getMealList().size());
    }
  
}