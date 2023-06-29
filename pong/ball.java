
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class ball implements Runnable {
    int x, xDirection, yDirection;
	static int p1score;
    static int p2score;
    static int y;
    static boolean flip;
    static int bcount;



   static Rectangle ball;
    public ball(int x, int y){
		p1score = p2score = 0;
		this.x = x;
		this.y = y;
		
		//Set ball moving randomly
        
		Random r = new Random();
		int rXDir = r.nextInt(1);
		if (rXDir == 0)
			rXDir--;
		setXDirection(rXDir);
		
		int rYDir = r.nextInt(1);
		if (rYDir == 0)
			rYDir--;
		setYDirection(rYDir);

        ball = new Rectangle(this.x, this.y, 15, 15);
        }
		
	

        public void setXDirection(int xDir){
            xDirection = xDir;
        }
        public void setYDirection(int yDir){
            yDirection = yDir;
        }
    
        public void draw(Graphics g) {
            g.setColor(Color.ORANGE);
            g.fillRect(ball.x, ball.y, ball.width, ball.height);
        }

        public static int getBallY() {
            return ball.y;
        }
        
        public void ballReset(){
           
            

        
            ball.y = 150;
            ball.x =250;
            
            if(flip){
            setXDirection(xDirection);}
            else{
            setXDirection(xDirection*-1);
            }

            if(flip){
            setYDirection(yDirection);}
            else{
            setYDirection(yDirection*-1);
            }

            flip=!flip;
        }
       
      public static void setBCount(){
       bcount= Pong.getCount();
      }


        public static int getP1score() {
            return p1score;
        }



        public static int getP2score() {
            return p2score;
        }



        public void collision(int loc){

            if(ball.x<10 && Pong.playerRange(loc)== true){
                System.out.println("p");
                setXDirection(+1);
            }
             else if(ball.x<0&& Pong.playerRange(loc)== false){
                ballReset();
                p2score++;
             }
            
            
            if(ball.x>475 && Bumper.inRange(loc)){
                setXDirection(-1);
            }
            else if (ball.x> 500&& Bumper.inRange(loc)== false){
                 ballReset();
                 p1score++;
            }


            
        }	

        public void move() {
            //System.out.println(ball.x);
            collision(ball.y);
            ball.x += xDirection;
            ball.x += xDirection;
            ball.y += yDirection;
            ball.y += yDirection;
            //System.out.println(xDirection);
            //bounce the ball when it hits the edge of the screen
            setBCount();
            
            if (ball.y <= 0) {
                setYDirection(+1);
            }
            
            if (ball.y >= 300-15) {
                setYDirection(-1);
            }
        }
    @Override
    public void run() {
		try {
			while(true) {
				move();
				Thread.sleep(8);
			}
		}catch(Exception e) { System.err.println(e.getMessage()); }

	}
        


}