package program;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();
        String option;
        int i = 0;
        do {
            i++;
            System.out.println();
            System.out.println("Emplyoee #" + i + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.print("This ID already taken! Try Again: ");
                id = sc.nextInt();
            }
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();


            Employee emp = new Employee(id, name, salary);
            list.add(emp);

            System.out.println();
            System.out.print("Do you want to register a new employee: ");
            option = sc.next().toLowerCase();
            while (!option.equals("y") && !option.equals("n")){
                System.out.println("Invalid option! Try again: ");
                option = sc.next().toLowerCase();
            }
        } while (option.equals("y"));

        System.out.println();
        System.out.print("Enter the employee ID that will have salary increase: ");
        int id = sc.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if(emp == null){
            System.out.println("ID does not exist.");
        }else{
            System.out.print("Enter the percentage: ");
            Double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees: ");
        System.out.println();
        for(Employee obj : list){
            System.out.println(obj);
        }
    }

    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        return emp != null;
    }
}