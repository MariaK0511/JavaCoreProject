import entity.Grades;
import entity.Students;
import service.GradesService;
import service.StudentsService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
/*
система учета студентов и их успеваемости.

добавление в базу данных студентов. +
удаление +
обновление +
поиск(выбор) +
s
добавление в базу данных успеваемости +
обновление
поиск(выбор)
 */
        Scanner scanner = new Scanner(System.in);

        StudentsService studentsService = new StudentsService();
        GradesService gradesService = new GradesService();

        Students students = new Students();
        Grades grades = new Grades();

        System.out.println("enter number of command: ");
        int command = scanner.nextInt();

        if (command == 0) {
            System.out.println("list of students: ");
            studentsService.getAll().forEach(System.out::println);
        } else if (command == 1) {
            students.setId(14);
            students.setName("Tanya Y");
            studentsService.add(students);
            System.out.println("student was added");
        } else if (command == 2) {
            grades.setId(10);
            gradesService.removeGrade(grades);
            System.out.println("grade was deleted");
        } else if (command == 3) {
            students.setId(10);
            studentsService.removeByName(students);
            System.out.println("student was deleted");
        } else if (command == 4) {
            students.setId(10);
            studentsService.update(students);
            System.out.println("student was updated");
        } else if (command == 5) {
            students.setId(1);
            studentsService.search(students);
            System.out.println("student was searched");
        } else if (command == 6) {
            grades.setId(7);
            grades.setGrade(5);
            gradesService.add(grades);
            System.out.println("grade was added");
        } else if (command == 7) {
            grades.setId(3);
            gradesService.update(grades);
            System.out.println("grade was updated");
        } else if (command == 8) {
            System.out.println("this command searches grade: ");
            grades.setId(6);
            gradesService.search(grades);
        } else {
            System.out.println("command isn't recognized");
        }
    }
}
