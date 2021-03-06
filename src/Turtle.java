import java.awt.Color;

public class Turtle {
    private double x, y;     // turtle is at (x, y)
    private double angle;    // facing this many degrees counterclockwise from the x-axis

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        angle = a0;
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(double delta) {
        angle += delta;
    }

    // move forward the given amount, with the pen down
    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    // pause t milliseconds
    public void pause(int t) {
        StdDraw.show(t);
    }


    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }

    private static void sierpinski(int lvl, double d, Turtle turtle) {
    	
    	if (lvl <= 0) {
    		turtle.goForward(d);
            turtle.turnLeft(120.0);
            turtle.goForward(d);
            turtle.turnLeft(120.0);
            turtle.goForward(d);
            turtle.turnLeft(120.0);
		}
    	else {
    		sierpinski((lvl - 1), d/2, turtle);
    		turtle.turnLeft(60);
    		turtle.goForward(d/2);
    		turtle.turnLeft(-60);
    		sierpinski((lvl - 1), d/2, turtle);
    		turtle.turnLeft(-60);
    		turtle.goForward(d/2);
    		turtle.turnLeft(60);
    		sierpinski((lvl - 1), d/2, turtle);
    		turtle.goForward(-d/2);
		}	
	}
    
    public static void main(String[] args) {
    	
    	double x0 = 0;
        double y0 = 0;
        double a0 = 0;
    	
		Turtle turtle  = new Turtle(x0, y0, a0);
    	
    	int lvl = 5;
    	double d = 1;
    	sierpinski(lvl, d, turtle);

    }

}

