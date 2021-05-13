package com.example.kalorie.data.model;

import java.sql.Date;

public class Meal {

    //Required, final attribute.
    private Integer mealId;

    // Required attribute.
    private Date mealDate;

    private int nutrientId;
    private float goalCarb;
    private float goalFat;
    private float goalProtein;
    private float goalCalorie;

    public static class Builder{

        private int mealId;

        private int nutrientId;
        private float goalCarb;
        private float goalFat;
        private float goalProtein;
        private float goalCalorie;

        public Builder(int mealId, Date mealDate){
            this.mealId = mealId;
        }

        public Builder setNutrientId(Integer nutrientId){
            this.nutrientId = nutrientId;
            return this;

        }
        public Builder setGoalCalorie(float goalCalorie){
            this.goalCalorie = goalCalorie;
            return this;
        }

        public Builder setGoalCarb(float goalCarb){
            this.goalCarb = goalCarb;
            return this;
        }

        public Builder setGoalFat(float goalFat){
            this.goalFat = goalFat;
            return this;
        }

        public Builder setAmountProtein(float goalProtein){
            this.goalProtein = goalProtein;
            return this;
        }

        public Meal build(){

            Meal meal = new Meal();

            meal.nutrientId = this.nutrientId;
            meal.goalCalorie = this.goalCalorie;
            meal.goalCarb = this.goalCarb;
            meal.goalProtein = this.goalProtein;
            meal.goalFat = this.goalFat;

            return meal;

        }
    }

    private Meal(){
    }


}
