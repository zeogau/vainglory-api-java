package gg.zeogau.vg.api.model.roster;

import gg.zeogau.vg.api.model.common.IAttribute;

/**
 * Created by zeogau on 3/8/17.
 */
public class RosterAttribute implements IAttribute {
    private RosterStat stats;


    @Override
    public String toString() {
        return "RosterAttribute{" +
                "stats=" + stats +
                '}';
    }

    public RosterStat getStats() {
        return stats;
    }

    public void setStats(RosterStat stats) {
        this.stats = stats;
    }
}
