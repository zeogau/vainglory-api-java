package gg.zeogau.vg.api.model.common;

import gg.zeogau.vg.api.model.common.BaseError;
import gg.zeogau.vg.api.model.common.BaseModel;

import java.util.List;

/**
 * Created by zeogau on 3/8/17.
 */
public class ContainerPlural extends BaseError {
    private List<BaseModel> data;

    private List<BaseModel> included;     //this has mix types of BaseModel



    @Override
    public String toString() {
        return "Matches{" +
                "data=" + data +
                ", included=" + included +
                '}';
    }

    public List<BaseModel> getData() {
        return data;
    }

    public void setData(List<BaseModel> data) {
        this.data = data;
    }

    public List<BaseModel> getIncluded() {
        return included;
    }

    public void setIncluded(List<BaseModel> included) {
        this.included = included;
    }
}
