package fr.utbm.ia54.utils;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * 
 * @author Florian & Alexis
 * Manages a point which is oriented.
 * the orientation is given in radiant (0 is facing north)
 */
public class OrientedPoint extends Point2D.Double {
	
	private static final long serialVersionUID = 1L;
	public double orientation;
	public double speed;
	public int timeSpentWaiting;
	public int timeSpentCrossing;
	
	public OrientedPoint() {
		this(0);
	}
	
	public OrientedPoint(double angle) {
		super();
		orientation = 0;
	}
	
	public OrientedPoint(int x, int y, double angle) {
		super(x,y);
		orientation = angle;
	}
	
	public OrientedPoint (OrientedPoint p) {
		super(p.x,p.y);
		orientation = p.getOrientation();
	}


	public double getOrientation() {
		return orientation;
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}
	
	public double getAngle() {
		return orientation;
	}

	public void setAngle(double orientation) {
		this.orientation = orientation;
	}
	
	public void addAngle(double angle) {
		this.orientation += angle;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getTimeSpentWaiting() {
		return timeSpentWaiting;
	}

	public void setTimeSpentWaiting(int timeSpentWaiting) {
		this.timeSpentWaiting = timeSpentWaiting;
	}

	public int getTimeSpentCrossing() {
		return timeSpentCrossing;
	}

	public void setTimeSpentCrossing(int timeSpentCrossing) {
		this.timeSpentCrossing = timeSpentCrossing;
	}
}
