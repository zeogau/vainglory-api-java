package gg.zeogau.vg.api.model.common;

import gg.zeogau.vg.api.model.common.BaseError;
import gg.zeogau.vg.api.model.common.BaseModel;

import java.util.List;

/**
 * Created by zeogau on 3/7/17.
 */
public class ContainerSingular extends BaseError{
    private BaseModel data;

    private List<BaseModel> included;     //this has mixed types of BaseModel


    @Override
    public String toString() {
        return "Match{" +
                "data=" + data +
                ", included=" + included +
                '}';
    }

    public BaseModel getData() {
        return data;
    }

    public void setData(BaseModel data) {
        this.data = data;
    }

    public List<BaseModel> getIncluded() {
        return included;
    }

    public void setIncluded(List<BaseModel> included) {
        this.included = included;
    }
}
