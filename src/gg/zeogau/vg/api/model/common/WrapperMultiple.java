package gg.zeogau.vg.api.model.common;

import com.fasterxml.jackson.databind.deser.Deserializers;

import java.util.List;

/**
 * Created by zeogau on 3/8/17.
 */
public class WrapperMultiple {
    private List<BaseModel> data;

    @Override
    public String toString() {
        return "WrapperMultiple{" +
                "data=" + data +
                '}';
    }

    public List<BaseModel> getData() {
        return data;
    }

    public void setData(List<BaseModel> data) {
        this.data = data;
    }
}
