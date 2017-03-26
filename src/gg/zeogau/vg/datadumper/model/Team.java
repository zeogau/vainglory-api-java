package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.api.model.team.TeamModel;

import javax.persistence.*;

/**
 * Created by zeogau on 3/10/17.
 */

@NamedQueries({
        @NamedQuery(name="Team.findAll",
                query="SELECT x FROM Team x"),
        @NamedQuery(name="Team.findByShortName",
                query="SELECT x FROM Team x WHERE x.teamShortName = :name"),
        @NamedQuery(name="Team.findByVgId",
                query="SELECT x FROM Team x WHERE x.vgTeamId = :vgId"),
})
@Entity
@Table(name = "Team", schema = "rawdata")
public class Team {

    public final static String FINDALL = "Team.findAll";
    public final static String FINDBYSHORTNAME = "Team.findByShortName";
    public final static String FINDBYSHORTNAME_PARAM = "name";
    public final static String FINDBYVGID = "Team.findByVgId";
    public final static String FINDBYVGID_PARAM = "vgId";


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long teamId;

    @Column
    private String vgTeamId;

    @Column
    private String teamShortName;
    @Column
    private String shardId;
    @Column
    private String titleId;


    public static Team importFromModel (final TeamModel model) {
        Team obj = new Team();
        obj.updateFromModel(model);
        return obj;
    }

    public void updateFromModel (final TeamModel model) {
        Team obj = this;
        obj.setVgTeamId(model.getId());
        obj.setShardId(model.getAttributes().getShardId());
        obj.setTeamShortName(model.getAttributes().getName());
        obj.setTitleId(model.getAttributes().getTitleId());
    }


    public Team() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!teamId.equals(team.teamId)) return false;
        return vgTeamId.equals(team.vgTeamId);
    }

    @Override
    public int hashCode() {
        int result = teamId.hashCode();
        result = 31 * result + vgTeamId.hashCode();
        return result;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getVgTeamId() {
        return vgTeamId;
    }

    public void setVgTeamId(String vgTeamId) {
        this.vgTeamId = vgTeamId;
    }

    public String getTeamShortName() {
        return teamShortName;
    }

    public void setTeamShortName(String teamShortName) {
        this.teamShortName = teamShortName;
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
}
