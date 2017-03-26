package gg.zeogau.vg.api.model.asset;

import java.util.Date;

/**
 * Created by zeogau on 3/8/17.
 */
public class AssetStat {
    private String dummy;


    @Override
    public String toString() {
        return "AssetStat{" +
                "dummy='" + dummy + '\'' +
                '}';
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }
}
