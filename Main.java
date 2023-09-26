import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Object> collectAll(Filter f, Object[] objects) {
        ArrayList<Object> result = new ArrayList<Object>();
        for (Object obj : objects) {
            if (f.accept(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    public static void main(String[] args) {


        Rectangle[] rectangles = {new Rectangle(2, 3), new Rectangle(5, 5), new Rectangle(7, 8), new Rectangle(10, 2)};
        BigRectangleFilter bigRectangleFilter = new BigRectangleFilter();
        ArrayList<Object> bigRectangles = collectAll(bigRectangleFilter, rectangles);
        System.out.println("Big rectangles: " + bigRectangles);
    }
}
