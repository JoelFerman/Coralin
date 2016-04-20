package coral.co.coralin;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/**
 * Created by jorgehernandez on 4/11/16.
 */
public class ws_gucomanager {

    private static String sign_in_url = "";
    private static String information_url ="";

    public ws_gucomanager() {
        ws_static_urls urls;
        urls = new ws_static_urls();

        sign_in_url = urls.getWs_sign_in_url();
        information_url = "";
    }

    public OUT_st_sign_in sing_in_guco(IN_st_sign_in user) {
       //Definition
        OUT_st_sign_in OUT;
        ws_static_variables variables;
        HttpClient httpclient;
        HttpPost post;
        JSONObject json_user;
        JSONObject json_user_content;
        StringEntity se;

        //Initialization
        OUT = new OUT_st_sign_in();
        variables = new ws_static_variables();
        httpclient = new DefaultHttpClient();
        post = new HttpPost(sign_in_url);
        json_user = new JSONObject();
        json_user_content = new JSONObject();


        try {
            //Creating user json object
            json_user_content.put(variables.getWs_sign_in_email_variable(), user.getEmail());
            json_user_content.put(variables.getWs_sign_in_password_variable(), user.getPassword());
            json_user.put(variables.getWs_sign_in_user_variable(), json_user_content);


            //Defining string entity and setting content type
            se = new StringEntity(json_user.toString());
            se.setContentType("application/json;charset=UTF-8");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
            post.setEntity(se);

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(post);
            String responseText = null;
            try {
                //Reading http responsetext
                responseText = org.apache.http.util.EntityUtils.toString(response.getEntity());
            } catch (Exception e) {
                e.printStackTrace();
                OUT.setStatus(variables.getWs_sign_in_badstatus_value());
                OUT.setError(variables.getWs_sign_in_errorcode_value());
                OUT.setErrormessage(e.getMessage());

                return OUT;

            }

            //Parsing JSON response
            JSONObject responseobject = new JSONObject(responseText);
            JSONObject userobject = new JSONObject();
            userobject = (JSONObject) responseobject.get(variables.getWs_sign_in_user_variable());

            OUT.setEmail(userobject.getString(variables.getWs_sign_in_email_variable()));
            OUT.setName(userobject.getString(variables.getWs_sign_in_name_variable()));
            OUT.setStatus(responseobject.getString(variables.getWs_sign_in_status_variable()));
            OUT.setProvider(userobject.getString(variables.getWs_sign_in_provider_variable()));
            OUT.setUserid(Integer.parseInt(userobject.getString(variables.getWs_sign_in_id_variable())));
            OUT.setUrl_image(userobject.getString(variables.getWs_sign_in_image_variable()));
            OUT.setError(variables.getWs_sign_in_okcode_value());
            OUT.setErrormessage(variables.getEmptystring());


            Log.e("response", "email -----" + OUT.getEmail());
            Log.e("response", "name -----" + OUT.getName());
            Log.e("response", "status -----" + OUT.getStatus());
            Log.e("response", "provider -----" + OUT.getProvider());
            Log.e("response", "id -----" + OUT.getUserid());
            Log.e("response", "image -----" + OUT.getUrl_image());

            Log.e("response", "response -----" + responseText);
        } catch (Exception e) {
            OUT.setError(variables.getWs_sign_in_errorcode_value());
            OUT.setErrormessage(e.getMessage());
            e.printStackTrace();
            return OUT;
        }

      return OUT;
    }


}
