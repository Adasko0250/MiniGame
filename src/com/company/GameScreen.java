package com.company;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    public GameScreen(){

    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(175,175,50,50);
        g.fillRect(15,15,50,50);


    }


}
