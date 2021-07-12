package service;

import data.CourseDAO;
import data.ModuleDAO;
import model.Course;
import model.Module;

import java.util.List;
import java.util.Scanner;

public class CourseService {

    private final CourseDAO courseDAO;
    private ModuleDAO moduleDAO;
    private Module module;
    private final Scanner scanner = new Scanner(System.in);
    private SharedServices sharedServices;


    public CourseService(){
        courseDAO = new CourseDAO();
    }

    public void showAllCourses() {
        List<Course> courseList = courseDAO.getAllCourses();
        for (Course course:courseList)
            System.out.println(course);
    }

    public void showCourseById() {
        System.out.println("What is the ID of the course?");
        Long id = scanner.nextLong();
        System.out.println(courseDAO.getCourseById(id));
    }

    public void showCourseByName() {
        System.out.println("What is the name of the course?");
        String name = scanner.nextLine();
        System.out.println(courseDAO.getCourseByName(name));
    }

    public void insertCourse() {
        System.out.println("Insert a name for the course:");
        String name = scanner.nextLine();
        System.out.println("Insert a description for the course (min 2000 chars):");
        String description = scanner.nextLine();
        System.out.println("Insert a code for the course:");
        String code = scanner.nextLine();
        System.out.println("Insert a imageURL for the course:");
        String imageURL = scanner.nextLine();
        System.out.println("Make this course active? (yes/no)");
        boolean activeCourse = false;
        if(scanner.next().equalsIgnoreCase("yes"))
            activeCourse = true;
        else {
            scanner.next();
        }
        System.out.println("Which one of these modules do you want to add to the course list?");
        moduleDAO.getAllModules();
        System.out.println("Insert Id of the module that you want to add to the course.");
        long moduleId;
        List<Module> modules = null;
        moduleId = scanner.nextLong();
        module.equals(moduleDAO.getModuleById(moduleId));
        modules.add(module);
    }

    public void updateCourse() {
        if(courseDAO.getAllCourses() != null) {
            showAllCourses();
            System.out.println("Type in the ID of the course you want to update.");
            long input = sharedServices.rightInput();
            Course course = courseDAO.getCourseById(input);
            boolean keepOnGoing;
            do {
                System.out.println("What do you want to update? \n 1. Change the course name. \n 2. Change the description. \n 3. Change the course code. " +
                        "\n 4. Change the course IMG. \n 5. Change the course activity. \n 6. Change the course modules. \n 0. Return");
                if (input == 1) {
                    course.setName(scanner.nextLine());
                } else if (input == 2) {
                    course.setDescription(scanner.nextLine());
                } else if (input == 3) {
                    course.setCode(scanner.nextLine());
                } else if (input == 4) {
                    course.setImageURL(scanner.nextLine());
                } else if (input == 5) {
                    course.setActive(scanner.nextBoolean());
                } else if (input == 0) {
                    return;
                }
                System.out.println("Do you want to continue updating this person? Yes/No");
                keepOnGoing = sharedServices.yesNo();
            } while (keepOnGoing);
            courseDAO.updateCourse(course);
        } else System.out.println("No persons to update.");
    }

    public void removeCourse() {
        if (courseDAO.getAllCourses() != null) {
            showAllCourses();
            System.out.println("What is the ID of the course you want to remove?");
            Long input = sharedServices.rightInput();
            System.out.println("Are you sure you want to delete " + courseDAO.getCourseById(input) + "? Yes/No");
            boolean areYouSure = sharedServices.yesNo();
            if (areYouSure) {
                courseDAO.deleteCourse(courseDAO.getCourseById(input));
                System.out.println("Course deleted");
            } else
                System.out.println("Course not deleted.");
        } else System.out.println("No courses to delete.");
    }
}