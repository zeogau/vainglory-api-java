package gg.zeogau.vg.api.model.participant;

import gg.zeogau.vg.api.model.common.BaseModel;

/**
 * Created by zeogau on 3/8/17.
 */
public class ParticipantModel extends BaseModel {
    private ParticipantAttribute attributes;

    public ParticipantModel() {
        this.type = "participant";
    }

    @Override
    public String toString() {
        return "ParticipantModel{" +
                "attributes=" + attributes +
                '}';
    }

    public ParticipantAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(ParticipantAttribute attributes) {
        this.attributes = attributes;
    }
}
