package bogdan.iacob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.time.LocalTime;

public class SelectionButtons extends JButton implements ActionListener {

    CoffeeMachine coffeeMachine;
    Shape shape;
    private long startBrew = 0;



    SelectionButtons(int x, int y, int width, int height, String name,CoffeeMachine coffeeMachine) {
        super(name);
        this.coffeeMachine = coffeeMachine;
        setBounds(x, y, width, height);
        Dimension size = getPreferredSize();
//        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
        setBackground(Color.BLACK);
        addActionListener(this);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

//    public boolean contains(int x, int y) {
//        if (shape == null ||
//                !shape.getBounds().equals(getBounds())) {
//            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
//        }
//        return shape.contains(x, y);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String tempText = ((SelectionButtons) e.getSource()).getText();
        switch (tempText) {
            case "Espresso":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Espresso");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    startBrew = System.currentTimeMillis();
                    break;
                }
            case "Americano":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Americano");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    break;
                }
            case "Cappuccino":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Cappuccino");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    break;
                }
            case "Latte":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Caffe Latte");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    break;
                }
            case "Hot Choco":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Hot Chocolate");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    break;
                }
            case "Flat White":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Flat White");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    break;
                }
            case "Cortado":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Cortado");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    break;
                }
            case "Hot Water":
                if (!coffeeMachine.selected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.GREEN);
                    System.out.println("Pouring Hot Water");
                    coffeeMachine.selected = true;
                    coffeeMachine.disableButtons(true);
                    coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + tempText + "</html");
                    break;
                }
        }
    }

//    public void brewTime (){
//        long time = System.currentTimeMillis();
//        if(coffeeMachine.selected){
//            long brewDuration = time + 1500;
//
//        }
//    }
}
