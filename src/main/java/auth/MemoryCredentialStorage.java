package auth;

import auth.inter.CredentialStorage;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* 在内存中存储id 和 password的对应关系
*
* */
public class MemoryCredentialStorage implements CredentialStorage {
    Map<String,String> IdPasswordMap = new LinkedHashMap();
    public MemoryCredentialStorage(){
        IdPasswordMap.put("jack","1234");
        IdPasswordMap.put("lucy","1234");
        IdPasswordMap.put("marry","1234");
        IdPasswordMap.put("rose","1234");
        IdPasswordMap.put("tom","1234");
        IdPasswordMap.put("alex","1234");
    }

    @Override
    public String getPasswordByAppId(String appId) {
        return IdPasswordMap.get(appId);
    }
}
