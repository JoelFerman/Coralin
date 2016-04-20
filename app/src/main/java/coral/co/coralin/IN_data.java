package coral.co.coralin;

/**
 * Created by jorgehernandez on 4/17/16.
 */
public class IN_data {
    private String id;
    private String email;
    private String created_at;
    private String updated_at;
    private String provider;
    private String uid;
    private String image;
    private String authentication_token;


    public IN_data(String id, String email, String created_at, String updated_at, String provider, String uid, String image, String authentication_token) {
        this.id = id;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.provider = provider;
        this.uid = uid;
        this.image = image;
        this.authentication_token = authentication_token;
    }

    public IN_data() {
        this.id = "";
        this.email = "";
        this.created_at = "";
        this.updated_at = "";
        this.provider = "";
        this.uid = "";
        this.image = "";
        this.authentication_token = "";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthentication_token() {
        return authentication_token;
    }

    public void setAuthentication_token(String authentication_token) {
        this.authentication_token = authentication_token;
    }
}
