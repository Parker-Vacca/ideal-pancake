public class ShortWordFilter implements Filter {
    public boolean accept(Object x) {
        return x instanceof String && ((String) x).length() < 5;
    }
}
