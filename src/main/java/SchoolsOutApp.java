import model.Course;
import model.Person;
import service.CourseService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class SchoolsOutApp {
    private static int choiceOne= 9;
    private static int choiceTwo= 9;
    private static boolean continueThis= true;

    public static void main(String[] args) {
        try {
            while (continueThis){
                getChoice();
                choices();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getChoice(){
        Scanner scanner = new Scanner(System.in);
        while (choiceOne==9) {
            System.out.println("What do you want to look at? \n1. User \n2. Person \n3. Course \n4. Module \n5. Exam \n6. Grade \n0. End");
            choiceOne = scanner.nextInt();
            if(choiceOne==0)break;
            if(choiceOne<1||choiceOne>3){
                choiceOne = 9;
                System.out.println("Invalid choice.");
            }else {
                while (choiceTwo==9) {
                    System.out.println("What do you want to look at? \n1: See All \n2: See One \n3: Add One \n4: Edit One \n5: Delete One\n0: End");
                    choiceTwo = scanner.nextInt();
                    if (choiceTwo==0)break;
                    if(choiceTwo<1||choiceTwo>5){
                        choiceTwo = 9;
                        System.out.println("Invalid choice.");
                    }
                }
            }
        }

    }

    private static void choices() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        CourseService courseService = new CourseService();
        if (choiceTwo!=0)
            if (choiceOne==3){
                switch (choiceTwo){
                    case 1:courseService.showAllCourses();break;
                    case 2:courseService.showCourseById();break;
                    case 3:courseService.insertCourse();break;
                    case 4:courseService.updateCourse();break;
                    case 5:courseService.removeCourse();break;
                }
                System.out.println("We did a course thing!");
//            } else if (choiceOne==2){
//                switch (choiceTwo){
//                    case 1:continentService.showAllContinents();break;
//                    case 2:continentService.showContinentById();break;
//                    case 3:continentService.insertAContinent();break;
//                    case 4:continentService.updateAContinent();break;
//                    case 5:continentService.deleteAContinent();break;
//                }
//                System.out.println("We did a continent thing!");
//            }
//            else if (choiceOne==3){
//                switch (choiceTwo){
//                    case 1:cityService.showAllCities();break;
//                    case 2:cityService.showCityById();break;
//                    case 3:cityService.insertACity();break;
//                    case 4:cityService.updateACity();break;
//                    case 5:cityService.deleteACity();break;
//                }
                System.out.println("We did a city thing!");
            }
        choiceOne =9;
        choiceTwo =9;
        boolean goodAnswer;
        do {
            System.out.println("Do you want to Try again? Y/N");
            String answer = scanner.next();
            if (answer.toUpperCase(Locale.ROOT).equals("N")){
                System.out.println("Bye!");
                continueThis = false;
                break;
            }
            if (!answer.toUpperCase(Locale.ROOT).equals("Y")) {
                goodAnswer = false;
                System.out.println(answer+ " is not a good answer.");
            }
            else goodAnswer = true;
        }while (!goodAnswer);
    }
}