package homework_30.to_do_list.to_do_list;

import java.util.Scanner;

public class ToDoListAppl {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("To-Do List");
        ToDoList[] content =  ToDoList.values();
        for (ToDoList toDoList : content) {
            System.out.println(toDoList);
        }
        boolean flag = true;
        while (flag){
            System.out.println("Input your choice");
            int optionNumber = scanner.nextInt();
            switch (optionNumber){
                case 1 -> System.out.println("Your choice is: " + content[optionNumber - 1].toString());
                case 2 -> System.out.println("Your choice is: " + content[optionNumber - 1].toString());
                case 3 -> System.out.println("Your choice is: " + content[optionNumber - 1].toString());
                case 4 -> System.out.println("Your choice is: " + content[optionNumber - 1].toString());
                case 5 -> flag = false;
                default -> System.out.println("Wrong choice");
            }

        }
    }
}
