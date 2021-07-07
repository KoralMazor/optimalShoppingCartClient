package com.hit.view;

import com.hit.controller.Controller;

public class makeView {
    public static void main (String[] args) {
        View myview = new View();
        Controller controller = new Controller(myview);
       // myview.loadJsonTolist();
        controller.loadUI();
    }
}
