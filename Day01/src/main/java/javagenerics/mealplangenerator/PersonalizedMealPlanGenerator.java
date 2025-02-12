package javagenerics.mealplangenerator;

import java.util.*;
import static java.lang.System.*;

// MealPlan interface
interface MealPlan {
    void showMeal();
}

// Vegetarian Meal
class VegetarianMeal implements MealPlan {
    private String dish;

    public VegetarianMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void showMeal() {
        out.println("Vegetarian Meal: " + dish);
    }
}

// Vegan Meal
class VeganMeal implements MealPlan {
    private String dish;

    public VeganMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void showMeal() {
        out.println("Vegan Meal: " + dish);
    }
}

// Keto Meal
class KetoMeal implements MealPlan {
    private String dish;

    public KetoMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void showMeal() {
        out.println("Keto Meal: " + dish);
    }
}

// High-Protein Meal
class HighProteinMeal implements MealPlan {
    private String dish;

    public HighProteinMeal(String dish) {
        this.dish = dish;
    }

    @Override
    public void showMeal() {
        out.println("High-Protein Meal: " + dish);
    }
}

// Generic Meal Manager
class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public void showMeals() {
        for (T meal : meals) {
            meal.showMeal();
        }
    }

    // Generic method to validate and generate a meal plan
    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
        out.println("Generated Meal Plan:");
        for (T meal : meals) {
            meal.showMeal();
        }
    }
}
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeals = new Meal<>();
        vegMeals.addMeal(new VegetarianMeal("Grilled Paneer Salad"));
        vegMeals.addMeal(new VegetarianMeal("Vegetable Stir Fry"));

        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal("Veg Rice Biryani"));
        veganMeals.addMeal(new VeganMeal("Vegies and Chapati"));

        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal("Avocado & Egg Curry"));
        ketoMeals.addMeal(new KetoMeal("Roasted Chicken with Butter"));

        Meal<HighProteinMeal> proteinMeals = new Meal<>();
        proteinMeals.addMeal(new HighProteinMeal("Broccoli and Paneer tikka"));
        proteinMeals.addMeal(new HighProteinMeal("Fish Meat"));

        out.println("--------Vegetarian Meals-------");
        vegMeals.showMeals();

        out.println("\n--------Vegan Meals--------");
        veganMeals.showMeals();

        out.println("\n---------Keto Meals---------");
        ketoMeals.showMeals();

        out.println("\n---------High-Protein Meals---------");
        proteinMeals.showMeals();

        // Using generic method to generate a meal plan dynamically
        List<MealPlan> allMeals = new ArrayList<>();
        allMeals.add(new VegetarianMeal("Mushroom Pasta"));
        allMeals.add(new VeganMeal("Protein Smoothie"));
        allMeals.add(new KetoMeal("Steak with Greens"));
        allMeals.add(new HighProteinMeal("Egg White Omelette"));

        out.println("\n---------Personalized Meal Plan---------");
        Meal.generateMealPlan(allMeals);
    }
}
