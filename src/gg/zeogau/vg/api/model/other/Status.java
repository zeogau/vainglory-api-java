package gg.zeogau.vg.api.model.other;


/**
 * Created by zeogau on 3/6/17.
 */
public class Status {
    private StatusData data;


    @Override
    public String toString() {
        return "Status{" +
                "data=" + data +
                '}';
    }

    public StatusData getData() {
        return data;
    }

    public void setData(StatusData data) {
        this.data = data;
    }
}
