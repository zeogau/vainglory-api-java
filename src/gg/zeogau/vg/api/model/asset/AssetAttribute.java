package gg.zeogau.vg.api.model.asset;

import gg.zeogau.vg.api.model.common.IAttribute;

import java.util.Date;

/**
 * Created by zeogau on 3/8/17.
 */
public class AssetAttribute implements IAttribute {

    private AssetStat stats;

    private String contentType;
    private Date createdAt;
    private String description;
    private String filename;
    private String name;
    public String URL;


    @Override
    public String toString() {
        return "AssetAttribute{" +
                "stats=" + stats +
                ", URL='" + URL + '\'' +
                ", contentType='" + contentType + '\'' +
                ", createdAt=" + createdAt +
                ", description='" + description + '\'' +
                ", filename='" + filename + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public AssetStat getStats() {
        return stats;
    }

    public void setStats(AssetStat stats) {
        this.stats = stats;
    }


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
