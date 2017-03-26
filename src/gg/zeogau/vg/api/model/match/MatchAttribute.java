package gg.zeogau.vg.api.model.match;

import gg.zeogau.vg.api.model.common.IAttribute;

import java.util.Date;

/**
 * Created by zeogau on 3/7/17.
 */
public class MatchAttribute implements IAttribute {
    private Date createdAt;
    private Integer duration;
    private String gameMode;
    private String patchVersion;
    private String shardId;
    private String titleId;
    private MatchStat stats;


    @Override
    public String toString() {
        return "MatchAttribute{" +
                "createdAt=" + createdAt +
                ", duration=" + duration +
                ", gameMode='" + gameMode + '\'' +
                ", patchVersion='" + patchVersion + '\'' +
                ", shardId='" + shardId + '\'' +
                ", titleId='" + titleId + '\'' +
                ", stats=" + stats +
                '}';
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
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

    public MatchStat getStats() {
        return stats;
    }

    public void setStats(MatchStat stats) {
        this.stats = stats;
    }
}
