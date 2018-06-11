package Message_Processing;

import org.springframework.http.HttpHeaders;

public class HTTP_Utilities {

    private static String username = null;
    private static String password = null;
    public static final String uriDetails = "https://hsp-prod.rockshore.net/api/v1/serviceDetails";
    public static final String uriMetrics = "https://hsp-prod.rockshore.net/api/v1/serviceMetrics";

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        HTTP_Utilities.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        HTTP_Utilities.password = password;
    }

    public static HttpHeaders setAuthorizationHeader() {
        return new HttpHeaders()
            {{
                String authHeader = String.format("%s:%s", username, password);
                String Base64AuthHeader = java.util.Base64.getEncoder().encodeToString(authHeader.getBytes());
                set("Authorization", String.format("Basic %s", Base64AuthHeader));
            }};
    }
}
