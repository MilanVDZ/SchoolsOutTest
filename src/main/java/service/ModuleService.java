package service;

import data.CourseDAO;
import data.ExamDAO;
import data.ModuleDAO;
import model.Course;
import model.Exam;
import model.Module;

import java.util.List;
import java.util.Scanner;

public class ModuleService {

    private ModuleDAO moduleDAO;
    private ExamDAO examDAO;
    private CourseDAO courseDAO;

    private Module module;
    private Exam exam;
    private final Scanner scanner = new Scanner(System.in);


    public ModuleService(){
        moduleDAO = new ModuleDAO();
    }

    public void showAllModules() {
        List<Module> moduleList = moduleDAO.getAllModules();
        for (Module module: moduleList)
            System.out.println(module);
    }

    public void showModuleById() {
        System.out.println("What is the ID of the module?");
        Long id = scanner.nextLong();
        System.out.println(moduleDAO.getModuleById(id));
    }

    public void showModuleByName() {
        System.out.println("What is the name of the module?");
        String name = scanner.nextLine();
        System.out.println(moduleDAO.getModuleByName(name));
    }

    public void showModulesByCourse() {
        System.out.println("What is the name of the course?");
        courseDAO.getAllCourses();
        String name = scanner.nextLine();
        Course course = courseDAO.getCourseByName(name);
        System.out.println(moduleDAO.getModulesByCourse(course));
    }
}