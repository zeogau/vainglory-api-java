package gg.zeogau.vg.api.model.player;

/**
 * Created by zeogau on 3/8/17.
 */
public class PlayerStat {
    private Integer level;
    private Integer lifetimeGold;
    private Integer lossStreak;
    private Integer played;
    private Integer played_ranked;
    private Integer winStreak;
    private Integer wins;
    private Integer xp;


    @Override
    public String toString() {
        return "PlayerStat{" +
                "level=" + level +
                ", lifetimeGold=" + lifetimeGold +
                ", lossStreak=" + lossStreak +
                ", played=" + played +
                ", played_ranked=" + played_ranked +
                ", winStreak=" + winStreak +
                ", wins=" + wins +
                ", xp=" + xp +
                '}';
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLifetimeGold() {
        return lifetimeGold;
    }

    public void setLifetimeGold(Integer lifetimeGold) {
        this.lifetimeGold = lifetimeGold;
    }

    public Integer getLossStreak() {
        return lossStreak;
    }

    public void setLossStreak(Integer lossStreak) {
        this.lossStreak = lossStreak;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getPlayed_ranked() {
        return played_ranked;
    }

    public void setPlayed_ranked(Integer played_ranked) {
        this.played_ranked = played_ranked;
    }

    public Integer getWinStreak() {
        return winStreak;
    }

    public void setWinStreak(Integer winStreak) {
        this.winStreak = winStreak;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }
}
