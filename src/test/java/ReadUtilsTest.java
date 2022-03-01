import com.google.gson.Gson;
import entity.FullXSaleYType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import utils.ReadUtils;

@Slf4j
public class ReadUtilsTest {
    @Test
    public void test() {
        String viewBagPath = "/XSaleYType.json";
        FullXSaleYType xSaleYType = ReadUtils.getObjFromFile(viewBagPath, FullXSaleYType.class);
        log.info("XSaleYType:{}", new Gson().toJson(xSaleYType));
    }
}
