package coral.co.coralin;

/**
 * Created by jorgehernandez on 4/12/16.
 */
public class IN_st_sign_up {
    private String email;
    private String password;

    public IN_st_sign_up(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public IN_st_sign_up() {
        ws_static_variables var;
        var = new ws_static_variables();
        this.email = var.getEmptystring();
        this.password = var.getEmptystring();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
