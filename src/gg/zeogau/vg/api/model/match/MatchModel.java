package gg.zeogau.vg.api.model.match;

import gg.zeogau.vg.api.model.common.BaseModel;

/**
 * Created by zeogau on 3/8/17.
 */
public class MatchModel extends BaseModel {

    private MatchAttribute attributes;

    public MatchModel() {
        this.type = "match";
    }

    @Override
    public String toString() {
        return "MatchModel{" +
                "attributes=" + attributes +
                '}';
    }

    public MatchAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(MatchAttribute attributes) {
        this.attributes = attributes;
    }
}
