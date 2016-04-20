package coral.co.coralin;

/**
 * Created by jorgehernandez on 4/12/16.
 */



public class OUT_st_sign_up {
    private IN_state state;
    private IN_data data;
    private Integer error;
    private String errormessage;

    public OUT_st_sign_up(IN_state state, IN_data data, Integer error, String errormessage) {
        this.state = state;
        this.data = data;
        this.error = error;
        this.errormessage = errormessage;
    }

    public OUT_st_sign_up() {
        ws_static_variables var;
        var = new ws_static_variables();
        this.state = new IN_state();
        this.data = new IN_data();
        this.error = var.getWs_sign_up_okcode_value();
        this.errormessage = var.getEmptystring();


    }

    public IN_state getState() {
        return state;
    }

    public void setState(IN_state state) {
        this.state = state;
    }

    public IN_data getData() {
        return data;
    }

    public void setData(IN_data data) {
        this.data = data;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
