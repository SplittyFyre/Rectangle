
public class Main {

	public static void main(String[] args) {
		
		//Rectangle blue = new Rectangle(-7, -3, 9, 5);
		Rectangle blue = new Rectangle(1, -3, 9, 10);
		//Rectangle blue = new Rectangle(-100, -3, 9, 10);
		//Rectangle green = new Rectangle(-1, 0, 6, 4);
		Rectangle green = new Rectangle(-3, -7, 6, 4);
		
		System.out.println(blue);
		System.out.println(green);
		System.out.println();
		System.out.println(Rectangle.intersection(blue, green));

	}

}
