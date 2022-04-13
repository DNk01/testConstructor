package com.example.testconstructor.constructors;

import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Statisctics.StatisticService;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.Users.User;
import com.example.testconstructor.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        User u1 = new User(1L, "Dmitry", "Litvinenko");
        User u2 = new User(2l, "Danila", "Kolotilov");

        //createUser test
        assertThat(userService.createUser(u1)).isEqualTo(u1);

        //findUserById test
        assertThat(userService.findUserById(1L)).isEqualTo(u1);

        //findAllUsers test
        userService.createUser(u2);
        assertThat(userService.findAllUsers().size()).isEqualTo(2);

        //deleteUserById test
        userService.deleteUserById(1L);
        assertThat(userService.findAllUsers().size()).isEqualTo(1);

        //updateUser test
        userService.updateUser(2L, "Vasya", "Pupkin");
        assertThat(userService.findUserById(2l).getUserName()).isEqualTo("Vasya");
        assertThat(userService.findUserById(2L).getUserSurname()).isEqualTo("Pupkin");
    }
}