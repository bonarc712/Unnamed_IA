package fr.utbm.ia54.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Florian & Alexis
 * A JPanel that manages a moving and rotating ImageIcon.
 */

public class RotateLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	
	private double angle = 0;
	private int centerX;
	private int centerY;
	
	private ImageIcon icon;
	private ImageIcon iconSave;
	private BufferedImage iconBuff;
	
	private String carId;
	
    public RotateLabel(ImageIcon icon, String carId) {
    	
        //super(icon);
    	
    	this.carId = carId;

    	// keep that reference close by
        this.icon=icon;
        // create a save of it in it's original form (lost of data with angles who aren't 0,90,180,270
        this.iconSave = new ImageIcon();
        iconSave.setImage(icon.getImage());
        
        // fasten the computation of re-drawing
        this.iconBuff = new BufferedImage(
        	    icon.getIconWidth(),
        	    icon.getIconHeight(),
        	    BufferedImage.TYPE_INT_RGB);
    	Graphics g = iconBuff.createGraphics();
    	icon.paintIcon(null, g, 0,0);
    	g.dispose();
        	
    	centerX = icon.getIconWidth() / 2;
    	centerY = icon.getIconHeight() / 2;
    }

    @Override
    public void paintComponent(Graphics g) {
        if(this.angle != 0) {
        	if(this.angle == Math.PI*2) {
        		this.angle = 0;
        	}
	    	BufferedImage imgTemp =  new BufferedImage((int) centerX, (int) centerY, BufferedImage.TYPE_INT_RGB);
	    	Graphics g2 = imgTemp.createGraphics();
	    	icon.paintIcon(null, g2, 0,0);
	    	g2.dispose();
        
	    	// rotate the picture of selected angle
        	AffineTransform transform = AffineTransform.getRotateInstance(angle, centerX, centerY);
        	angle=0;
        	AffineTransformOp transformOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        	icon.setImage(transformOp.filter(iconBuff,null));
        	
        	
        }

        
        // Car background and id
    	g.setColor(new Color(0, 0, 0));
        g.drawRect(0, 0, centerX*2-1, centerY*2-1);
        
        g.setColor(new Color(230, 230, 230));        
        g.fillRect(0, 0, centerX*2-1, centerY*2-1);
        
    	g.setColor(new Color(0, 0, 0));
        g.drawRect(0, 0, centerX*2-1, centerY*2-1);

    	g.setColor(new Color(0, 0, 0));
    	g.drawString(carId, 5, centerY*2-5);
    	
        // Car Icon
        g.drawImage(icon.getImage(), centerX, 0, centerX, centerY, null);
    	    	
    	super.paintComponent(g);
    }

	public double getAngle() {
		return this.angle;
	}

	/**
	 *  Return the picture of the desired angle (radians), and repaint the component
	 * @param angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
		this.repaint();
	}
}
