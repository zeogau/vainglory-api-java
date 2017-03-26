package gg.zeogau.vg.api.model.team;

import gg.zeogau.vg.api.model.common.BaseModel;

/**
 * Created by zeogau on 3/8/17.
 */
public class TeamModel extends BaseModel {
    private TeamAttribute attributes;

    public TeamModel() {
        this.type = "team";
    }


    @Override
    public String toString() {
        return "TeamModel{" +
                "attributes=" + attributes +
                '}';
    }

    public TeamAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(TeamAttribute attributes) {
        this.attributes = attributes;
    }
}
