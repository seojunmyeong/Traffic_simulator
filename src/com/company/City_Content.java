import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class City_Content extends JPanel {
    int laneheight =300;
    ArrayList<Vehicle> Vehicle_Container =new ArrayList<Vehicle>();
    ArrayList<Road> Traffic_Container =new ArrayList<Road>();

    public City_Content(){
        setBackground(Color.WHITE);
        setSize( 855, 590);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(350, 0, 50, 600);

        g.setColor(Color.GRAY);
        for(int a = laneheight; a< laneheight *4; a=a+ laneheight) {
            for(int b=0;b<getHeight();b+=40) {
                g.fillRect(375, b, 5, 30);
            }
        }
        g.setColor(Color.BLACK);
        g.fillRect(0, 100, 870, 50);

        g.setColor(Color.GRAY);
        for(int a = laneheight; a< laneheight *4; a=a+ laneheight) {
            for(int b=0;b<getWidth();b+=40) {
                g.fillRect(b, 120, 30, 5);
            }
        }
        g.setColor(Color.BLACK);
        g.fillRect(0, 250, 870, 50);

        g.setColor(Color.GRAY);
        for(int a = laneheight; a< laneheight *4; a=a+ laneheight) {
            for(int b=0;b<getWidth();b+=40) {
                g.fillRect(b, 270, 30, 5);
            }
        }


        g.setColor(Color.BLACK);
        g.fillRect(0, 400, 870, 50);

        g.setColor(Color.GRAY);
        for(int a = laneheight; a< laneheight *4; a=a+ laneheight) {
            for(int b=0;b<getWidth();b+=40) {
                g.fillRect(b, 420, 30, 5);
            }
        }

        g.setColor(Color.BLACK);
        g.fillRect(150, 400, 50, 600);

        g.setColor(Color.GRAY);
        for(int a = laneheight; a< laneheight *4; a=a+ laneheight) {
            for(int b=430;b<getHeight();b+=40) {
                g.fillRect(173, b, 5, 30);
            }
        }



        g.setColor(Color.BLACK);
        g.fillRect(650, 400, 50, 600);

        g.setColor(Color.GRAY);
        for(int a = laneheight; a< laneheight *4; a=a+ laneheight) {
            for(int b=430;b<getHeight();b+=40) {
                g.fillRect(673, b, 5, 30);
            }
        }

        for(int a = 0; a< Vehicle_Container.size(); a++) {
            Vehicle_Container.get(a).paintMe(g);
        }
        for(int a = 0; a< Traffic_Container.size(); a++) {
            Traffic_Container.get(a).paintMe(g);
        }

    }
    public void addVehicle(Vehicle vehicle) {
        Vehicle_Container.add(vehicle);
    }
    public void addRoad(Road Road) {
        Traffic_Container.add(Road);
    }
    public void Move() {
        for(int i = 0; i< Vehicle_Container.size(); i++) {
            Vehicle vehicle= Vehicle_Container.get(i);
            if(vehicle.turn1==true & !vehicle.road.equals("in") ) {
                vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
                vehicle.setPosition(vehicle.getY()+vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());
            }
            else if(vehicle.turn2==true & !vehicle.road.equals("in")){
                vehicle.setY(vehicle.getY()-vehicle.getSpeed());
                vehicle.setPosition(vehicle.getY()-vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());
            }
            else if(vehicle.turn3==true & !vehicle.road.equals("in")){
                vehicle.setX(vehicle.getX()-vehicle.getSpeed());
                vehicle.setPosition(vehicle.getX()-vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());
            }
            else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false & !vehicle.road.equals("in")) {
                vehicle.setX(vehicle.getX()+vehicle.getSpeed());
                vehicle.setPosition(vehicle.getX()+vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());
            }
            else {
                if(vehicle.current==true) {
                    int count=0;
                    if(vehicle.signal.equals("s1")) {count=0;}
                    else if(vehicle.signal.equals("s2")) {count=1;}
                    else if(vehicle.signal.equals("s3")) {count=2;}
                    else if(vehicle.signal.equals("s4")) {count=3;}
                    else if(vehicle.signal.equals("s5")) {count=4;}
                    else if(vehicle.signal.equals("s6")) {count=5;}
                    else if(vehicle.signal.equals("s7")) {count=6;}
                    else if(vehicle.signal.equals("s8")) {count=7;}

                    if(count==0) {
                        Traffic_Container.get(count).setStatus(false, true);
                    }
                    else {
                        Traffic_Container.get(count-1).setStatus(true , false);
                        Traffic_Container.get(count).setStatus(false, true);
                    }
                    if(vehicle.turn1==true) {
                        vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
                        vehicle.setRoad(vehicle.getX(), vehicle.getY());
                    }
                    else if(vehicle.turn2==true){
                        vehicle.setY(vehicle.getY()-vehicle.getSpeed());
                        vehicle.setRoad(vehicle.getX(), vehicle.getY());
                    }
                    else if(vehicle.turn3==true ){
                        vehicle.setX(vehicle.getX()-vehicle.getSpeed());
                        vehicle.setRoad(vehicle.getX(), vehicle.getY());
                    }
                    else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false ) {
                        vehicle.setX(vehicle.getX()+vehicle.getSpeed());
                        vehicle.setRoad(vehicle.getX(), vehicle.getY());
                    }
                }
                else {
                    vehicle.setRoad(vehicle.getX(), vehicle.getY());
                }

            }
        }
    }
}
