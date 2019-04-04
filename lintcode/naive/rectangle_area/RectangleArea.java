package naive.rectangle_area;

/**
 * Implement a Rectangle class which include the following attributes and methods:
 * <p>
 * Two public attributes width and height.
 * A constructor which expects two parameters width and height of type int.
 * A method getArea which would calculate the size of the rectangle and return.
 */
@SuppressWarnings("unused")
public class RectangleArea {
	public int width;
	public int height;
	
	public RectangleArea(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getArea(){
		return width*height;
	}
}
