package com.hit.dm;


import java.util.ArrayList;
import java.util.List;

public class CartObject {
        public ArrayList<Fruit> fruits = new ArrayList<>();
        public int Totalprice;
        public String buyingOptionAlgo;
        public void addFruit(String name,int weight,int price){
            Fruit fruit = new Fruit();
            fruit.setName(name);
            fruit.setPrice(weight);
            fruit.setWeight(price);
            this.fruits.add(fruit);
        }
    }
