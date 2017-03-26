package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.api.model.player.PlayerModel;

import javax.persistence.*;

/**
 * Created by zeogau on 3/9/17.
 */
@NamedQueries({
        @NamedQuery(name="Player.findAll",
                query="SELECT x FROM Player x"),
        @NamedQuery(name="Player.findByVgId",
                query="SELECT x FROM Player x WHERE x.vgPlayerId = :vgId"),
})
@Entity
@Table(name = "Player", schema = "rawdata")
public class Player {


    public final static String FINDALL = "Player.findAll";
    public final static String FINDBYVGID = "Player.findByVgId";
    public final static String FINDBYVGID_PARAM = "vgId";


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long playerId;
    @Column
    private String vgPlayerId;
    @Column
    private String ign;
    @Column
    private String shardId;
    @Column
    private Short level;
    @Column
    private Integer lifetimeGold;
    @Column
    private Short lossStreak;
    @Column
    private Short played;
    @Column
    private Short playedRanked;
    @Column
    private Short winStreak;
    @Column
    private Short wins;
    @Column
    private Integer xp;

    public Player() {}


    public static Player importFromModel (final PlayerModel model) {
        Player obj = new Player();
        obj.updateFromModel(model);
        return obj;
    }

    public void updateFromModel (final PlayerModel model) {
        Player obj = this;
        obj.setVgPlayerId(model.getId());
        obj.setShardId(model.getAttributes().getShardId());
        obj.setIgn(model.getAttributes().getName());
        obj.setLevel(model.getAttributes().getStats().getLevel().shortValue());
        obj.setLifetimeGold(model.getAttributes().getStats().getLifetimeGold());

        obj.setLossStreak(model.getAttributes().getStats().getLossStreak().shortValue());
        obj.setPlayed(model.getAttributes().getStats().getPlayed().shortValue());
        obj.setPlayedRanked(model.getAttributes().getStats().getPlayed_ranked().shortValue());
        obj.setWins(model.getAttributes().getStats().getWins().shortValue());
        obj.setWinStreak(model.getAttributes().getStats().getWinStreak().shortValue());

        obj.setXp(model.getAttributes().getStats().getXp());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return playerId != null ? playerId.equals(player.playerId) : player.playerId == null;
    }

    @Override
    public int hashCode() {
        return playerId != null ? playerId.hashCode() : 0;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getVgPlayerId() {
        return vgPlayerId;
    }

    public void setVgPlayerId(String vgPlayerId) {
        this.vgPlayerId = vgPlayerId;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public String getShardId() {
        return shardId;
    }

    public void setShardId(String shardId) {
        this.shardId = shardId;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Integer getLifetimeGold() {
        return lifetimeGold;
    }

    public void setLifetimeGold(Integer lifetimeGold) {
        this.lifetimeGold = lifetimeGold;
    }

    public Short getLossStreak() {
        return lossStreak;
    }

    public void setLossStreak(Short lossStreak) {
        this.lossStreak = lossStreak;
    }

    public Short getPlayed() {
        return played;
    }

    public void setPlayed(Short played) {
        this.played = played;
    }

    public Short getPlayedRanked() {
        return playedRanked;
    }

    public void setPlayedRanked(Short playedRanked) {
        this.playedRanked = playedRanked;
    }

    public Short getWinStreak() {
        return winStreak;
    }

    public void setWinStreak(Short winStreak) {
        this.winStreak = winStreak;
    }

    public Short getWins() {
        return wins;
    }

    public void setWins(Short wins) {
        this.wins = wins;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }
}
