import java.awt.*;

public class Bumper {
    private static Rectangle rect;
 
    
    public Bumper(int x, int y, int w, int h) {
         rect = new Rectangle(x, y, w, h);
    }
    public int getX(int x){
        return x;
    }
    public static int getY(int y){
        return y;
    }
    public int getW(int w){
        return w;
    }
    public int getH(int h){
        return h;
    }
    public Color getColor() {
        return Color.BLACK;
    }
    
    public static Rectangle getRectangle() {
        return rect;
    }

    public static boolean inRange(int ball){
        if(ball <=rect.y && ball >= rect.y-rect.height){
        
            return true;
            
        }
        else{
            return false;
        }
    }



 

    public void move() {
        
        
        
        if(rect.y < ball.getBallY()){
            rect.y = rect.y+2;
            //System.out.println( rect.y);
            if(rect.y > 300-rect.height){
                rect.y = 300-rect.height;
            }
        }

        else if(rect.y > ball.getBallY()){
            rect.y = rect.y-2;
            
          
        }
        
        
        // if(rect.y > screenHeight-rect.height){
        //     up= false;
        // }
        // if(rect.y < screenfloor){
        //     up = true;
        // }
        // if(up){
        // rect.y = rect.y+2;
        
        // }
        // else{
        // rect.y = rect.y-2;
        // }

    }
    
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}