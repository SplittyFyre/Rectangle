import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RectangleDrawer {
	
	@SuppressWarnings("serial")
	class MyFrame extends JComponent implements MouseMotionListener {

		@Override
		public void paint(Graphics g) {
    		for (Rectangle r : rectangles) {
    			g.setColor(r.getColour());
    			g.fillRect(r.getLeft() + (width / 2), r.getBottom() + (height / 2), r.getWidth(), r.getHeight());
    		}
    		g.setColor(Color.black);
    		
    		String str = "none selected";
    		g.setColor(Color.black);
    		if (hoverptr != null) {
    			str = hoverptr.toString();
    			g.setColor(new Color(hoverptr.getColour().getRed() / 2, hoverptr.getColour().getGreen() / 2, hoverptr.getColour().getBlue() / 2, 255));
    		}
    		g.drawString(str, 100, 100);
    	}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
			hoverptr = null;

			int mx = e.getX();
			int my = e.getY();
						
			for (int i = rectangles.size() - 1; i >= 0; i--) {
				Rectangle r = rectangles.get(i);

				int l = r.getLeft() + (width / 2);
				int b = r.getBottom() + (height / 2) + yOffset;
				
				// check mouse-rectangle intersect
			    if (mx >= l && mx <= l + r.getWidth() &&
			    	my >= b && my <= b + r.getHeight())
			    {
			    	hoverptr = r;
			    	break;
			    } 
			    
			}
			repaint();
			revalidate();
		}
	}

	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
	private Rectangle hoverptr = null;
	
	private final int width, height;
	private final int yOffset;
	
	public RectangleDrawer(int width, int height, int yOffset) {
		this.width = width;
		this.height = height;
		this.yOffset = yOffset;
	}

	
	public void addRectangle(Rectangle r) {
		rectangles.add(r);
	}
	
	public void removeRectangle(Rectangle r) {
		rectangles.remove(r);
	}
	
	public void draw() {
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(width, height);
	    MyFrame mf = new MyFrame();
	    mf.setSize(width, height);
	    window.getContentPane().add(mf);
	    window.addMouseMotionListener(mf);
	    window.setVisible(true);
	}
}
