package auth;

import auth.inter.ApiAuthencator;
import auth.inter.CredentialStorage;

public class DefaultApiAuthencatorImpl implements ApiAuthencator {
    private CredentialStorage credentialStorage;

    public DefaultApiAuthencatorImpl(){
        this.credentialStorage = new MemoryCredentialStorage();
    }

    public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage){
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String baseUrl = apiRequest.getBaseUrl();

        AuthToken clienAuthToken = new AuthToken(token,timestamp);
        if(clienAuthToken.isExpired()){
            System.out.println("Token is expired.");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.generate(baseUrl,appId,password,timestamp);

        if(!serverAuthToken.match(clienAuthToken)){
            System.out.println("Token verfication failed.");
        }else{
            System.out.println("verification success! welecom to here, " + apiRequest.getAppId());
        }
    }
}
