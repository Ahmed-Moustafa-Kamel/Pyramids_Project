import java.util.List;
import java.util.Map;

public interface PyramidsCSVDAO {
    public Pyramid createPyramids(String[] metadata);
    public List<Pyramid> readPyramidsFromCSV(String filename) throws Exception;
    public List<Pyramid> sortPyramids(List<Pyramid> list);
    public Map<String, Integer> getSiteCount(List<Pyramid> list);
}