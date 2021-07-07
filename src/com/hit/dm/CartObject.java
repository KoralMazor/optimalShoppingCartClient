package com.hit.dm;


import java.util.ArrayList;

public class CartObject {
        public ArrayList<Array> fruits = new ArrayList<>();
        public int Totalprice;
        public String buyingOptionAlgo;
        public void addFruit(String name,int weight,int price){
            Array fruit = new Array();
            fruit.setName(name);
            fruit.setPrice(weight);
            fruit.setWeight(price);
            this.fruits.add(fruit);
        }
    }
