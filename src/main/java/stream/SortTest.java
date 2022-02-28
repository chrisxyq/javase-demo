package stream;

import entity.RecommendPoiType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {
    @Test
    public void test(){
        List<RecommendPoiType> recommendPoiTypes = new ArrayList<>(Arrays.asList(new RecommendPoiType(false, 1),
                new RecommendPoiType(true, 2),
                new RecommendPoiType(true, 3),
                new RecommendPoiType(false, 4)));
        System.out.println(recommendPoiTypes.toString());
        recommendPoiTypes.sort((o1, o2) -> {
            if (o1.isInHotel() ^ o2.isInHotel()) {
                return o1.isInHotel() ? -1 : 1;
            } else {
                return 0;
            }
        });
        System.out.println(recommendPoiTypes.toString());
    }
    @Test
    public void test1(){
        List<RecommendPoiType> recommendPoiTypes = new ArrayList<>(Arrays.asList(new RecommendPoiType(false, 1)));
        System.out.println(recommendPoiTypes.toString());
        recommendPoiTypes.sort((o1, o2) -> {
            if (o1.isInHotel() ^ o2.isInHotel()) {
                return o1.isInHotel() ? -1 : 1;
            } else {
                return 0;
            }
        });
        System.out.println(recommendPoiTypes.toString());
    }
    @Test
    public void test2(){
        double num=1D/0D;
        System.out.println(num);

    }
}
