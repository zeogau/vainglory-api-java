package gg.zeogau.vg.api.model.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gg.zeogau.vg.api.model.asset.AssetModel;
import gg.zeogau.vg.api.model.match.MatchModel;
import gg.zeogau.vg.api.model.participant.ParticipantModel;
import gg.zeogau.vg.api.model.player.PlayerModel;
import gg.zeogau.vg.api.model.roster.RosterModel;
import gg.zeogau.vg.api.model.team.TeamModel;

/**
 * Created by zeogau on 3/8/17.
 */

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "match", value = MatchModel.class),
        @JsonSubTypes.Type(name = "asset", value = AssetModel.class),
        @JsonSubTypes.Type(name = "participant", value = ParticipantModel.class),
        @JsonSubTypes.Type(name = "roster", value = RosterModel.class),
        @JsonSubTypes.Type(name = "team", value = TeamModel.class),
        @JsonSubTypes.Type(name = "player", value = PlayerModel.class)
})
public  abstract class BaseModel {
    protected String type;
    protected String id;
    protected Relationship relationships;


    @Override
    public String toString() {
        return "BaseModel{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", relationships=" + relationships +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Relationship getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationship relationships) {
        this.relationships = relationships;
    }
}
