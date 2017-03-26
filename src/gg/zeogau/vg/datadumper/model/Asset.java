package gg.zeogau.vg.datadumper.model;

import gg.zeogau.vg.api.model.asset.AssetModel;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zeogau on 3/15/17.
 */


@NamedQueries({
        @NamedQuery(name="Asset.findAll",
                query="SELECT x FROM Asset x"),
        @NamedQuery(name="Asset.findByVgId",
                query="SELECT x FROM Asset x WHERE x.vgAssetId = :vgId"),
})
@Entity
@Table(name = "Asset", schema = "rawdata")
public class Asset {


    public final static String FINDALL = "Asset.findAll";
    public final static String FINDBYVGID = "Asset.findByVgId";
    public final static String FINDBYVGID_PARAM = "vgId";



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long assetId;
    @Column
    private String vgAssetId;
    @Column
    private String URL;
    @Column
    private String contentType;
    @Column
    private Date createdAt;
    @Column
    private String description;
    @Column
    private String filename;
    @Column
    private String name;

    @Column (updatable = false  , insertable = false)
    private Long matchId;
    @ManyToOne (cascade = CascadeType.ALL , targetEntity = Match.class, fetch = FetchType.EAGER)
    @JoinColumn (name = "matchId")
    private Match match;



    public static Asset importFromModel (final AssetModel model) {
        Asset obj = new Asset();
        obj.updateFromModel(model);
        return obj;
    }

    public void updateFromModel (final AssetModel model) {
        Asset obj = this;
        obj.setVgAssetId(model.getId());
        obj.setContentType(model.getAttributes().getContentType());
        obj.setCreatedAt(model.getAttributes().getCreatedAt());
        obj.setDescription(model.getAttributes().getDescription());
        obj.setFilename(model.getAttributes().getFilename());
        obj.setURL(model.getAttributes().URL);
        obj.setName(model.getAttributes().getName());


    }


    public Asset() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        return assetId != null ? assetId.equals(asset.assetId) : asset.assetId == null;
    }

    @Override
    public int hashCode() {
        return assetId != null ? assetId.hashCode() : 0;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getVgAssetId() {
        return vgAssetId;
    }

    public void setVgAssetId(String vgAssetId) {
        this.vgAssetId = vgAssetId;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
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

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }



}
