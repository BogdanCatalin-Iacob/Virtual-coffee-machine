package bogdan.iacob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SelectionButtons extends JButton implements ActionListener {

    CoffeeMachine coffeeMachine;
    Shape shape;
    private long startBrew = 0;


    SelectionButtons(int x, int y, int width, int height, String name, CoffeeMachine coffeeMachine) {
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
        do {
            String tempText = ((SelectionButtons) e.getSource()).getText();
            switch (tempText) {
                case "Espresso":
                    activeButton("Espresso");
                    break;

                case "Americano":
                    activeButton("Americano");
                    break;

                case "Cappuccino":
                    activeButton("Cappuccino");
                    break;

                case "Latte":
                    activeButton("Latte");
                    break;

                case "Hot Choco":
                    activeButton("Hot Choco");
                    break;

                case "Flat White":
                    activeButton("Flat White");
                    break;

                case "Cortado":
                    activeButton("Cotado");
                    break;

                case "Hot Water":
                    activeButton("Hot Water");
                    break;
            }
        } while (!coffeeMachine.selected);
    }

    private void activeButton(String brew) {
        setBackground(Color.GREEN);
        setForeground(Color.GREEN);
        coffeeMachine.selected = true;
//        coffeeMachine.disableButtons();
        coffeeMachine.brewConfirmation.setText("<html>Preparing your drink: <br>" + brew + "</html");
        System.out.println("Pouring " + brew);

    }

//    private void pouringBrew() {
//        long startTime = System.currentTimeMillis();
//        long elapsedTime = 0;
//        int y = 0;
//        System.out.println("Pouring");
//        while (elapsedTime < 5000) {
//            elapsedTime = (new Date().getTime() - startTime);
//        }
//        reset();

//    }

//    private void reset() {
////        coffeeMachine.disableButtons(false);
//        setBackground(Color.BLACK);
//        setForeground(Color.BLACK);
//        coffeeMachine.selected = false;
////        coffeeMachine.disableButtons();
//        coffeeMachine.brewConfirmation.setText("Select your favorite drink");
//    }
}