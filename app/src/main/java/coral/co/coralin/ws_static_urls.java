package coral.co.coralin;

/**
 * Created by jorgehernandez on 4/11/16.
 */
public class ws_static_urls {
    private static String ws_sign_in_url = "http://kusuk.in/api/v1/users/sign_in"; // {user: { email: $('#inputEmail').val(), password: $('#inputPassword').val()} }
    private static String ws_courses_info_url ="http://kusuk.in/api/v1/courses/get";//{course_id:8,user_email:"EJEMPLO@EJEMPLO.com", user_token:"1Gqqr3HzNQQB3ybexTfy"}
    private static String ws_sign_up_url = "http://kusuk.in/api/v1/users";//{user: { email: "EJEMPLO@EJEMPLO.com", password: "EJEMPLO@EJEMPLO.com"} }

    public String getWs_sign_in_url() {
        return ws_sign_in_url;
    }

    public String getWs_sign_up_url() {
        return ws_sign_up_url;
    }

    public String getWs_courses_info_url() {
        return ws_courses_info_url;
    }
}
