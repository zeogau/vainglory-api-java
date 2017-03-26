package gg.zeogau.vg.api.model.participant;

import java.util.List;
import java.util.Map;

/**
 * Created by zeogau on 3/7/17.
 */
public class ParticipantStat {
    private Integer assists;
    private Integer crystalMineCaptures;
    private Integer deaths;
    private Double farm;
    private Integer firstAfkTime;
    private Integer goldMineCaptures;
    private Map<String, Integer> itemGrants;
    private Map<String, Integer> itemSells;
    private Map<String, Integer> itemUses;

    private List<String> items;
    private Integer jungleKills;
    private Integer karmaLevel;
    private Integer kills;
    private Integer krakenCaptures;
    private Integer level;      //account level
    private Integer minionKills;
    private Integer nonJungleMinionKills;
    private Integer skillTier;
    private String skinKey;
    private Integer turretCaptures;
    private Boolean wentAfk;
    private Boolean winner;

    @Override
    public String toString() {
        return "ParticipantStat{" +
                "assists=" + assists +
                ", crystalMineCaptures=" + crystalMineCaptures +
                ", deaths=" + deaths +
                ", farm=" + farm +
                ", firstAfkTime=" + firstAfkTime +
                ", goldMineCaptures=" + goldMineCaptures +
                ", itemGrants=" + itemGrants +
                ", itemSells=" + itemSells +
                ", itemUses=" + itemUses +
                ", items=" + items +
                ", jungleKills=" + jungleKills +
                ", karmaLevel=" + karmaLevel +
                ", kills=" + kills +
                ", krakenCaptures=" + krakenCaptures +
                ", level=" + level +
                ", minionKills=" + minionKills +
                ", nonJungleMinionKills=" + nonJungleMinionKills +
                ", skillTier=" + skillTier +
                ", skinKey='" + skinKey + '\'' +
                ", turretCaptures=" + turretCaptures +
                ", wentAfk=" + wentAfk +
                ", winner=" + winner +
                '}';
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getCrystalMineCaptures() {
        return crystalMineCaptures;
    }

    public void setCrystalMineCaptures(Integer crystalMineCaptures) {
        this.crystalMineCaptures = crystalMineCaptures;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Double getFarm() {
        return farm;
    }

    public void setFarm(Double farm) {
        this.farm = farm;
    }

    public Integer getFirstAfkTime() {
        return firstAfkTime;
    }

    public void setFirstAfkTime(Integer firstAfkTime) {
        this.firstAfkTime = firstAfkTime;
    }

    public Integer getGoldMineCaptures() {
        return goldMineCaptures;
    }

    public void setGoldMineCaptures(Integer goldMineCaptures) {
        this.goldMineCaptures = goldMineCaptures;
    }

    public Map<String, Integer> getItemGrants() {
        return itemGrants;
    }

    public void setItemGrants(Map<String, Integer> itemGrants) {
        this.itemGrants = itemGrants;
    }

    public Map<String, Integer> getItemSells() {
        return itemSells;
    }

    public void setItemSells(Map<String, Integer> itemSells) {
        this.itemSells = itemSells;
    }

    public Map<String, Integer> getItemUses() {
        return itemUses;
    }

    public void setItemUses(Map<String, Integer> itemUses) {
        this.itemUses = itemUses;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Integer getJungleKills() {
        return jungleKills;
    }

    public void setJungleKills(Integer jungleKills) {
        this.jungleKills = jungleKills;
    }

    public Integer getKarmaLevel() {
        return karmaLevel;
    }

    public void setKarmaLevel(Integer karmaLevel) {
        this.karmaLevel = karmaLevel;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getKrakenCaptures() {
        return krakenCaptures;
    }

    public void setKrakenCaptures(Integer krakenCaptures) {
        this.krakenCaptures = krakenCaptures;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMinionKills() {
        return minionKills;
    }

    public void setMinionKills(Integer minionKills) {
        this.minionKills = minionKills;
    }

    public Integer getNonJungleMinionKills() {
        return nonJungleMinionKills;
    }

    public void setNonJungleMinionKills(Integer nonJungleMinionKills) {
        this.nonJungleMinionKills = nonJungleMinionKills;
    }

    public Integer getSkillTier() {
        return skillTier;
    }

    public void setSkillTier(Integer skillTier) {
        this.skillTier = skillTier;
    }

    public String getSkinKey() {
        return skinKey;
    }

    public void setSkinKey(String skinKey) {
        this.skinKey = skinKey;
    }

    public Integer getTurretCaptures() {
        return turretCaptures;
    }

    public void setTurretCaptures(Integer turretCaptures) {
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
}
