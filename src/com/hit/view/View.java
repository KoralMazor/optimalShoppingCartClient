package com.hit.view;

import com.google.gson.Gson;
import com.hit.dm.CartObject;
import com.hit.dm.Array;
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
    private JLabel AppTitle;
    private ArrayList<Array> TenmpArray = new ArrayList<>();
    private ArrayList<Array> FinalListArray = new ArrayList<>();
    private JLabel text3;
    private JLabel TitleText;
    String s2 = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"name\" : \"Apple\",\n" +
            "    \"weight\": 60,\n" +
            "    \"price\" : 10\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"name\" : \"Banana\",\n" +
            "    \"weight\": 100,\n" +
            "    \"price\" : 20\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"name\" : \"Apricots\",\n" +
            "    \"weight\": 120,\n" +
            "    \"price\" : 30\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"name\" : \"Avocado\",\n" +
            "    \"weight\": 30,\n" +
            "    \"price\" : 6\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"name\" : \"Pineapple\",\n" +
            "    \"weight\": 14,\n" +
            "    \"price\" : 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"name\" : \"Blueberries\",\n" +
            "    \"weight\": 16,\n" +
            "    \"price\" : 4\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"name\" : \"Coconut\",\n" +
            "    \"weight\": 9,\n" +
            "    \"price\" : 2\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"name\" : \"Grapefruit\",\n" +
            "    \"weight\": 5,\n" +
            "    \"price\" : 2\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"name\" : \"Guava\",\n" +
            "    \"weight\": 12,\n" +
            "    \"price\" : 10\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 10,\n" +
            "    \"name\" : \"Mango\",\n" +
            "    \"weight\": 60,\n" +
            "    \"price\" : 10\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 11,\n" +
            "    \"name\":\"Cabbage\",\n" +
            "    \"weight\": 100,\n" +
            "    \"price\": 20\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 12,\n" +
            "    \"name\":\"Garlic\",\n" +
            "    \"weight\": 30,\n" +
            "    \"price\": 6\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 13,\n" +
            "    \"name\":\"Tomatoes\",\n" +
            "    \"weight\": 120,\n" +
            "    \"price\": 30\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 14,\n" +
            "    \"name\":\"Carrots\",\n" +
            "    \"weight\": 14,\n" +
            "    \"price\": 3\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 15,\n" +
            "    \"name\":\"Onions\",\n" +
            "    \"weight\": 2,\n" +
            "    \"price\": 17\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 16,\n" +
            "    \"name\":\"Potatoes\",\n" +
            "    \"weight\": 3,\n" +
            "    \"price\": 80\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 17,\n" +
            "    \"name\" : \"Artichoke\",\n" +
            "    \"weight\": 10,\n" +
            "    \"price\" : 100\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 18,\n" +
            "    \"name\" : \"Arugula\",\n" +
            "    \"weight\": 9,\n" +
            "    \"price\" : 2\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 19,\n" +
            "    \"name\" : \"Broccoli\",\n" +
            "    \"weight\": 2,\n" +
            "    \"price\" : 30\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 20,\n" +
            "    \"name\" : \"Lettuce\",\n" +
            "    \"weight\": 16,\n" +
            "    \"price\" : 4\n" +
            "  }\n" +
            "]\n" +
            "\n" +
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
    public void LloadOptimalList(){

    }
    public static void loadUI(){
        View view = new View();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(450, 450);
        view.setVisible(true);
    }
        public static void infoBox()
        {
            JOptionPane.showMessageDialog(null, "Your request was sent to server", "Sent!" , JOptionPane.INFORMATION_MESSAGE);
        }
    public View() {
        super("Optimal Cart");
         model = new DefaultListModel();
         model2 = new DefaultListModel();
         model3 = new DefaultListModel();
        list1 = new JList (model);
        list2 = new JList (model2);
        text2 = new JLabel ("Your Shopping list");
        text1 = new JLabel ("Products list");
        checkAlgo1 = new JCheckBox ("One or zero items ");
        checkAlgo2 = new JCheckBox ("Unbounded same item ");
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
        AppTitle = new JLabel ("AppTitle");
        text3 = new JLabel (" Your Optimal Shopping Cart");
        TitleText = new JLabel ("Optimal Shopping Cart");
        //adjust size and set layout
        setPreferredSize (new Dimension (701, 629));
        setContentPane(new JLabel(new ImageIcon(View.class
                .getClassLoader().getResource("back.jpg"))));
        setLayout(null);
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
        add (text3);
        add (TitleText);

        list1.setBounds (40, 75, 240, 325);
        list2.setBounds (450, 75, 245, 325);
        TitleText.setBounds (290, 10, 140, 35);
        text1.setBounds (110, 50, 100, 25);
        text2.setBounds (510, 50, 125, 25);
        addBtn.setBounds (315, 175, 100, 25);
        rmvBtn.setBounds (315, 215, 100, 25);
        txtmax.setBounds (90, 410, 145, 30);
        txtfMax.setBounds (85, 435, 130, 25);
        checkAlgo1.setBounds (65, 455, 170, 30);
        checkAlgo2.setBounds (65, 485, 180, 25);
        goBtn.setBounds (275, 430, 80, 75);
        list3.setBounds (375, 425, 315, 185);
        text3.setBounds (460, 400, 200, 25);

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
        JSONArray fruits = new JSONArray(s2);
        for(int i = 0 ; i < fruits.length() ; i++){
            Array tempFruit = new Array();
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
            @Override
            public void mouseExited(MouseEvent e) {
                popup.setVisible(false);
            }

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
        list2.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                popup.setVisible(false);
            }

            public void mouseMoved(MouseEvent me) {
                Object value = list2.getSelectedValue();
                Point p = new Point(me.getX(), me.getY());
                int index = list2.locationToIndex(p);
                if (value != null) {
                    if (index != mHoveredJListIndex) {
                        mHoveredJListIndex = index;
                        list1.repaint();
                        popup.setLocation(list2.getLocationOnScreen().x + list2.getWidth(),
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


