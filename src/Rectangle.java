import java.awt.Color;

public class Rectangle {
	
	private int left = 0, bottom = 0;
	private int width = 0, height = 0;
	
	public int getLeft() {
		return left;
	}

	public int getBottom() {
		return bottom;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	private Color colour = Color.blue;
	
	public Color getColour() {
		return colour;
	}
	
	public Rectangle setColour(float r, float g, float b, float a) {
		colour = new Color(r, g, b, a);
		return this;
	}

	public Rectangle() {
		// all defaulted to 0
	}
	
	public Rectangle(int l, int b, int w, int h) {
		this.set(l, b, w, h);
	}
	
	public void set(int l, int b, int w, int h) {
		if (w < 0) {
			w = 0;
		}
		if (h < 0) {
			h = 0;
		}
		this.left = l;
		this.bottom = b;
		this.width = w;
		this.height = h;
	}
	
	public int area() {
		return width * height;
	}
	
	public int perimeter() {
		if (width == 0) {
			return height;
		}
		if (height == 0) {
			return width;
		}
		return 2 * (width + height);
	}
	
	
	@Override
	public String toString() {
		return String.format("base: (%d,%d) w:%d h:%d", left, bottom, width, height);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (bottom != other.bottom)
			return false;
		if (height != other.height)
			return false;
		if (left != other.left)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
	public boolean contains(Rectangle other) {
		return other.equals(Rectangle.intersection(this, other));
	}

	public static Rectangle intersection(Rectangle a, Rectangle b) {
		int x1 = a.left; int y1 = a.bottom;
		int x2 = x1 + a.width; int y2 = y1 + a.height;
		int x3 = b.left; int y3 = b.bottom;
		int x4 = x3 + b.width; int y4 = y3 + b.height;
		
		int x5 = Math.max(x1, x3);
		int y5 = Math.max(y1, y3);
		int x6 = Math.min(x2, x4);
		int y6 = Math.min(y2, y4);
		
		if (x5 > x6 || y5 > y6) {
			return new Rectangle(); // no intersect and no touching
		}
		
		return new Rectangle(x5, y5, x6 - x5, y6 - y5);
	}

	// private intersection method which returns null instead of zeroes (more clearer, should be in standard)
	private static Rectangle m_intersection(Rectangle a, Rectangle b) {
		int x1 = a.left; int y1 = a.bottom;
		int x2 = x1 + a.width; int y2 = y1 + a.height;
		int x3 = b.left; int y3 = b.bottom;
		int x4 = x3 + b.width; int y4 = y3 + b.height;
		
		int x5 = Math.max(x1, x3);
		int y5 = Math.max(y1, y3);
		int x6 = Math.min(x2, x4);
		int y6 = Math.min(y2, y4);
		
		if (x5 > x6 || y5 > y6) {
			return null;	 // no intersect and no touching
		}
		
		return new Rectangle(x5, y5, x6 - x5, y6 - y5);
	}
	
	public static int totalPerimeter(Rectangle a, Rectangle b) {
		Rectangle sect = Rectangle.m_intersection(a, b);
		if (sect == null) {
			return a.perimeter() + b.perimeter();
		}
		return a.perimeter() + b.perimeter() - sect.perimeter();
	}
	
}
