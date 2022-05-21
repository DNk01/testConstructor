package com.example.testconstructor.constructors;

import com.example.testconstructor.Url.Url;
import com.example.testconstructor.Url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UrlServiceTest {

    @Autowired
    private UrlService urlService;

    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        Url url1 = new Url(1L, 1L, "http://constructorfortests.heroku.com/url1");
        Url url2 = new Url(2L, 1L, "url2");

        //createUrl test
        assertThat(urlService.createUrl(url1.getTestId()).getUrlName()).isEqualTo(url1.getUrlName());

    }
}