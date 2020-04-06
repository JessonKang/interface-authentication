package auth;

import auth.inter.ApiAuthencator;

public class Test {
        public static void main(String[] args){
            ApiAuthencator apiAuthencator = new DefaultApiAuthencatorImpl();
            String baseUrl = "www.murre.comfff";
            String appId = "jack";
            String password = "1234";
            long timestamp = System.currentTimeMillis();
            String token = AuthToken.getToken(baseUrl,appId,password,timestamp);
            String finalUrl = baseUrl + "?appId=" + appId + "&token=" + token + "&ts=" + timestamp;
            System.out.println(finalUrl);
            apiAuthencator.auth(finalUrl);
        }
}
