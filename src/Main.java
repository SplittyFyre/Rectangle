
public class Main {

	public static void main(String[] args) {
		
		Rectangle blue = new Rectangle(10, -30, 90, 100);
		blue.setColour(0, 0, 1, 0.5f);
		Rectangle green = new Rectangle(-90, 0, 600, 40);
		green.setColour(0, 1, 0, 0.5f);
		
		System.out.println(blue);
		System.out.println(green);
		System.out.println(Rectangle.intersection(blue, green));
		System.out.println(Rectangle.totalPerimeter(blue, green));
		
		
		// IMPORTANT:
		// due to Java bugs regarding my window manager (i3-wm),
		// I had to set this value to get the rectangle selecting to work properly
		RectangleDrawer drawer = new RectangleDrawer(600, 600, 20);// <<<<<<-----|
		// you may need to change it (try setting it from 20 to 0) 
		
		drawer.addRectangle(blue);
		drawer.addRectangle(green);
		
		drawer.addRectangle(Rectangle.intersection(blue, green).setColour(1, 0, 0, 0.5f));
		
		drawer.draw();
		
	}
	

}
