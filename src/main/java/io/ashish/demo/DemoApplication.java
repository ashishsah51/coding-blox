package io.ashish.demo;

import io.ashish.demo.config.AppConfig;
import io.ashish.demo.constant.Level;
import io.ashish.demo.dao.ContestDao;
import io.ashish.demo.dao.NotificationDao;
import io.ashish.demo.dao.QuestionDao;
import io.ashish.demo.dao.UserDao;
import io.ashish.demo.entity.Contest;
import io.ashish.demo.entity.Question;
import io.ashish.demo.entity.User;
import io.ashish.demo.service.ContestService;
import io.ashish.demo.service.QuestionService;
import io.ashish.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// www.google.com


@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {
    private final AppConfig config;
    private final UserDao userDao;
    private final UserService userService;
    private final QuestionDao questionDao;
    private final ContestDao contestDao;
    private final ContestService contestService;
    private final QuestionService questionService;
    private final NotificationDao notificationDao;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello..");

        //todo check config
		config.setContestQuestionAssignment(config.getContestQuestionAssignment().RANDOM_QUESTIONS);
		Map<String, BigInteger> scoreConstant = new HashMap<>();
		scoreConstant.put("LOW", BigInteger.valueOf(10));
		scoreConstant.put("MEDIUM", BigInteger.valueOf(20));
		scoreConstant.put("HARD", BigInteger.valueOf(30));
		config.setScoreConstant(scoreConstant);
        System.out.println("config = " + config);
// docker run --rm --name=firefox -p 8080:5800 -v /docker/appdata/firefox:/config:rw jlesage/firefox
        //todo : create user
        final User ashishom = User.builder().username("ashishom").build();
        final User chandan = User.builder().username("chandan").build();
        final User naveen = User.builder().username("naveen").build();
        final User omprakash = User.builder().username("omprakash").build();

        userService.createMultiUsers(Arrays.asList(ashishom, chandan, naveen, omprakash));
        userDao.findAll().forEach(System.out::println);

        //todo : test username field : working
//        final User user2 = User.builder().username("ashishom").build();
//        userService.create(user2);

        //todo : create questions
        final Question question1 = Question.builder().question("que 1").level(Level.LOW).score(BigInteger.valueOf(10)).build();
        final Question question2 = Question.builder().question("que 2").level(Level.LOW).score(BigInteger.valueOf(20)).build();
        final Question question3 = Question.builder().question("que 3").level(Level.MEDIUM).score(BigInteger.valueOf(20)).build();
        final Question question4 = Question.builder().question("que 4").level(Level.MEDIUM).score(BigInteger.valueOf(30)).build();
        final Question question5 = Question.builder().question("que 5").level(Level.HIGH).score(BigInteger.valueOf(40)).build();
        final Question question6 = Question.builder().question("que 6").level(Level.HIGH).score(BigInteger.valueOf(50)).build();
        questionDao.saveAll(Arrays.asList(question1, question2, question3, question4, question5, question6));
        final Question question7 = questionService.createQuestion("que 7", Level.LOW, 10);
        questionDao.findAll().forEach(System.out::println);

        //todo : get all question level wise
        final List<Question> lowLevelQuestions = questionService.getAllQuestionLevelWise(Level.LOW);
        System.out.println("lowLevelQuestions = " + lowLevelQuestions);
        final List<Question> mediumLevel = questionService.getAllQuestionLevelWise(Level.MEDIUM);
        System.out.println("mediumLevel = " + mediumLevel);
        final List<Question> highLevel = questionService.getAllQuestionLevelWise(Level.HIGH);
        System.out.println("highLevel = " + highLevel);

        //todo : create contest
        final Contest contest1 = contestService.createContest("contest 1", Level.LOW, ashishom);
		System.out.println("contest1 = " + contest1);
        final Contest contest2 = contestService.createContest("contest 2", Level.MEDIUM, chandan);
		System.out.println("contest2 = " + contest2);
        contestDao.findAll().forEach(System.out::println);

        //todo : find all contest by level
        final List<Contest> lowContest = contestDao.findAllContestByLevelSQL("LOW");
        lowContest.stream().forEach(i-> System.out.println("contest = " + i));

        //todo : user can register contest
        userService.assignContestToUser(chandan, contest1);
        userService.assignContestToUser(omprakash, contest2);
        userService.assignContestToUser(naveen, contest2);
        userService.assignContestToUser(naveen, contest1);

        //todo : user can solve contest questions
        contestService.runContest(contest1);

        //todo : leader board
        final List<User> leaderBoard = userDao.findLeaderBoard();
        System.out.println("leader board");
        leaderBoard.forEach(System.out::println);

        //todo : contest history
        System.out.println("\ncheck history");
        contestService.contestHistory(contest1).forEach(System.out::println);

        //todo : withdraw contest (not working)
//        contestService.withdrawContest(naveen, contest2);

        // Print notifications
        System.out.println("\nNotifications:");
        notificationDao.findAll().forEach(System.out::println);
    }
}