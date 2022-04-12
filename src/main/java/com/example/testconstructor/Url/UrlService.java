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

    public Url findUrlById(Long id) {
        return urlRepository.findById(id).get();
    }

    public void deleteUrlById(Long id) {
        urlRepository.deleteById(id);
    }

    public List<Url> findAllUrls() {
        return urlRepository.findAll();
    }

    public Url updateUrl(Long id, Long userId, Long testId) {
        Url url = new Url();
        url.setUrlId(id);
        url.setTestId(testId);
        url.setUserId(userId);
        return urlRepository.save(url);
    }

    public User getUserByUrlId(Long urlId) {
        Long userId = urlRepository.getById(urlId).getUserId();
        return userRepository.getById(userId);
    }

    public Test getTestByUrlId(Long urlId) {
        Long testId = urlRepository.getById(urlId).getTestId();
        return testRepository.getById(testId);
    }
}
