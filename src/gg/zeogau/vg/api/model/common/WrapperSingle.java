package gg.zeogau.vg.api.model.common;

/**
 * Created by zeogau on 3/8/17.
 */
public class WrapperSingle {
    private BaseModel data;

    @Override
    public String toString() {
        return "WrapperSingle{" +
                "data=" + data +
                '}';
    }

    public BaseModel getData() {
        return data;
    }

    public void setData(BaseModel data) {
        this.data = data;
    }
}
