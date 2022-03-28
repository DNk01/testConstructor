package com.example.testconstructor.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Test createTest(@RequestBody Test test) {
        return testService.createTest(test);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ResponseEntity<Test> findTest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testService.findTestById(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteTest(@PathVariable("id") Long id) {
        testService.deleteTestById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Test> getAllTests() {
        return testService.findAllTests();
    }

    @PutMapping("/{id}")
    public Test updateTest(@PathVariable("id") Long id, String name, int questionsAmount){
        return testService.updateTest(id, name, questionsAmount);
    }


}
