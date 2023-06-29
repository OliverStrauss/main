import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
    Class:      ObstacleGame
    Purpose:    Creates a simple obstacle course for a player to navigate
    Author:     ___________________
    Date:       ___________________
*/


public class Pong extends JPanel implements ActionListener, KeyListener {

    private static Rectangle player = new Rectangle(); //a rectangle that represents the player
    private boolean up, down; //booleans that track which keys are currently pressed
    private Timer timer; //the update timer
    private static int count =0;
    private int sec =0;
   
    private int playerSpeed = 4;

    private static Bumper bump;
    
    static int gameWidth = 500; //the width of the game area
    static int gameHeight = 300;
    private  ball b;
    private static Map m1;
    



    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setTitle("Pong");
        frame.setLayout(new BorderLayout());
        
        Pong Pong1 = new Pong();
        frame.add(Pong1, BorderLayout.CENTER);

       

        Pong1.addKeyListener(Pong1);
        frame.addKeyListener(Pong1);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        Pong1.setUpGame();

        
        
        
    }






 
    public Pong() {
        setPreferredSize(new Dimension(gameWidth, gameHeight));
   }

    public void actionPerformed(ActionEvent e) {
        count++;
    
        update();
        repaint();
       
    }
   
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
      
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
       
    }
    
    //Called every time a key is released
    //Stores the down state for use in the update method
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
    
    }
    static int getCount(){
        return count;
    }
    public void keyTyped(KeyEvent e) {
    }

    
    public void setUpGame() {
    
        if(timer != null) {
            timer.stop();
        }
        
       
        timer = new Timer(1000 / 30, this); //roughly 30 frames per second
        timer.start();
        

      
        
        
        up = down = false;
    
        player = new Rectangle(0, gameHeight/2, 10, 70);

        bump = new Bumper(gameWidth-10,gameHeight/2,10,70);

        b = new ball(gameWidth/2, gameHeight/2);

        m1 = new Map();
        
    


    }
    public static boolean playerRange(int ball){
        
        
        if(ball >=player.y-15 && ball <= player.y+player.height){
            System.out.println("player hit");
            return true;
        }
        else{
            System.out.println("player miss");
            return false;
        }
    }
    public void update() {
        
        if(up) {
            player.y-=playerSpeed;
           
        }
        if(down) {
            player.y+=playerSpeed;
        }
    
        
        if(player.x < 0) {
            player.x = 0;
        }
        else if(player.x + player.width > gameWidth) {
            player.x = gameWidth - player.width;
        }
        
        if(player.y < 0) {
            player.y = 0;
        }
        else if(player.y + player.height > gameHeight) {
            player.y = gameHeight - player.height;
        }
        bump.move();
        b.move();

        
    }
        
        
    

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, gameWidth, gameHeight);


        
    
        
      //  g.setColor(Color.BLACK);
        //g.drawString((String.valueOf(sec)), 200, 200);

        g.setColor(Color.BLACK);
        g.drawRect(player.x,player.y,player.width,player.height);
        g.fillRect(player.x, player.y, player.width, player.height);

       
        
    
        m1.paintComponent(g);
    
    
        b.draw(g);
        
        
        bump.draw(g);

        
       
        
        
    }
}