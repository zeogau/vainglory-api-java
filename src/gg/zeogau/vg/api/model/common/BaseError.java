package gg.zeogau.vg.api.model.common;

import java.util.List;
import java.util.Map;

/**
 * Created by zeogau on 3/8/17.
 */
public abstract class BaseError {
    protected List<Map<String, String>> errors;


    @Override
    public String toString() {
        return "BaseError{" +
                "errors=" + errors +
                '}';
    }

    public List<Map<String, String>> getErrors() {
        return errors;
    }

    public void setErrors(List<Map<String, String>> errors) {
        this.errors = errors;
    }
}
