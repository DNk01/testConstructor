package com.example.testconstructor.Url;

import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestRepository;
import com.example.testconstructor.Users.User;
import com.example.testconstructor.Users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private UserRepository userRepository;
    private TestRepository testRepository;

    public UrlService(UrlRepository urlRepository, UserRepository userRepository, TestRepository testRepository) {
        this.urlRepository = urlRepository;
        this.userRepository = userRepository;
        this.testRepository = testRepository;
    }

    public Url createUrl(Url url) {
        return urlRepository.save(url);
    }

    public Url findUrlById(Long urlId) {
        return urlRepository.findById(urlId).get();
    }

    public void deleteUrlById(Long urlId) {
        urlRepository.deleteById(urlId);
    }

    public List<Url> findAllUrls() {
        return urlRepository.findAll();
    }

    public Url updateUrl(Long urlId, Long testId, String urlName) {
        Url url = new Url();
        url.setUrlId(urlId);
        url.setTestId(testId);
        url.setUrlName(urlName);
        return urlRepository.save(url);
    }

    public Test getTestByUrlId(Long urlId) {
        Long testId = urlRepository.getById(urlId).getTestId();
        return testRepository.getById(testId);
    }
}
