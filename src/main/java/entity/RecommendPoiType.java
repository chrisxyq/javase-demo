package entity;

import lombok.Data;

@Data
public class RecommendPoiType {
    private boolean isInHotel;
    private int num;

    public RecommendPoiType() {
    }

    public RecommendPoiType(boolean isInHotel, int num) {
        this.isInHotel = isInHotel;
        this.num = num;
    }

}
