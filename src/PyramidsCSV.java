import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class PyramidsCSV implements PyramidsCSVDAO {
    public PyramidsCSV()  throws Exception{
    }

    @Override
    public List<Pyramid> readPyramidsFromCSV(String fileName) throws Exception{
        List<Pyramid> pyramids=new ArrayList<>();
        BufferedReader br= new BufferedReader(new FileReader(fileName));
        String line=br.readLine();
        if(line!=null){
            line=br.readLine();
        }
        while (line != null){
            String[] attributes=line.split(",");
            Pyramid pyr=createPyramids(attributes);
            pyramids.add(pyr);
            line=br.readLine();
        }
        return pyramids;
    }

    @Override
    public Map<String, Integer> getSiteCount(List<Pyramid> list) {
        Map<String, Integer> locCount = new HashMap<>();
        for(Pyramid p: list) {
            // if site exists in hashmap increment by 1
            // else add site to map with initial value of 1
            if(locCount.containsKey(p.getSite())){
                int count = locCount.get(p.getSite());
                locCount.put(p.getSite(), count+1);
            }else {
                locCount.put(p.getSite(), 1);
            }
        }
        return locCount;
    }

    @Override
    public List<Pyramid> sortPyramids(List<Pyramid> list) {
        Collections.sort(list, new PyramidComparator());
        return list;
    }

    public Pyramid createPyramids(String[] metadata){
        String pharoah=metadata[0];
        String modern_name=metadata[2];
        String site=metadata[4];
        double height=0;
        if (metadata[7]!=null&&metadata[7].length()>0)
            height=Double.parseDouble(metadata[7]);

        return new Pyramid(pharoah,modern_name,site,height);
    }


}
