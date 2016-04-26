package coral.co.coralin;


import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgehernandez on 4/11/16.
 */
public class ws_gucomanager {

    private static String sign_in_url = "";
    private static String sign_up_url = "";
    private static String information_url ="";

    public ws_gucomanager() {
        ws_static_urls urls;
        urls = new ws_static_urls();

        sign_in_url = urls.getWs_sign_in_url();
        sign_up_url = urls.getWs_sign_up_url();
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


            //Log.e("response", "response -----" + responseText);

            try{

                if(responseobject.has(variables.getWs_success_request_variable())) {
                    if (!responseobject.getString(variables.getWs_success_request_variable()).equals(variables.getWs_sign_in_okstatus_value())) {
                        //Log.e("response", "status -----" + variables.getWs_success_request_variable() + " *** success_status_code   " + variables.getWs_sign_in_okstatus_value() );
                        OUT.setStatus(variables.getWs_sign_in_badstatus_value());
                        OUT.setError(variables.getWs_sign_in_errorcode_value());
                        OUT.setErrormessage(responseobject.getString(variables.getWs_error_request_variable()));
                        return OUT;
                    }

                }

            }catch (Exception e){
                e.printStackTrace();
                OUT.setStatus(variables.getWs_sign_in_badstatus_value());
                OUT.setError(variables.getWs_sign_in_errorcode_value());
                OUT.setErrormessage(e.getMessage());

                return OUT;

            }

           // Log.e("response", "response -----" + responseText);

            if(responseobject.has("error")){
                if(responseobject.getString("error").equals("Invalid email or password.")){

                    OUT.setStatus(variables.getWs_sign_in_badstatus_value());
                    OUT.setError(variables.getWs_sign_in_errorcode_value());
                    OUT.setErrormessage(responseobject.getString("error"));

                    return OUT;
                }
            }else{
                if(responseobject.has("status")){
                    if(responseobject.getString("status").equals("ok")){

                        OUT.setStatus(variables.getWs_sign_in_badstatus_value());
                        OUT.setError(variables.getWs_sign_in_errorcode_value());
                        OUT.setErrormessage(responseobject.getString("error"));

                        return OUT;
                    }else{

                    }

                }

            }




            userobject = (JSONObject) responseobject.get(variables.getWs_sign_in_user_variable());

            OUT.setEmail(userobject.getString(variables.getWs_sign_in_email_variable()));
            OUT.setName(userobject.getString(variables.getWs_sign_in_name_variable()));
            OUT.setStatus(responseobject.getString(variables.getWs_sign_in_status_variable()));
            OUT.setProvider(userobject.getString(variables.getWs_sign_in_provider_variable()));
            OUT.setUserid(Integer.parseInt(userobject.getString(variables.getWs_sign_in_id_variable())));
            OUT.setUrl_image(userobject.getString(variables.getWs_sign_in_image_variable()));
            OUT.setUser_token(userobject.getString(variables.getWs_sign_up_authentication_token_variable()));
            OUT.setError(variables.getWs_sign_in_okcode_value());
            OUT.setErrormessage(variables.getEmptystring());


            Log.e("response", "email -----" + OUT.getEmail());
            Log.e("response", "name -----" + OUT.getName());
            Log.e("response", "status -----" + OUT.getStatus());
            Log.e("response", "provider -----" + OUT.getProvider());
            Log.e("response", "id -----" + OUT.getUserid());
            Log.e("response", "image -----" + OUT.getUrl_image());

            Log.e("response", "response -----" + responseText);


        } catch (UnknownHostException e) {
            OUT.setError(variables.getWs_sign_in_errorcode_value());
            OUT.setErrormessage(e.getMessage());
            e.printStackTrace();
            return OUT;

        } catch (Exception e) {
            OUT.setError(variables.getWs_sign_in_errorcode_value());
            OUT.setErrormessage(e.getMessage());
            e.printStackTrace();
            return OUT;
        }




        return OUT;
    }

    //
    public OUT_st_sign_up sing_up_guco(IN_st_sign_up user) {
        //Definition
        OUT_st_sign_up OUT;
        IN_data data;
        IN_state state;
        ws_static_variables variables;
        HttpClient httpclient;
        HttpPost post;
        JSONObject json_user;
        JSONObject json_user_content;
        StringEntity se;

        //Initialization
        OUT = new OUT_st_sign_up();
        state = new IN_state();
        data = new IN_data();


        variables = new ws_static_variables();
        httpclient = new DefaultHttpClient();
        post = new HttpPost(sign_up_url);
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
                OUT.setError(variables.getWs_sign_up_error_request_code());
                OUT.setErrormessage(e.getMessage());

                return OUT;

            }

            //Parsing JSON response
            JSONObject responseobject = new JSONObject(responseText);
            JSONObject userobject = new JSONObject();
            JSONObject stateobject = new JSONObject();

            try{
                if(responseobject.has(variables.getWs_success_request_variable())) {
                    if (!responseobject.getString(variables.getWs_success_request_variable()).equals(variables.getWs_success_status_code())) {

                        OUT.setError(variables.getWs_sign_in_errorcode_value());
                        OUT.setErrormessage(responseobject.getString(variables.getWs_error_request_variable()));
                        return OUT;
                    }
                }

            }catch (Exception e){
                e.printStackTrace();

                OUT.setError(variables.getWs_sign_in_errorcode_value());
                OUT.setErrormessage(e.getMessage());

                return OUT;

            }



            userobject = (JSONObject) responseobject.get(variables.getWs_sign_in_user_variable());

            stateobject = (JSONObject) responseobject.get(variables.getWs_sign_up_state_variable());

            String StateResponseCode =stateobject.getString(variables.getWs_sign_up_code_variable());

            IN_state OUT_state;
            OUT_state = new IN_state();


            if(Integer.parseInt(StateResponseCode) == variables.getWs_sign_up_ok_request_code() ){
                OUT_state.setCode(StateResponseCode);
                List<String> Messagelist;
                Messagelist = new ArrayList<String>();
                Messagelist.add(variables.getWs_sign_up_ok_message());
                OUT_state.setMessages(Messagelist);

                OUT.setState(OUT_state);


                JSONObject dataobject = new JSONObject();
                dataobject = (JSONObject) responseobject.get(variables.getWs_sign_up_data_variable());


                IN_data OUT_data;
                OUT_data = new IN_data();

                OUT_data.setUid(dataobject.getString(variables.getWs_sign_up_uid_variable()));
                OUT_data.setProvider(dataobject.getString(variables.getWs_sign_in_provider_variable()));
                OUT_data.setEmail(dataobject.getString(variables.getWs_sign_up_email_variable()));
                OUT_data.setAuthentication_token(dataobject.getString(variables.getWs_sign_up_authentication_token_variable()));
                OUT_data.setCreated_at(dataobject.getString(variables.getWs_sign_up_created_at_variable()));
                OUT_data.setId(dataobject.getString(variables.getWs_sign_up_id_variable()));
                OUT_data.setImage(dataobject.getString(variables.getWs_sign_up_image_variable()));
                OUT_data.setUpdated_at(dataobject.getString(variables.getWs_sign_up_updated_at_variable()));

                OUT.setData(OUT_data);
                OUT.setError(variables.getWs_sign_up_okcode_value());
                OUT.setErrormessage(variables.getWs_sign_up_ok_message());


                Log.e("response", "code -----" + OUT.getState().getCode());
                Log.e("response", "messages -----" + OUT.getState().getMessages().get(0));
                Log.e("response", "uid -----" + OUT_data.getUid());
                Log.e("response", "email -----" + OUT_data.getEmail());
                Log.e("response", "authientication token -----" + OUT_data.getAuthentication_token());
                Log.e("response", "Created at -----" + OUT_data.getCreated_at());
                Log.e("response", "Updated at -----" + OUT_data.getUpdated_at());
                Log.e("response", "ID -----" + OUT_data.getId());



            }else{
                OUT_state.setCode(StateResponseCode);
                List<String> Messagelist;
                Messagelist = new ArrayList<String>();

                JSONArray jsonArraymessages = stateobject.getJSONArray(variables.getWs_sign_up_messages_variable());

                if (jsonArraymessages != null){
                    for(int i=0;i< jsonArraymessages.length();i++){
                        Messagelist.add(jsonArraymessages.get(i).toString());
                    }
                }

                OUT_state.setMessages(Messagelist);

                OUT.setState(OUT_state);

                IN_data OUT_data;
                OUT_data = new IN_data();
                OUT.setData(OUT_data);
                OUT.setError(Integer.parseInt(StateResponseCode));
                OUT.setErrormessage(Messagelist.get(0));

                Log.e("response", "code -----" + OUT.getState().getCode());
                Log.e("response", "messages -----" + OUT.getState().getMessages().get(0));
                Log.e("response", "uid -----" + OUT_data.getUid());
                Log.e("response", "email -----" + OUT_data.getEmail());
                Log.e("response", "authientication token -----" + OUT_data.getAuthentication_token());
                Log.e("response", "Created at -----" + OUT_data.getCreated_at());
                Log.e("response", "Updated at -----" + OUT_data.getUpdated_at());
                Log.e("response", "ID -----" + OUT_data.getId());



            }


        } catch (UnknownHostException e) {
            OUT.setError(variables.getWs_sign_in_errorcode_value());
            OUT.setErrormessage(e.getMessage());
            e.printStackTrace();
            return OUT;

        } catch (Exception e) {
            OUT.setError(variables.getWs_sign_in_errorcode_value());
            OUT.setErrormessage(e.getMessage());
            e.printStackTrace();
            return OUT;
        }

        return OUT;
    }


}