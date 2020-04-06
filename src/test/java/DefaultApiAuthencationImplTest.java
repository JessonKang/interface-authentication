package java;

import auth.AuthToken;
import auth.DefaultApiAuthencatorImpl;
import auth.inter.ApiAuthencator;
//import org.junit.Test;

public class DefaultApiAuthencationImplTest {
    //@Tes
    public static void main(String[] args){
        ApiAuthencator apiAuthencator = new DefaultApiAuthencatorImpl();
        String baseUrl = "www.murre.com";
        String appId = "jack";
        String password = "123";
        long timestamp = System.currentTimeMillis();
        String token = AuthToken.getToken(baseUrl,appId,password,timestamp);
        String finalUrl = baseUrl + "?appId=" + appId + "&token=" + token + "&ts" + timestamp;
        System.out.println(finalUrl);
        apiAuthencator.auth(finalUrl);
    }
}
