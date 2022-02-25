package stream;

import entity.FullXSaleYType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuanqixu
 */
public class XSaleyTypeSortTest {
    @Test
    public void test1() {
        System.out.println(xSaleyTypeListToPercent(new ArrayList<>(Arrays.asList(
                new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30.1))))));
        System.out.println(xSaleyTypeListToPercent(new ArrayList<>(Arrays.asList(
                new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30.1)),
                new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(40.1))))));
        System.out.println(xSaleyTypeListToPercent(new ArrayList<>(Arrays.asList(
                new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30.1)),
                new FullXSaleYType(BigDecimal.valueOf(-1), BigDecimal.valueOf(40.1)),
                new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(-1))))));
        List<FullXSaleYType> objects = new ArrayList<>();
        objects.add(null);
        objects.add(new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30.1)));
        objects.add(new FullXSaleYType(BigDecimal.valueOf(-1), BigDecimal.valueOf(40.1)));
        System.out.println(xSaleyTypeListToPercent(objects));

    }

    /**
     * 优惠方式=“满X减Y”时 转“返现**%”
     *
     * @param full_x_sale_y
     * @return
     */
    private String xSaleyTypeListToPercent(List<FullXSaleYType> full_x_sale_y) {
        String percent = "";
        if (full_x_sale_y != null && full_x_sale_y.size() > 0) {
            full_x_sale_y.sort(Comparator.comparing(this::xSaleyTypeToPercentBigDecimal).reversed());
            System.out.println(full_x_sale_y);
            percent = xSaleyTypeToPercent(full_x_sale_y.get(0));
        }
        return percent;
    }

    /**
     * 优惠方式=“满X减Y”时 转“返现**%”
     *
     * @param x_sale_yType
     * @return
     */
    private String xSaleyTypeToPercent(FullXSaleYType x_sale_yType) {
        BigDecimal bigDecimal = xSaleyTypeToPercentBigDecimal(x_sale_yType);
        return bigDecimal != null&&bigDecimal.compareTo(BigDecimal.ZERO)>0 ? bigDecimal.toPlainString() : "";
    }

    private BigDecimal xSaleyTypeToPercentBigDecimal(FullXSaleYType x_sale_yType) {
        BigDecimal percent = BigDecimal.ZERO;
        if (x_sale_yType != null) {
            if (x_sale_yType.getX() != null && x_sale_yType.getY() != null && x_sale_yType.getX().compareTo(BigDecimal.ZERO) > 0 && x_sale_yType.getY().compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal minused = x_sale_yType.getY().divide(x_sale_yType.getX(), 3, BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(100));
                percent = minused.stripTrailingZeros();
            }
        }
        return percent;
    }
}
