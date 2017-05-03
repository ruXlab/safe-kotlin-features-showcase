package constants;

import org.json.JSONObject;

/**
 * Created by rux on 03/05/17.
 */
public class JConstants {

    public static void main(String[] args) {
        JUser jUser = new JUser("Mike", "qwerty");
        System.out.println(jUser.toJson());
    }


}


class JUser {
    private final String login;
    private final String password;

    public JUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public JSONObject toJson() {
        return new JSONObject()
            .put(KEY_LOGIN, login)
            .put(KEY_PASSWORD, password);
    }

    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASSWORD = "password";
}

