package gg.zeogau.vg.api.model.player;

import gg.zeogau.vg.api.model.common.IAttribute;

import java.util.Date;

/**
 * Created by zeogau on 3/8/17.
 */
public class PlayerAttribute implements IAttribute {
    private String name;        //ign
    private String shardId;
    private PlayerStat stats;
    private String titleId;


    @Override
    public String toString() {
        return "PlayerAttribute{" +
                "name='" + name + '\'' +
                ", shardId='" + shardId + '\'' +
                ", stats=" + stats +
                ", titleId='" + titleId + '\'' +
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

    public PlayerStat getStats() {
        return stats;
    }

    public void setStats(PlayerStat stats) {
        this.stats = stats;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
}
