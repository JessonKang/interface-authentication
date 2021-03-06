package auth.util;

import java.util.HashMap;
import java.util.Map;

public class UrlUtil {

    public static class UrlEntity{
        //基础url
        public String baseUrl;
        public Map<String, String> params;
        public String getParam(String key){
            return params.get(key);
        }
    }

    //解析url
    public static UrlEntity parse(String url){
        UrlEntity entity = new UrlEntity();
        if(url == null){
            return entity;
        }
        url = url.trim(); //没看懂
        if(url.equals("")){
            return entity;
        }

        String[] urlParts = url.split("\\?");
        entity.baseUrl = urlParts[0];
        //没有参数
        if(urlParts.length == 1)
            return entity;
        //有参数
        String[] params = urlParts[1].split("&");
        entity.params = new HashMap<>();

        for(String param : params){
            String[] keyValue = param.split("=");
            entity.params.put(keyValue[0],keyValue[1]);
        }
        return entity;
    }

    /*
    * 测试
    * */
    public static void main(String[] args) {
        UrlEntity entity = parse(null);
        System.out.println(entity.baseUrl + "\n" + entity.params);

        entity = parse("http://www.123.com");
        System.out.println(entity.baseUrl + "\n" + entity.params);

        entity = parse("http://www.123.com?id=1");
        System.out.println(entity.baseUrl + "\n" + entity.params);

        entity = parse("http://www.123.com?id=1&name=小明");
        System.out.println(entity.baseUrl + "\n" + entity.params);
    }
}
