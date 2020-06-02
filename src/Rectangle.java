
public class Rectangle {
	
	private int left = 0, bottom = 0;
	private int width = 0, height = 0;
	
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
	
	
	
	/*public static Rectangle intersection(Rectangle a, Rectangle b) {
		
		int ar = a.left + a.width;
		int at = a.bottom + a.height;
		int br = b.left + b.width;
		int bt = b.bottom + b.height;
		
		if (ar <= b.left || at <= b.bottom || br <= a.left || bt <= a.bottom) {
			return new Rectangle(); // no intersect
		}
		
		int newleft = Math.max(a.left, b.left);
		int newbottom = Math.max(a.bottom, b.bottom);
		int width = Math.max(ar, br) - newleft;
		int height = Math.max(at, bt) - newbottom;
		
		return new Rectangle(newleft, newbottom, width, height);
	}*/
	
	public static Rectangle intersection(Rectangle a, Rectangle b) {
		int x1 = a.left; int y1 = a.bottom;
		int x2 = x1 + a.width; int y2 = y1 + a.height;
		int x3 = b.left; int y3 = b.bottom;
		int x4 = x3 + b.width; int y4 = y3 + b.height;
		
		/*if (x1 == x4 || x2 == x3 ||
			y1 == y4 || y2 == y3) {
			// touching
			
		}*/
		
		int x5 = Math.max(x1, x3);
		int y5 = Math.max(y1, y3);
		int x6 = Math.min(x2, x4);
		int y6 = Math.min(y2, y4);
		
		if (x5 > x6 || y5 > y6) {
			return new Rectangle(); // no intersect
		}
		
		return new Rectangle(x5, y5, x6 - x5, y6 - y5);
	}

}
