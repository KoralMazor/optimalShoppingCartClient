package com.hit.controller;

import com.hit.model.IModel;
import com.hit.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View viewModel;
    private IModel modelModel;
    public Controller(View viewModel) {
        this.modelModel = modelModel;
        this.viewModel = viewModel;

        this.viewModel.addBtnListner(new addBtnListner());
        this.viewModel.rmvBtnListner(new rmvBtnListner());
        this.viewModel.SendBtnListner(new SendBtnListner());
    }



    private class addBtnListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("GERE");
            viewModel.addToList();
        }
    }

    private class rmvBtnListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewModel.removeFromList();
        }
    }

    private class SendBtnListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewModel.getUIParamToJSON();
            viewModel.infoBox();

        }
    }
    public void loadUI(){
        viewModel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewModel.setSize(450, 450);
        viewModel.setVisible(true);
        viewModel.pack();
    }

}
