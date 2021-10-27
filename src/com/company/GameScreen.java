package com.company;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    public GameScreen(){

    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(0,0,32,32);


    }


}
