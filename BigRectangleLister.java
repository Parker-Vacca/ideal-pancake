import java.awt.*;
import java.util.ArrayList;

public class BigRectangleLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(5, 5));
        rectangles.add(new Rectangle(6, 6));
        rectangles.add(new Rectangle(7, 7));
        rectangles.add(new Rectangle(8, 8));
        rectangles.add(new Rectangle(9, 9));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(4, 4));
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(0, 0));

        Object[] bigRectangles = collectAll(rectangles.toArray(), new BigRectangleFilter());
        System.out.println("Big rectangles:");
        for (Object o : bigRectangles) {
            System.out.println(o);
        }
    }

    public static Object[] collectAll(Object[] objects, Filter f) {
        ArrayList<Object> result = new ArrayList<>();
        for (Object o : objects) {
            if (f.accept(o)) {
                result.add(o);
            }
        }
        return result.toArray();
    }

}