package gg.zeogau.vg.api.model.other;

/**
 * Created by zeogau on 3/7/17.
 */
public class StatusData {
    private String type;
    private String id;
    private StatusAttribute attributes;

    @Override
    public String toString() {
        return "StatusData{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", attributes=" + attributes +
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

    public StatusAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(StatusAttribute attributes) {
        this.attributes = attributes;
    }
}
