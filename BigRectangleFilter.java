import java.awt.*;

public class BigRectangleFilter implements Filter {
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle r = (Rectangle) x;
            return 2 * (r.getWidth() + r.getHeight()) > 10;
        }
        return false;
    }
}