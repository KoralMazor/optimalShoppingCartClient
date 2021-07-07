package com.hit.view;

import com.google.gson.Gson;
import com.hit.dm.CartObject;
import com.hit.dm.Fruit;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class View extends JFrame {
    private JList list1;
    private JList list2;
    private JLabel text2;
    private JLabel text1;
    private JCheckBox checkAlgo1;
    private JCheckBox checkAlgo2;
    private JButton rmvBtn;
    private JButton resetBtn;
    private JButton addBtn;
    private JButton goBtn;
    private JList list3;
    private JLabel textGList;
    private JLabel txtServer;
    private JTextField txtfMax;
    private JLabel txtmax;
    private int mHoveredJListIndex = -1;
    private JWindow popup;
    private int clicks = 0;
    private JLabel titleLabel;
    private JTextPane textPane;
    private DefaultListModel model;
    private DefaultListModel model2;
    private DefaultListModel model3;
    private ArrayList<Fruit> TenmpArray = new ArrayList<>();
    private ArrayList<Fruit> FinalListArray = new ArrayList<>();
    String tempString = "{\n" +
            "  \"fruits\" : [\n" +
            "  {\n" +
            "  \"name\" : \"Apple\",\n" +
            "  \"weight\": 60,\n" +
            "  \"price\" : 10\n" +
            "  },\n" +
            "  {\n" +
            "  \"name\" : \"Banana\",\n" +
            "  \"weight\": 100,\n" +
            "  \"price\" : 20\n" +
            "  },\n" +
            "  {\n" +
            "  \"name\" : \"Apricots\",\n" +
            "  \"weight\": 120,\n" +
            "  \"price\" : 30\n" +
            "  }\n" +
            "],\n" +
            "\"totalPrice\" :  [\n" +
            "  {\n" +
            "    \"price\": 50\n" +
            "  }\n" +
            "],\n" +
            "\"buyingOptionAlgo\": [\n" +
            "  {\n" +
            "    \"buyingOptionAlgo\": \"oneOrZero\"\n" +
            "  }\n" +
            "]}";
    String s2 = "{\n" +
            "\n" +
            "  \"fruits\" : [\n" +
            "    {\n" +
            "      \"name\" : \"Apple\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg\",\n" +
            "      \"weight\": 3,\n" +
            "      \"price\" : 35\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Banana\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Bananas_white_background_DS.jpg/320px-Bananas_white_background_DS.jpg\",\n" +
            "      \"weight\": 21,\n" +
            "      \"price\" : 12\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Apricots\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2015/01/apricot_small.jpg\",\n" +
            "      \"weight\": 1,\n" +
            "      \"price\" : 45\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Avocado\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2015/01/avocado_small.jpg\",\n" +
            "      \"weight\": 7,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Pineapple\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Pineapple_and_cross_section.jpg/286px-Pineapple_and_cross_section.jpg\",\n" +
            "      \"weight\": 122,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Blueberries\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2015/01/blueberries_small.jpg\",\n" +
            "      \"weight\": 31,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Coconut\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2015/01/coconutmeat_small.gif\",\n" +
            "      \"weight\": 2311,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Grapefruit\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2015/01/grapefruit_samll.gif\",\n" +
            "      \"weight\": 5,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Guava\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2015/01/guava_small.jpg\",\n" +
            "      \"weight\": 12,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Mango\",\n" +
            "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Pineapple_and_cross_section.jpg/286px-Pineapple_and_cross_section.jpg\",\n" +
            "      \"weight\": 8,\n" +
            "      \"price\" : 200\n" +
            "    }\n" +
            "  ],\n" +
            "  \"vegetables\" : [\n" +
            "    {\n" +
            "      \"name\":\"Cabbage\",\n" +
            "      \"photo_url\":\"https://www.freepngimg.com/thumb/categories/2970.png\",\n" +
            "      \"weight\": 12,\n" +
            "      \"price\": 30\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\":\"Garlic\",\n" +
            "      \"photo_url\":\"https://www.freepngimg.com/thumb/garlic/2-2-garlic-transparent-thumb.png\",\n" +
            "      \"weight\": 5,\n" +
            "      \"price\": 20\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\":\"Tomatoes\",\n" +
            "      \"photo_url\":\"https://www.freepngimg.com/thumb/categories/2985.png\",\n" +
            "      \"weight\": 12,\n" +
            "      \"price\": 5\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\":\"Carrots\",\n" +
            "      \"photo_url\":\"https://www.freepngimg.com/thumb/categories/2971.png\",\n" +
            "      \"weight\": 2,\n" +
            "      \"price\": 60\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\":\"Onions\",\n" +
            "      \"photo_url\":\"https://www.freepngimg.com/thumb/onion/10-red-onion-png-image-thumb.png\",\n" +
            "      \"weight\": 2,\n" +
            "      \"price\": 120\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\":\"Potatoes\",\n" +
            "      \"photo_url\":\"https://www.freepngimg.com/thumb/potato/7-potato-png-images-pictures-download-thumb.png\",\n" +
            "      \"weight\": 3,\n" +
            "      \"price\": 80\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Artichoke\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2014/12/artichoke_small.gif\",\n" +
            "      \"weight\": 2,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Arugula\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2014/12/arugula_small.gif\",\n" +
            "      \"weight\": 2,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Broccoli\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2014/12/broccoli_small.jpg\",\n" +
            "      \"weight\": 2,\n" +
            "      \"price\" : 200\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\" : \"Lettuce,\",\n" +
            "      \"image\" : \"https://halfyourplate-4kgxi1gvwldjzby.stackpathdns.com/wp-content/uploads/2015/01/lettuceiceberg_small.gif\",\n" +
            "      \"weight\": 2,\n" +
            "      \"price\" : 200\n" +
            "    }\n" +
            "  ]\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n";

    public String getUIParamToJSON(){
        CartObject cartObject = new CartObject();
        for(int i = 0 ; i < list2.getModel().getSize();i++){
            cartObject.addFruit(FinalListArray.get(i).getName(),FinalListArray.get(i).getWeight(),FinalListArray.get(i).getPrice());
        }
        //cartObject.Totalprice = getMaxAmount(); // To fix
        cartObject.buyingOptionAlgo = getAlgo();
        Gson gSon = new Gson();
        //System.out.println(gSon.toJson(cartObject));
        return gSon.toJson(cartObject);
    }

    public void setOurCart(){

    }
    public void setUserCart(){

    }
    public void setAlgoCart(){

    }
    public int getMaxAmount(){
        return Integer.valueOf(txtmax.getText());
    }
    public String getAlgo(){
        if(checkAlgo1.isSelected()){
            return "KnapsackOneOrZeroAlgo";
        }else if(checkAlgo2.isSelected()){
            return "KnapsackUnboundedAlgo";
        }
        return null;
    }
    public void SendBtnListner(ActionListener actionListener){
        goBtn.addActionListener(actionListener);
    }
    public void addBtnListner(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }
    public void rmvBtnListner(ActionListener actionListener){
        rmvBtn.addActionListener(actionListener);
    }
    public void checkAlgo1nListner(ActionListener actionListener){
        checkAlgo1.addActionListener(actionListener);
    }
    public void checkAlgo2nListner(ActionListener actionListener){
        checkAlgo2.addActionListener(actionListener);
    }
    public void removeFromList(){
        int selectedIdx = list2.getSelectionModel().getAnchorSelectionIndex();
        model2.remove(selectedIdx);
        FinalListArray.remove(selectedIdx);
    }
    public void addToList(){
        int selectedIdx = list1.getSelectionModel().getAnchorSelectionIndex();
        model2.addElement(model.get(selectedIdx));
        FinalListArray.add(TenmpArray.get(selectedIdx));
    }
    public static void loadUI(){
        View view = new View();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(450, 450);
        view.setVisible(true);
    }
    public View() {
        super("Optimal Cart");
         model = new DefaultListModel();
         model2 = new DefaultListModel();
         model3 = new DefaultListModel();
        list1 = new JList (model);
        list2 = new JList (model2);
        text2 = new JLabel ("Your list");
        text1 = new JLabel ("Our list");
        checkAlgo1 = new JCheckBox ("Algo 1");
        checkAlgo2 = new JCheckBox ("Algo 2");
        rmvBtn = new JButton ("Remove");
        resetBtn = new JButton ("Reset");
        addBtn = new JButton ("Add");
        goBtn = new JButton ("Go!");
        list3 = new JList (model3);
        textGList = new JLabel ("Generated  cart");
        txtServer = new JLabel ("Server Status");
        txtfMax = new JTextField (5);
        txtmax = new JLabel ("Max Amount");
        popup = new JWindow();

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 572));
        setLayout (null);

        add(new JScrollPane(list1));
        add(new JScrollPane(list2));
        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //add components
        add (list1);
        add (list2);
        add (text2);
        add (text1);
        add (checkAlgo1);
        add (checkAlgo2);
        add (rmvBtn);
        add (resetBtn);
        add (addBtn);
        add (goBtn);
        add (list3);
        add (textGList);
        add (txtServer);
        add (txtfMax);
        add (txtmax);

        list1.setBounds (15, 25, 230, 265);
        list2.setBounds (365, 25, 250, 270);
        text2.setBounds (450, 0, 100, 25);
        text1.setBounds (100, 0, 100, 25);
        checkAlgo1.setBounds (30, 390, 65, 25);
        checkAlgo2.setBounds (30, 370, 60, 25);
        rmvBtn.setBounds (260, 155, 100, 25);
        resetBtn.setBounds (260, 185, 100, 25);
        addBtn.setBounds (260, 130, 100, 25);
        goBtn.setBounds (140, 340, 70, 65);
        list3.setBounds (220, 325, 395, 245);
        textGList.setBounds (230, 300, 145, 25);
        txtServer.setBounds (135, 405, 100, 25);
        txtfMax.setBounds (30, 345, 100, 25);
        txtmax.setBounds (45, 325, 85, 20);

        titleLabel = new JLabel();
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        titleLabel.setHorizontalAlignment(JLabel.LEFT);
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(titleLabel);
        textPane = new JTextPane();
        textPane.setEditable(false);
        //textPane.setText();
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPanel.add(titlePanel, BorderLayout.NORTH);
        contentPanel.add(textPane);


        // Load Json
        JSONObject jsonObject = new JSONObject(s2);
        JSONArray fruits = jsonObject.getJSONArray("fruits");
        for(int i = 0 ; i < fruits.length() ; i++){
            Fruit tempFruit = new Fruit();
            tempFruit.setName(fruits.getJSONObject(i).getString("name"));
            tempFruit.setWeight(fruits.getJSONObject(i).getInt("weight"));
            tempFruit.setPrice(fruits.getJSONObject(i).getInt("price"));
            tempFruit.setId(i);
            TenmpArray.add(tempFruit);
        }
        // Load to list 1
        for(int i = 0 ; i < TenmpArray.size();i++){
            model.addElement(TenmpArray.get(i).getName());
        }



        list1.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent me) {
                Object value = list1.getSelectedValue();
                Point p = new Point(me.getX(), me.getY());
                int index = list1.locationToIndex(p);
                if (value != null) {
                    if (index != mHoveredJListIndex) {
                        mHoveredJListIndex = index;
                        list1.repaint();
                        popup.setLocation(list1.getLocationOnScreen().x + list1.getWidth(),
                                list1.getLocationOnScreen().y);
                        popup.setContentPane(contentPanel);
                        popup.revalidate();
                        popup.pack();
                       popup.setVisible(true);
                        int selectedIdx = list1.getSelectionModel().getAnchorSelectionIndex();
                        titleLabel.setText("Price : "+TenmpArray.get(selectedIdx).getPrice());
                        textPane.setText("Weight : "+TenmpArray.get(selectedIdx).getWeight());
                        clicks++;
                    }
                }else{
                    if (popup.isVisible()) {
                        popup.setVisible(false);
                    }
                }

            }

        });

    }

}


