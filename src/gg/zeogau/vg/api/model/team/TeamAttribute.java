package gg.zeogau.vg.api.model.team;

import gg.zeogau.vg.api.model.common.IAttribute;

/**
 * Created by zeogau on 3/8/17.
 */
public class TeamAttribute implements IAttribute {
    private String name;
    private String shardId;
    private String titleId;
    private TeamStat stats;

    @Override
    public String toString() {
        return "TeamAttribute{" +
                "name='" + name + '\'' +
                ", shardId='" + shardId + '\'' +
                ", titleId='" + titleId + '\'' +
                ", stats=" + stats +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShardId() {
        return shardId;
    }

    public void setShardId(String shardId) {
        this.shardId = shardId;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public TeamStat getStats() {
        return stats;
    }

    public void setStats(TeamStat stats) {
        this.stats = stats;
    }
}
