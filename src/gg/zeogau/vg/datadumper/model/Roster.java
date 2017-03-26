package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.api.model.common.BaseModel;
import gg.zeogau.vg.api.model.participant.ParticipantModel;
import gg.zeogau.vg.api.model.roster.RosterModel;
import gg.zeogau.vg.api.model.team.TeamModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeogau on 3/9/17.
 */
@NamedQueries({
        @NamedQuery(name="Roster.findAll",
                query="SELECT x FROM Roster x"),
        @NamedQuery(name="Roster.findByVgId",
                query="SELECT x FROM Roster x WHERE x.vgRosterId = :vgId"),
})
@Entity
@Table(name = "Roster", schema = "rawdata")
public class Roster {

    public final static String FINDALL = "Roster.findAll";
    public final static String FINDBYVGID = "Roster.findByVgId";
    public final static String FINDBYVGID_PARAM = "vgId";


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long rosterId;

    @Column
    private String vgRosterId;
    @Column
    private Short acesEarned;
    @Column
    private Integer gold;
    @Column
    private Byte heroKills;
    @Column
    private Byte krakenCaptures;
    @Column
    private String side;
    @Column
    private Byte turretKills;
    @Column
    private Byte turretsRemaining;
    @Column (updatable = false  , insertable = false)
    private Long matchId;
    @Column (updatable = false  , insertable = false)
    private Long teamId;

    @Transient
    private String vgTeamId;

    @ManyToOne (cascade = CascadeType.ALL , targetEntity = Match.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "matchId")
    private Match match;

    @ManyToOne (cascade = CascadeType.ALL , targetEntity = Team.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "teamId")
    private Team team;

    @Transient
    private List<String> participantIds = new ArrayList<String>();



    @OneToMany (targetEntity = Participant.class, fetch = FetchType.LAZY, mappedBy = "roster")
    private List<Participant> participants = new ArrayList<Participant>();



    public static Roster importFromModel (final RosterModel model) {
        Roster obj = new Roster();
        obj.updateFromModel(model);
        return obj;
    }

    public void updateFromModel (final RosterModel model) {
        Roster obj = this;
        obj.setVgRosterId(model.getId());
        obj.setAcesEarned(model.getAttributes().getStats().getAcesEarned().shortValue());
        obj.setGold(model.getAttributes().getStats().getGold());
        obj.setHeroKills(model.getAttributes().getStats().getHeroKills().byteValue());
        obj.setKrakenCaptures(model.getAttributes().getStats().getKrakenCaptures().byteValue());

        obj.setSide(model.getAttributes().getStats().getSide());
        obj.setTurretKills(model.getAttributes().getStats().getTurretKills().byteValue());
        obj.setTurretsRemaining(model.getAttributes().getStats().getTurretsRemaining().byteValue());

        List<BaseModel> list = model.getRelationships().getParticipants().getData();
        for (BaseModel b : list) {
            ParticipantModel pm = (ParticipantModel) b;
            obj.getParticipantIds().add(pm.getId());
        }

        TeamModel t = (TeamModel)model.getRelationships().getTeam().getData();
        if (t!=null) obj.setVgTeamId(t.getId());
    }

    public Roster(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roster roster = (Roster) o;

        return rosterId != null ? rosterId.equals(roster.rosterId) : roster.rosterId == null;
    }

    @Override
    public int hashCode() {
        return rosterId != null ? rosterId.hashCode() : 0;
    }

    public Long getRosterId() {
        return rosterId;
    }

    public void setRosterId(Long rosterId) {
        this.rosterId = rosterId;
    }

    public String getVgRosterId() {
        return vgRosterId;
    }

    public void setVgRosterId(String vgRosterId) {
        this.vgRosterId = vgRosterId;
    }

    public Short getAcesEarned() {
        return acesEarned;
    }

    public void setAcesEarned(Short acesEarned) {
        this.acesEarned = acesEarned;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Byte getHeroKills() {
        return heroKills;
    }

    public void setHeroKills(Byte heroKills) {
        this.heroKills = heroKills;
    }

    public Byte getKrakenCaptures() {
        return krakenCaptures;
    }

    public void setKrakenCaptures(Byte krakenCaptures) {
        this.krakenCaptures = krakenCaptures;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Byte getTurretKills() {
        return turretKills;
    }

    public void setTurretKills(Byte turretKills) {
        this.turretKills = turretKills;
    }

    public Byte getTurretsRemaining() {
        return turretsRemaining;
    }

    public void setTurretsRemaining(Byte turretsRemaining) {
        this.turretsRemaining = turretsRemaining;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public List<String> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<String> participantIds) {
        this.participantIds = participantIds;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getVgTeamId() {
        return vgTeamId;
    }

    public void setVgTeamId(String vgTeamId) {
        this.vgTeamId = vgTeamId;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
