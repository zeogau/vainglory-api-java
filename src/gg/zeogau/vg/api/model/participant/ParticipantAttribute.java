package gg.zeogau.vg.api.model.participant;

import gg.zeogau.vg.api.model.common.IAttribute;

/**
 * Created by zeogau on 3/7/17.
 */
public class ParticipantAttribute implements IAttribute {

    private String actor;
    private ParticipantStat stats;


    @Override
    public String toString() {
        return "ParticipantAttribute{" +
                "actor='" + actor + '\'' +
                ", stats=" + stats +
                '}';
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public ParticipantStat getStats() {
        return stats;
    }

    public void setStats(ParticipantStat stats) {
        this.stats = stats;
    }
}
