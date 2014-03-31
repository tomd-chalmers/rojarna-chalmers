package com.rojarna.projektrojarna;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.add(new SquareView());
        frame.setVisible(true);
    }
}
