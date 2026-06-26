package snake;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")

public class RenderPanel  extends JPanel{


    @Override
    protected void paintComponent(Graphics g){
        //System.out.println("The super class paint component method is about to called");
        super.paintComponent(g);
        //System.out.println("Its been called");
        g.setColor(Color.orange);
        //System.out.println("Color has been set orange");
        g.fillRect(0,0,800,600);
        //System.out.println("Filled a rectangle 800 * 600 Then creating a copy of the snake object");



        Snake snake=Snake.snake;
        //System.out.println("Snake object copy created. Next is foreach loop.. ");
        //System.out.println("Snake parts array list size: "+snake.snakeParts.size());


        for (Point point:snake.snakeParts){

            g.setColor(Color.RED);
            //System.out.println("Filling Rect at "+point.x*snake.SCALE+" and "+point.y*snake.SCALE+" with dimens "+snake.SCALE);

            g.fillRect(point.x*snake.SCALE,point.y*snake.SCALE,snake.SCALE,snake.SCALE);

        }
        g.setColor(Color.black);
        g.fillRect(snake.cherry.x*snake.SCALE,snake.cherry.y*snake.SCALE,snake.SCALE,snake.SCALE);
        g.setColor(null);

        //System.out.println(curColor);



    }

}
