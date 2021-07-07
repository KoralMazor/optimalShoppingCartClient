package com.hit.view;

import com.hit.controller.Controller;
import com.hit.model.Client;

import java.awt.*;
import java.io.IOException;

public class makeView {
    public static void main (String[] args) {
        View myview = new View();
        Controller controller = new Controller(myview);
        myview.setPreferredSize(new Dimension(713 , 674));
        myview.setMinimumSize(new Dimension(713 , 674));
        myview.setMaximumSize(new Dimension(713 , 674));
        myview.pack();
        controller.loadUI();
        Client c = new Client();
        c.run();


    }
}
