package gg.zeogau.vg.api.model.roster;

/**
 * Created by zeogau on 3/8/17.
 */
public class RosterStat {
    private Integer acesEarned;
    private Integer gold;
    private Integer heroKills;
    private Integer krakenCaptures;
    private String side;
    private Integer turretKills;
    private Integer turretsRemaining;

    @Override
    public String toString() {
        return "RosterAttribute{" +
                "acesEarned=" + acesEarned +
                ", gold=" + gold +
                ", heroKills=" + heroKills +
                ", krakenCaptures=" + krakenCaptures +
                ", side='" + side + '\'' +
                ", turretKills=" + turretKills +
                ", turretsRemaining=" + turretsRemaining +
                '}';
    }

    public Integer getAcesEarned() {
        return acesEarned;
    }

    public void setAcesEarned(Integer acesEarned) {
        this.acesEarned = acesEarned;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getHeroKills() {
        return heroKills;
    }

    public void setHeroKills(Integer heroKills) {
        this.heroKills = heroKills;
    }

    public Integer getKrakenCaptures() {
        return krakenCaptures;
    }

    public void setKrakenCaptures(Integer krakenCaptures) {
        this.krakenCaptures = krakenCaptures;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Integer getTurretKills() {
        return turretKills;
    }

    public void setTurretKills(Integer turretKills) {
        this.turretKills = turretKills;
    }

    public Integer getTurretsRemaining() {
        return turretsRemaining;
    }

    public void setTurretsRemaining(Integer turretsRemaining) {
        this.turretsRemaining = turretsRemaining;
    }
}
