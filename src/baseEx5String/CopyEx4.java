package baseEx5String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CopyEx4 {
	
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Map<String, Object>> students = new ArrayList<>();

	        boolean moreStudents = true;

	        while (moreStudents) {
	            String lastName = getInput(scanner, "Nom de l'élève : ");
	            String firstName = getInput(scanner, "Prénom de l'élève : ");

	            ArrayList<Double> grades = getGrades(scanner);

	            Map<String, Object> student = new HashMap<>();
	            student.put("firstName", firstName);
	            student.put("lastName", lastName);
	            student.put("grades", grades);

	            students.add(student);

	            displayStudent(firstName, lastName, grades);

	            String answer = getInput(scanner, "Voulez-vous saisir un autre élève ? (oui/non) : ");
	            if (answer.equalsIgnoreCase("non")) {
	                moreStudents = false;
	            }
	        }

	        System.out.println("\n1. Rechercher un étudiant par nom");
	        System.out.println("2. Rechercher les étudiants par note");
	        System.out.println("3. Trier les prénoms par ordre décroissant");
	        System.out.println("4. Trier les prénoms par ordre croissant");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); 

	        switch (choice) {
	            case 1:
	                searchByName(students, scanner);
	                break;
	            case 2:
	                searchByGrades(students, scanner);
	                break;
	            case 3:
	            	sortByFirstNameDesc(students);
	                break;
	            case 4:
	            	sortByFirstNameAsc(students);
	                break;
	            default:
	                System.out.println("Choix invalide, veuillez réessayer.");
	                
	        searchByName(students, scanner);
	        searchByGrades(students, scanner);
	        scanner.close();
	        }
	    }

	    public static String getInput(Scanner scanner, String message) {
	        System.out.print(message);
	        return scanner.nextLine();
	    }

	    public static ArrayList<Double> getGrades(Scanner scanner) {
	        ArrayList<Double> grades = new ArrayList<>();
	        boolean finished = false;

	        while (!finished) {
	            System.out.print("Note de l'élève (ou -1 pour terminer) : ");
	            if (scanner.hasNextDouble()) {
	                double grade = scanner.nextDouble();
	                if (grade == -1) {
	                    finished = true;
	                } else {
	                    grades.add(grade);
	                }
	            } else {
	                System.out.println("Entrée invalide, veuillez saisir un nombre.");
	                scanner.next();
	            }
	        }
	        scanner.nextLine();
	        return grades;
	    }

	    public static void displayStudent(String firstName, String lastName, ArrayList<Double> grades) {
	        System.out.println("\nÉlève : " + firstName + " " + lastName);
	        System.out.println("Notes : " + grades);

	        if (!grades.isEmpty()) {
	        	
	        	double min = BaseEx4Array.getMin(grades);
	            System.out.println("Minimum : " + min);
	        	
	        	double max = BaseEx4Array.getMax(grades);
	        	System.out.println("Maximum : " + max);
	        	
	            double average = BaseEx4Array.getAverage(grades);
	            System.out.println("Moyenne : " + average);
	            
	        } else {
	            System.out.println("Aucune note saisie.");
	        }
	    }

	    public static void searchByName(ArrayList<Map<String, Object>> students, Scanner scanner) {
	        String searchLastName = getInput(scanner, "\nEntrez le nom de l'élève à rechercher : ");
	        String searchFirstName = getInput(scanner, "Entrez le prénom de l'élève à rechercher : ");

	        boolean found = false;

	        for (Map<String, Object> student : students) {
	            String lastName = (String) student.get("lastName");
	            String firstName = (String) student.get("firstName");
	            ArrayList<Double> grades = (ArrayList<Double>) student.get("grades");

	            if (lastName.equalsIgnoreCase(searchLastName) && firstName.equalsIgnoreCase(searchFirstName)) {
	            	
	            	String word = getInput(scanner, "Par quel mot remplacé trouvé : ");
	            	String phrase = "\\nÉlève trouvé !";
	            	phrase = phrase.replace("trouvé", word);
	                System.out.println(phrase);
	                
	                displayStudent(firstName, lastName, grades);
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("\n Pas d'eleve trouvé");
	        }
	    }
	    
	    public static void searchByGrades(ArrayList<Map<String, Object>> students, Scanner scanner) {
	        ArrayList<Double> searchGrades = getGrades(scanner);

	        boolean found = false;

	        for (Map<String, Object> student : students) {
	            String lastName = (String) student.get("lastName");
	            String firstName = (String) student.get("firstName");
	            ArrayList<Double> grades = (ArrayList<Double>) student.get("grades");

	            if (grades.equals(searchGrades)) { 
	            	
	            	String word = getInput(scanner, "Par quel mot remplacé trouvé");
	            	String phrase = "\\nÉlève trouvé !";
	            	phrase = phrase.replace("trouvé", word);
	                System.out.println(phrase);
	                
	                displayStudent(firstName, lastName, grades);
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("\n Pas d'eleve trouvé");
	        }
	    }
	    
	    public static void sortByFirstNameDesc(ArrayList<Map<String, Object>> students) {
	        students.sort((s1, s2) -> {
	            String firstName1 = ((String) s1.get("firstName")).toLowerCase();
	            String firstName2 = ((String) s2.get("firstName")).toLowerCase();
	            return firstName2.compareTo(firstName1); 
	        });

	        System.out.println("\nListe des élèves triée par prénom (ordre décroissant) :");
	        for (Map<String, Object> student : students) {
	            String firstName = (String) student.get("firstName");
	            String lastName = (String) student.get("lastName");
	            ArrayList<Double> grades = (ArrayList<Double>) student.get("grades");
	            System.out.println("- " + firstName + " " + lastName + " : " + grades);
	        }
	    }
	    
	    public static void sortByFirstNameAsc(ArrayList<Map<String, Object>> students) {
	        students.sort((s1, s2) -> {
	            String firstName1 = ((String) s1.get("firstName")).toLowerCase();
	            String firstName2 = ((String) s2.get("firstName")).toLowerCase();
	            return firstName1.compareTo(firstName2); // ordre croissant
	        });

	        System.out.println("\nListe des élèves triée par prénom (ordre croissant) :");
	        for (Map<String, Object> student : students) {
	            String firstName = (String) student.get("firstName");
	            String lastName = (String) student.get("lastName");
	            ArrayList<Double> grades = (ArrayList<Double>) student.get("grades");
	            System.out.println("- " + firstName + " " + lastName + " : " + grades);
	        }
	    }

}
