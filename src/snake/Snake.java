package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements ActionListener,KeyListener {

    public JFrame jFrame;
    public Dimension dim;
    public RenderPanel renderPanel;
    public Timer timer=new Timer(20,this);
    public static Snake snake;
    public Random random;
    public boolean over =false;
    public ArrayList<Point> snakeParts=new ArrayList<Point>();

    public static final int UP=0,DOWN=1,LEFT=2,RIGHT=3,SCALE=10;
    public int ticks=0,direction=DOWN,score,tailLength;
    public Point head,cherry;


    public Snake(){
        dim=Toolkit.getDefaultToolkit().getScreenSize();

        jFrame=new JFrame("Snake Game");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(800,600);
        jFrame.add(renderPanel=new RenderPanel());
        jFrame.addKeyListener(this);
        //System.out.println("Width "+dim.width+"\nHeight "+dim.height);
        //System.out.println("JFrame Width: "+jFrame.getWidth());
        jFrame.setLocation(dim.width / 2 - jFrame.getWidth()/2, dim.height/2-jFrame.getHeight()/2);
        startGame();




    }
    public void startGame(){
        over=false;
        tailLength=5;
        score=0;
        direction=DOWN;
        snakeParts.clear();
        head=new Point(0,-1);
        //snakeParts.add(new Point(head.x,head.y));
        random=new Random();
        cherry=new Point(random.nextInt(jFrame.getWidth()/SCALE),random.nextInt(jFrame.getHeight() / SCALE));
        //System.out.println("Cherry X: "+cherry.x+" Cherry Y: "+cherry.y);

        for (int i=0;i<tailLength;i++){
            snakeParts.add(new Point(head.x,head.y));
        }
        timer.start();
    }
    public static void main(String[] args){
        snake=new Snake();

}   @Override
    public void actionPerformed(ActionEvent e) {

        renderPanel.repaint();
        ticks++;


        if (ticks%5==0&&head!=null&& !over){
            //snakeParts.add(new Point(head.x,head.y));

            //System.out.println("Inside the actionPerformed method, SnakeParts Size: "+snakeParts.size());
            //System.out.println("Added new snake part x: "+head.x+" and y "+head.y);
            snakeParts.add(new Point(head.x,head.y));

            switch (direction){
                case UP:
                    if (head.y-1>=0) {
                        head=new Point(head.x, head.y - 1);
                    }else {
                        over=true;
                    }
                        break;
                case DOWN:
                    if (head.y+1<dim.height/SCALE) {
                        head=new Point(head.x, head.y + 1);
                    }else {
                        over=true;
                    }
                        break;
                case LEFT:
                    if (head.x-1>=0){
                        head=new Point(head.x-1,head.y);
                    }else{
                        over=true;
                    }
                    break;
                case RIGHT:
                    if (head.x+1<dim.width/SCALE) {
                        head=new Point(head.x + 1, head.y);
                    }else {
                        over=true;
                    }
                        break;
            }



            if (snakeParts.size()>tailLength){
                snakeParts.remove(0);
            }

            if (cherry!=null){

                if (head.x==cherry.x&&head.y==cherry.y){
                    score+=10;
                    tailLength++;

                    cherry=new Point(random.nextInt(jFrame.getWidth()/SCALE),random.nextInt(jFrame.getHeight()/SCALE));
                    System.out.println("Cherry X: "+cherry.x+" Cherry Y: "+cherry.y);
                    cherry.setLocation(cherry);
                }
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k=e.getKeyCode();
        switch (k){
            case KeyEvent.VK_UP:
                if (direction!=UP){
                    direction=UP;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction!=LEFT){
                    direction=LEFT;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction!=RIGHT){
                    direction=RIGHT;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction!=DOWN) {
                        direction = DOWN;
                }
                break;

            }
        }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}


