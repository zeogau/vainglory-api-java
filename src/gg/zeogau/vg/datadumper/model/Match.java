package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.api.model.asset.AssetModel;
import gg.zeogau.vg.api.model.common.BaseModel;
import gg.zeogau.vg.api.model.match.MatchModel;
import gg.zeogau.vg.api.model.roster.RosterModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zeogau on 3/9/17.
 */
@NamedQueries({
        @NamedQuery(name="Match.findAll",
                query="SELECT x FROM Match x"),
        @NamedQuery(name="Match.findByVgId",
                query="SELECT x FROM Match x WHERE x.vgMatchId = :vgId"),
})
@Entity
@Table(name="Matches", schema = "rawdata")
public class Match {

    public final static String FINDALL = "Match.findAll";
    public final static String FINDBYVGID = "Match.findByVgId";
    public final static String FINDBYVGID_PARAM = "vgId";


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long matchId;
    @Column
    private String vgMatchId;
    @Column
    private Date createdAt;
    @Column
    private Short duration;
    @Column
    private String gamemode;
    @Column
    private String patchVersion;
    @Column
    private String shardId;
    @Column
    private String endGameReason;

    @Transient
    private List<String> rosterIds = new ArrayList<String>();

    @OneToMany (targetEntity = Roster.class, fetch = FetchType.LAZY, mappedBy = "match")
    private List<Roster> rosters = new ArrayList<Roster>();

    @Transient
    private List<String> assetIds = new ArrayList<String>();

    @OneToMany (targetEntity = Asset.class, fetch = FetchType.LAZY, mappedBy = "match")
    private List<Asset> assets = new ArrayList<Asset>();


    public Match(){}
    public Match(final String vgId) {this.vgMatchId = vgId;}


    public static Match importFromModel (final MatchModel model) {
        Match obj = new Match();
        obj.updateFromModel(model);
        return obj;
    }

    public void updateFromModel (final MatchModel model) {
        Match obj = this;
        obj.setVgMatchId(model.getId());
        obj.setCreatedAt(model.getAttributes().getCreatedAt());
        obj.setDuration(model.getAttributes().getDuration().shortValue());
        obj.setEndGameReason(model.getAttributes().getStats().getEndGameReason());
        obj.setGamemode(model.getAttributes().getGameMode());
        obj.setPatchVersion(model.getAttributes().getPatchVersion());
        obj.setShardId(model.getAttributes().getShardId());

        List<BaseModel> list = model.getRelationships().getRosters().getData();
        for (BaseModel b : list) {
            RosterModel rm = (RosterModel) b;
            obj.rosterIds.add(rm.getId());
        }

        list = model.getRelationships().getAssets().getData();
        for (BaseModel b : list) {
            AssetModel m = (AssetModel) b;
            obj.getAssetIds().add(m.getId());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        return matchId.equals(match.matchId);
    }

    @Override
    public int hashCode() {
        return matchId.hashCode();
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getVgMatchId() {
        return vgMatchId;
    }

    public void setVgMatchId(String vgMatchId) {
        this.vgMatchId = vgMatchId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    public String getGamemode() {
        return gamemode;
    }

    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
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

    public String getEndGameReason() {
        return endGameReason;
    }

    public void setEndGameReason(String endGameReason) {
        this.endGameReason = endGameReason;
    }

    public List<String> getRosterIds() {
        return rosterIds;
    }

    public void setRosterIds(List<String> rosterIds) {
        this.rosterIds = rosterIds;
    }

    public List<Roster> getRosters() {
        return rosters;
    }

    public void setRosters(List<Roster> rosters) {
        this.rosters = rosters;
    }

    public List<String> getAssetIds() {
        return assetIds;
    }

    public void setAssetIds(List<String> assetIds) {
        this.assetIds = assetIds;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
