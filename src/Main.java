import javax.swing.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        PyramidsCSV pD= new PyramidsCSV();
        List<Pyramid> pyramids=pD.readPyramidsFromCSV("C:\\Users\\lenovo\\OneDrive\\Desktop\\ITI\\9. Java & UML programming\\Day 3\\pyramids.csv");
        int i=0;
        for(Pyramid p: pyramids){
            System.out.println("#"+(i++)+p);
        }
        List<Pyramid> sortedPyramids = pD.sortPyramids(pyramids);
        for(Pyramid p: sortedPyramids) {
            System.out.println(p);
        }
        Map<String, Integer> locCount = pD.getSiteCount(pyramids);
        locCount.forEach((k, v) -> System.out.println("key="+ k+ ", value="+ v));
    }
}
