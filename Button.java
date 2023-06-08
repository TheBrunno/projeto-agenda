import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {
    private JButton button = new JButton();

    public Button(String text, int buttonWidth, int buttonHeight){
        this.button.setText(text);
        Dimension dimension = new Dimension(buttonWidth, buttonHeight);
        this.button.setPreferredSize(dimension);
        this.button.setBackground(Color.white);
    }
    public Button(String imageIcon, int imageWidth, int imageHeight, int buttonWidth, int buttonHeight, String n){
        ImageIcon image = new ImageIcon(imageIcon);
        Image scaledImageI = image.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(scaledImageI);
        this.button.setIcon(scaledImage);
        this.button.setBackground(Color.white);
    }

    // getters and setters
    public JButton getButton(){
        return this.button;
    }
    public void setButton(JButton button){
        this.button = button;
    }
}
