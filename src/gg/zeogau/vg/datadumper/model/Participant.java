package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.api.model.participant.ParticipantModel;
import gg.zeogau.vg.api.model.player.PlayerModel;

import javax.persistence.*;

import static com.google.common.base.MoreObjects.firstNonNull;

/**
 * Created by zeogau on 3/9/17.
 */
@NamedQueries({
        @NamedQuery(name="Participant.findAll",
                query="SELECT x FROM Participant x"),
        @NamedQuery(name="Participant.findByVgId",
                query="SELECT x FROM Participant x WHERE x.vgParticipantId = :vgId"),
})

@Entity
@Table(name = "Participant", schema = "rawdata")
public class Participant {
    public final static String FINDALL = "Participant.findAll";
    public final static String FINDBYVGID = "Participant.findByVgId";
    public final static String FINDBYVGID_PARAM = "vgId";


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long participantId;
    @Column
    private String vgParticipantId;
    @Column
    private Byte assists;
    @Column
    private Byte crystalMineCaptures;
    @Column
    private Byte deaths;
    @Column
    private Float farm;
    @Column
    private Short firstAfkTime;
    @Column
    private Byte goldMineCaptures;
    @Column
    private Byte jungleKills;
    @Column
    private Byte karmaLevel;
    @Column
    private Byte kills;
    @Column
    private Byte krakenCaptures;
    @Column
    private Byte level;
    @Column
    private Byte minionKills;
    @Column
    private Byte nonJungleMinionKills;
    @Column
    private Byte skillTier;
    @Column
    private String skin;
    @Column
    private Byte turretCaptures;
    @Column
    private Boolean wentAfk;
    @Column
    private Boolean winner;


    @Column (updatable = false, insertable = false)
    private Long playerId;  //FK
    @Transient
    private String vgPlayerId;

    @Column (updatable = false  , insertable = false)
    private Long rosterId;

    @Column (columnDefinition = "heroId", updatable = false, insertable = false)
    private Short heroId;
    @Column
    private String heroName;

    @ManyToOne (cascade = CascadeType.ALL , targetEntity = Hero.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "heroId")
    private Hero hero;

    @ManyToOne (cascade = CascadeType.ALL , targetEntity = Player.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "playerId")
    private Player player;

    @ManyToOne (cascade = CascadeType.ALL , targetEntity = Roster.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "rosterId")
    private Roster roster;



//    @Column
//    private List<Item> itemUses;


    public static Participant importFromModel (final ParticipantModel model) {
        Participant obj = new Participant();
        obj.updateFromModel(model);
        return obj;
    }

    public void updateFromModel (final ParticipantModel model) {
        Participant obj = this;
        obj.setVgParticipantId(model.getId());


        obj.setKrakenCaptures(firstNonNull (model.getAttributes().getStats().getKrakenCaptures(), 0).byteValue());
        obj.setAssists(model.getAttributes().getStats().getAssists().byteValue());

        obj.setCrystalMineCaptures(firstNonNull(model.getAttributes().getStats().getCrystalMineCaptures(),0).byteValue());
        obj.setDeaths(firstNonNull(model.getAttributes().getStats().getDeaths(),0).byteValue());
        obj.setFarm(firstNonNull(model.getAttributes().getStats().getFarm(),0).floatValue());
        obj.setFirstAfkTime(firstNonNull(model.getAttributes().getStats().getFirstAfkTime(),0).shortValue());
        obj.setGoldMineCaptures(firstNonNull(model.getAttributes().getStats().getGoldMineCaptures(),0).byteValue());

        obj.setJungleKills(firstNonNull(model.getAttributes().getStats().getJungleKills(),0).byteValue());
        obj.setKarmaLevel(firstNonNull(model.getAttributes().getStats().getKarmaLevel(),0).byteValue());
        obj.setKills(firstNonNull(model.getAttributes().getStats().getKills(),0).byteValue());
        obj.setLevel(firstNonNull(model.getAttributes().getStats().getLevel(),0).byteValue());
        obj.setMinionKills(firstNonNull(model.getAttributes().getStats().getMinionKills(),0).byteValue());
        obj.setNonJungleMinionKills(firstNonNull(model.getAttributes().getStats().getNonJungleMinionKills(),0).byteValue());

        obj.setSkillTier(firstNonNull(model.getAttributes().getStats().getSkillTier(),0).byteValue());
        obj.setSkin(model.getAttributes().getStats().getSkinKey());
        obj.setTurretCaptures(firstNonNull(model.getAttributes().getStats().getTurretCaptures(),0)
                .byteValue());

        obj.setWentAfk(model.getAttributes().getStats().getWentAfk());
        obj.setWinner(model.getAttributes().getStats().getWinner());

        obj.setHeroName(model.getAttributes().getActor());

        PlayerModel p = (PlayerModel)model.getRelationships().getPlayer().getData();
        if (p!=null) obj.setVgPlayerId(p.getId());
    }


    public Participant() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        return participantId != null ? participantId.equals(that.participantId) : that.participantId == null;
    }

    @Override
    public int hashCode() {
        return participantId != null ? participantId.hashCode() : 0;
    }


    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getVgParticipantId() {
        return vgParticipantId;
    }

    public void setVgParticipantId(String vgParticipantId) {
        this.vgParticipantId = vgParticipantId;
    }

    public Short getHeroId() {
        return heroId;
    }

    public void setHeroId(Short heroId) {
        this.heroId = heroId;
    }

    public Byte getAssists() {
        return assists;
    }

    public void setAssists(Byte assists) {
        this.assists = assists;
    }

    public Byte getCrystalMineCaptures() {
        return crystalMineCaptures;
    }

    public void setCrystalMineCaptures(Byte crystalMineCaptures) {
        this.crystalMineCaptures = crystalMineCaptures;
    }

    public Byte getDeaths() {
        return deaths;
    }

    public void setDeaths(Byte deaths) {
        this.deaths = deaths;
    }

    public Float getFarm() {
        return farm;
    }

    public void setFarm(Float farm) {
        this.farm = farm;
    }

    public Short getFirstAfkTime() {
        return firstAfkTime;
    }

    public void setFirstAfkTime(Short firstAfkTime) {
        this.firstAfkTime = firstAfkTime;
    }

    public Byte getGoldMineCaptures() {
        return goldMineCaptures;
    }

    public void setGoldMineCaptures(Byte goldMineCaptures) {
        this.goldMineCaptures = goldMineCaptures;
    }

    public Byte getJungleKills() {
        return jungleKills;
    }

    public void setJungleKills(Byte jungleKills) {
        this.jungleKills = jungleKills;
    }

    public Byte getKarmaLevel() {
        return karmaLevel;
    }

    public void setKarmaLevel(Byte karmaLevel) {
        this.karmaLevel = karmaLevel;
    }

    public Byte getKills() {
        return kills;
    }

    public void setKills(Byte kills) {
        this.kills = kills;
    }

    public Byte getKrakenCaptures() {
        return krakenCaptures;
    }

    public void setKrakenCaptures(Byte krakenCaptures) {
        this.krakenCaptures = krakenCaptures;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getMinionKills() {
        return minionKills;
    }

    public void setMinionKills(Byte minionKills) {
        this.minionKills = minionKills;
    }

    public Byte getNonJungleMinionKills() {
        return nonJungleMinionKills;
    }

    public void setNonJungleMinionKills(Byte nonJungleMinionKills) {
        this.nonJungleMinionKills = nonJungleMinionKills;
    }

    public Byte getSkillTier() {
        return skillTier;
    }

    public void setSkillTier(Byte skillTier) {
        this.skillTier = skillTier;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public Byte getTurretCaptures() {
        return turretCaptures;
    }

    public void setTurretCaptures(Byte turretCaptures) {
        this.turretCaptures = turretCaptures;
    }

    public Boolean getWentAfk() {
        return wentAfk;
    }

    public void setWentAfk(Boolean wentAfk) {
        this.wentAfk = wentAfk;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getRosterId() {
        return rosterId;
    }

    public void setRosterId(Long rosterId) {
        this.rosterId = rosterId;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getVgPlayerId() {
        return vgPlayerId;
    }

    public void setVgPlayerId(String vgPlayerId) {
        this.vgPlayerId = vgPlayerId;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }
}
