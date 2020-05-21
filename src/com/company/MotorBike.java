import java.awt.*;

public class MotorBike extends Vehicle{
    public MotorBike(int x, int y) {
        super(x, y);
        width=15;
        height=10;
        speed=20;
    }

    public void paintMe(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

}
