package service;

import data.CourseDAO;
import data.ExamDAO;
import model.Course;
import model.Exam;

import java.util.List;
import java.util.Scanner;

public class ExamService {

    private final ExamDAO examDAO;
    private final CourseDAO courseDAO;
    private final Scanner scanner = new Scanner(System.in);

    public ExamService(CourseDAO courseDAO, CourseDAO courseDAO1){
        this.courseDAO = courseDAO;
        examDAO = new ExamDAO();
    }

    public void outputExam(long id){
        examDAO.getAllExams().forEach(System.out::println);
        System.out.println("What is the ID of the exam?");
        String input = scanner.nextLine();
        if (input != null){
            Exam exam = examDAO.getExamById(id);
            System.out.println(exam);
        }
    }

    public void showAllExams() {
        List<Exam> examList = examDAO.getAllExams();
        for (Exam exam:examList)
            System.out.println(exam);
    }

    public void showExamById() {
        System.out.println("What is the ID of the exam?");
        Long id = scanner.nextLong();
        System.out.println(examDAO.getExamById(id));
    }

    public void showExamByName() {
        System.out.println("What is the name of the exam?");
        String name = scanner.nextLine();
        System.out.println(examDAO.getExamByName(name));
    }
}