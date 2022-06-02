package com.example.testconstructor.Url;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }



    public String generateUrl(Long testId){
        return "https://constructorfortests.herokuapp.com/" + testId;
    }

    public Long parseUrl(String url){
        for(int i = 0; i < url.length(); i++){
            if(url.charAt(i) > '0' && url.charAt(i) <='9'){
                return Long.valueOf(url.substring(i));
            }
        }
        return null;
    }

}
