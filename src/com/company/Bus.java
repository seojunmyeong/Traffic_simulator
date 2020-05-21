import java.awt.*;

public class Bus extends Vehicle{
    public Bus(int x, int y) {
        super(x, y);
        width=60;
        height=20;
        speed=7;
    }

    public void paintMe(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

}
