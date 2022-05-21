package com.example.testconstructor.Url;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url createUrl(Long testId) {
        return urlRepository.save
            (new Url(UUID.randomUUID().getMostSignificantBits(), testId, generateUrl(testId)));
    }

    private String generateUrl(Long testId){
        return "https://constructorfortests.herokuapp.com" + testId;
    }

}
