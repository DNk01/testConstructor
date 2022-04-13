package com.example.testconstructor.Url;

import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;

@RestController
@RequestMapping("/urls")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public Url createUrl(@RequestBody Url url) {
        return urlService.createUrl(url);
    }

    @GetMapping("{id}")
    ResponseEntity<Url> findUrl(@PathVariable("id") Long id) {
        return ResponseEntity.ok(urlService.findUrlById(id));
    }

    @DeleteMapping("{id}")
    public void deleteUrl(@PathVariable("id") Long id) {
        urlService.deleteUrlById(id);
    }

    @GetMapping
    List<Url> getAllUrl() {
        return urlService.findAllUrls();
    }

    @PutMapping("/{id}")
    public Url updateUrl(@PathVariable("id") Long urlId, Long testId, Long userId) {
        return urlService.updateUrl(urlId, testId, userId);
    }

    @GetMapping("{id}/user")
    public User getUserByUrlId(@PathVariable("id") Long id) {
        return urlService.getUserByUrlId(id);
    }

    @GetMapping("{id}/test")
    public Test getTestByUrlId(@PathVariable("id") Long id) {
        return urlService.getTestByUrlId(id);
    }

}