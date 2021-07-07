package com.hit.model;

import java.util.List;

public class IModel {
    public static class Fruit{
        public String name;
        public int weight;
        public int price;

        public void setPrice(int price) {
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPrice() {
            return price;
        }

        public int getWeight() {
            return weight;
        }

        public String getName() {
            return name;
        }
    }

    public static class TotalPrice{
        public int price;

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public static class BuyingOptionAlgo{
        public String buyingOptionAlgo;

        public void setBuyingOptionAlgo(String buyingOptionAlgo) {
            this.buyingOptionAlgo = buyingOptionAlgo;
        }

        public String getBuyingOptionAlgo() {
            return buyingOptionAlgo;
        }
    }
}
