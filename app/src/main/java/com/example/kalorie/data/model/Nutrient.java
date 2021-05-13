package com.example.kalorie.data.model;

public class Nutrient {

    // Required, final attribute.
    private int nutrientId;

    // Optional attribute.
    private float amountCarb;
    private float amountFat;
    private float amountProtein;
    private float amountCalorie;

    public static class Builder{

        private int nutrientId;

        private float amountCarb;
        private float amountFat;
        private float amountProtein;
        private float amountCalorie;

        public Builder(int nutrientId){
            this.nutrientId = nutrientId;
        }

        public Builder withAmountCalorie(float amountCalorie){
            this.amountCalorie = amountCalorie;
            return this;
        }

        public Builder withAmountCarb(float amountCarb){
            this.amountCarb = amountCarb;
            return this;
        }

        public Builder withAmountFat(float amountFat){
            this.amountFat = amountFat;
            return this;
        }

        public Builder withAmountProtein(float amountProtein){
            this.amountProtein = amountProtein;
            return this;
        }

        public Nutrient build(){

            Nutrient nutrient = new Nutrient();

            nutrient.nutrientId = this.nutrientId;
            nutrient.amountCalorie = this.amountCalorie;
            nutrient.amountCarb = this.amountCarb;
            nutrient.amountProtein = this.amountProtein;
            nutrient.amountFat = this.amountFat;

            return nutrient;

        }
    }

    private Nutrient(){
    }

    public float getAmountCarb() {
        return amountCarb;
    }

    public void setAmountCarb(float amountCarb) {
        this.amountCarb = amountCarb;
    }

    public float getAmountFat() {
        return amountFat;
    }

    public void setAmountFat(float amountFat) {
        this.amountFat = amountFat;
    }

    public float getAmountProtein() {
        return amountProtein;
    }

    public void setAmountProtein(float amountProtein) {
        this.amountProtein = amountProtein;
    }

    public float getAmountCalorie() {
        return amountCalorie;
    }

    public void setAmountCalorie(float amountCalorie) {
        this.amountCalorie = amountCalorie;
    }
}
