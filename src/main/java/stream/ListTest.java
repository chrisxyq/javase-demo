package stream;


import entity.FullXSaleYType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        add(list);
        System.out.println(list.size());
        System.out.println(String.format("返现%s%%", "50"));

    }

    @Test
    public void test() {
        System.out.println(BigDecimal.valueOf(30).divide(BigDecimal.valueOf(100), 1, BigDecimal.ROUND_DOWN));
        System.out.println(BigDecimal.valueOf(30.5).divide(BigDecimal.valueOf(100), 1, BigDecimal.ROUND_DOWN));
        System.out.println(directSaleToPercent(BigDecimal.valueOf(7)));
        System.out.println(directSaleToPercent(BigDecimal.valueOf(7.155)));
        System.out.println(directSaleToPercent(BigDecimal.valueOf(0)));
        System.out.println(directSaleToPercent(BigDecimal.valueOf(10)));
        System.out.println(directSaleToPercent(BigDecimal.valueOf(11)));
    }
    @Test
    public void test1() {
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30.1))));
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30))));
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30.15))));
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(30.155))));
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(0))));
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(100), BigDecimal.valueOf(-1))));
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(0), BigDecimal.valueOf(-1))));
        System.out.println(xSaleyTypeToPercent(new FullXSaleYType(BigDecimal.valueOf(150), BigDecimal.valueOf(70))));

    }
    /**
     * 优惠方式=“满X减Y”时 转“返现**%”
     * 去掉BigDecimal类型变量小数点后多余的零
     * @param x_sale_yType
     * @return
     */
    private String xSaleyTypeToPercent(FullXSaleYType x_sale_yType) {
        String percent = "";
        if (x_sale_yType != null) {
            if (x_sale_yType.getX() != null && x_sale_yType.getY() != null && x_sale_yType.getX().compareTo(BigDecimal.ZERO) > 0 && x_sale_yType.getY().compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal minused = x_sale_yType.getY().divide(x_sale_yType.getX(), 3, BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(100));
                percent = minused.stripTrailingZeros().toPlainString();
            }
        }
        return percent;
    }
    /**
     * 优惠方式=“X折” 转“返现**%”
     *
     * @param directSale
     * @return
     */
    private String directSaleToPercent(BigDecimal directSale) {
        String percent = "";
        if (directSale != null) {
            BigDecimal middleNum = BigDecimal.valueOf(10).subtract(directSale).setScale(3, BigDecimal.ROUND_DOWN);
            BigDecimal percentDecimal = middleNum.multiply(BigDecimal.valueOf(10)).setScale(1, BigDecimal.ROUND_DOWN)
                    .stripTrailingZeros();
            if (percentDecimal.compareTo(BigDecimal.ZERO) >= 0 && percentDecimal.compareTo(BigDecimal.valueOf(100)) <= 0) {
                percent = percentDecimal.toPlainString();
            }
        }
        return percent;
    }

    private static void add(List<Integer> list) {
        list.add(1);
    }
}
