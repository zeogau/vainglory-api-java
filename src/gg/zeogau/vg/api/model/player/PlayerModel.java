package gg.zeogau.vg.api.model.player;

import gg.zeogau.vg.api.model.common.BaseModel;

/**
 * Created by zeogau on 3/8/17.
 */
public class PlayerModel extends BaseModel {
    private PlayerAttribute attributes;

    public PlayerModel() {
        this.type = "player";
    }

    @Override
    public String toString() {
        return "PlayerModel{" +
                "attributes=" + attributes +
                '}';
    }

    public PlayerAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(PlayerAttribute attributes) {
        this.attributes = attributes;
    }
}
