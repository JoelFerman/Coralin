package coral.co.coralin;


/**
 * Created by jorgehernandez on 4/11/16.
 */
public class OUT_st_sign_in {

    private int userid;
    private String email;
    private String url_image;
    private String name;
    private String provider;
    private String status;
    private Integer error;
    private String errormessage;

    public OUT_st_sign_in(int userid, String email, String url_image, String name, String provider, String status, Integer error, String errormessage) {
        this.userid = userid;
        this.email = email;
        this.url_image = url_image;
        this.name = name;
        this.provider = provider;
        this.status = status;
        this.error = error;
        this.errormessage = errormessage;
    }

    public OUT_st_sign_in() {
        ws_static_variables var;
        var = new ws_static_variables();
        this.userid = var.getWs_sign_in_okcode_value();
        this.email = var.getEmptystring();
        this.url_image = var.getEmptystring();
        this.name = var.getEmptystring();
        this.provider = var.getEmptystring();
        this.status = var.getEmptystring();
        this.error = var.getWs_sign_in_okcode_value();
        this.errormessage = var.getEmptystring();
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
