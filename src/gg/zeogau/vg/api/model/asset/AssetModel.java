package gg.zeogau.vg.api.model.asset;

import gg.zeogau.vg.api.model.common.BaseModel;

/**
 * Created by zeogau on 3/8/17.
 */
public class AssetModel extends BaseModel{
    private AssetAttribute attributes;

    public AssetModel() {
        this.type = "asset";
    }

    @Override
    public String toString() {
        return "AssetModel{" +
                "attributes=" + attributes +
                '}';
    }

    public AssetAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(AssetAttribute attributes) {
        this.attributes = attributes;
    }
}
