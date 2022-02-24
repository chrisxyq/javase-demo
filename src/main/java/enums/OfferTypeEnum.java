package enums;

/**
 * @author yuanqixu
 */

public enum OfferTypeEnum {

    AdvanceRebate(1),
    AfterRebate(2);

    private int value;

    OfferTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static OfferTypeEnum getEnum(int value) {
        for (OfferTypeEnum orderStatus : values()) {
            if (orderStatus.getValue() == value) {
                return orderStatus;
            }
        }
        return null;
    }

}
