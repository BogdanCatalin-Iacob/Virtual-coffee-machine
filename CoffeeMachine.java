package bogdan.iacob;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CoffeeMachine extends JFrame {

    boolean selected = false;
    JLabel brewConfirmation;

    private final JFrame frame;
    private final JLabel liquid;
    private final JPanel liquidPanel;
    private final JLabel coffeeMachine;
    private final ImageIcon icon;
    private final Font font;


    private final String[] buttonText = {"Espresso", "Americano", "Cappuccino", "Latte", "Hot Choco", "Flat White", "Cortado", "Hot Water"};
    private final SelectionButtons[] buttons = new SelectionButtons[buttonText.length];
    private final JLabel[] nameLabels = new JLabel[buttonText.length];

    private final int Y = 253;
    private final int X = 198;
    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    private final double V_SPACE = 49.9;

    CoffeeMachine(String name){
        this.frame = new JFrame(name);
        this.icon = new ImageIcon("Coffee_machine.png");
        this.font = new Font("Arial",Font.PLAIN,9);

        this.coffeeMachine = new JLabel();
        coffeeMachine.setBounds(100, 100, 350, 600);
        coffeeMachine.setIcon(resizeIcon(icon, 350, 600));
        coffeeMachine.setOpaque(true);

        this.liquid = new JLabel("  ");
        liquid.setSize(10,1);
        liquid.setBounds(10,5,5,10);
        liquid.setBackground(Color.YELLOW);
        liquid.setForeground(Color.WHITE);
        liquid.setOpaque(true);

        this.brewConfirmation = new JLabel("Select your favorite drink");
        brewConfirmation.setBounds(190,140,190,50);
        brewConfirmation.setBackground(new Color(40,40,40));
        brewConfirmation.setFont(new Font("Arial", Font.BOLD, 14));
        brewConfirmation.setForeground(Color.WHITE);
        brewConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
        brewConfirmation.setOpaque(true);

        this.liquidPanel = new JPanel();
        liquidPanel.setBounds(242, 488,80,150);
        liquidPanel.setBackground(Color.BLACK);
        liquidPanel.add(liquid);

//        set buttons coordinates
        int tempX = X;
        int tempY = Y;
        for(int i = 0; i < buttonText.length; i++){
            buttons[i] = new SelectionButtons(tempX, tempY, WIDTH, HEIGHT, buttonText[i], this);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setMargin(new Insets(0, 0, 0, 0));
            buttons[i].setBorder(new LineBorder(Color.BLUE, 50));
            frame.add(buttons[i]);
            tempX += V_SPACE;

            if((i + 1) % 4 == 0) {
                tempX = X;
                tempY += 94;
            }
        }

//        set labels coordinates
        int tempZ = X - 10;
        int tempW = Y - 20;
        for(int i = 0; i < buttonText.length; i++){
            nameLabels[i] = new JLabel(buttonText[i]);
            nameLabels[i].setBounds(tempZ, tempW, WIDTH + 30, HEIGHT);
            nameLabels[i].setFont(font);
            nameLabels[i].setVerticalAlignment(SwingConstants.CENTER);
            nameLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            nameLabels[i].setForeground(Color.WHITE);
            nameLabels[i].setBackground(new Color(40, 40, 40));
            nameLabels[i].setOpaque(true);
            frame.add(nameLabels[i]);
            tempZ += V_SPACE;

            if((i + 1) % 4 == 0) {
                tempZ = X -10;
                tempW += 94;
            }
        }
        frame.add(brewConfirmation);
        frame.add(liquidPanel);
        frame.add(coffeeMachine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

//    public void disableButtons(boolean selected){
//        if(selected){
//            for(int i = 0; i < buttons.length; i++){
//                buttons[i].setEnabled(false);
//            }
//        }
//    }
}
