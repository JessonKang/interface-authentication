package auth.inter;

import auth.ApiRequest;

public interface ApiAuthencator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
