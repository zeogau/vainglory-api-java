package gg.zeogau.vg.api.model.roster;

import gg.zeogau.vg.api.model.common.BaseModel;

/**
 * Created by zeogau on 3/8/17.
 */
public class RosterModel extends BaseModel {
    private RosterAttribute attributes;


    public RosterModel() {
        this.type = "roster";
    }

    @Override
    public String toString() {
        return "RosterModel{" +
                "attributes=" + attributes +
                '}';
    }

    public RosterAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(RosterAttribute attributes) {
        this.attributes = attributes;
    }
}
