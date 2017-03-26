package gg.zeogau.vg.api.model.other;

import java.util.Date;

/**
 * Created by zeogau on 3/7/17.
 */
public class StatusAttribute {
    private Date releasedAt;
    private String version;

    @Override
    public String toString() {
        return "StatusAttribute{" +
                "releasedAt=" + releasedAt +
                ", version='" + version + '\'' +
                '}';
    }

    public Date getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Date releasedAt) {
        this.releasedAt = releasedAt;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
