package com.example.testconstructor.constructors;

import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestServiceTest{

    @Autowired
    private TestService testService;

    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        Test test = new Test(1L, "name");
        Test test2 = new Test(2L, "name");
        Test test3 = new Test(3L, "name");

        //createTest test
        assertThat(testService.createTest(test)).isEqualTo(test);

        //findTestById test
        assertThat(testService.findTestById(1L)).isEqualTo(test);

        //findAllTests test
        testService.createTest(test2);
        testService.createTest(test3);
        assertThat(testService.findAllTests().size()).isEqualTo(3);

        //deleteTestById test
        testService.deleteTestById(1L);
        assertThat(testService.findAllTests().size()).isEqualTo(2);
    }
}