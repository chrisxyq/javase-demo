package entity;

import lombok.Data;

import java.util.List;

/**
 * @author yuanqixu
 */
@Data
public class MemberCard {
    private String        levelName;
    private List<Integer> applyLevelList;

    public MemberCard(String levelName, List<Integer> applyLevelList) {
        this.levelName = levelName;
        this.applyLevelList = applyLevelList;
    }
}
