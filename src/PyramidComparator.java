import java.util.Comparator;

public class PyramidComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid p1, Pyramid p2) {
        if(p1.getHeight() < p2.getHeight()) {
            return 1;
        }else {
            return -1;
        }
    }
}
