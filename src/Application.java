import Controller.TaskController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        int choice;

        do {
            taskController.alertTask();
            choice = menu();

            switch (choice) {
                case 1:
                    taskController.addTaskToList();
                    break;
                case 2:
                    switch (taskListMenu()) {
                        case 1:
                            taskController.getTasks();
                            break;
                        case 2:
                            taskController.getTasksByStatus();
                            break;
                        case 3:
                            taskController.getTasksByPriority();
                            break;
                        case 4:
                            taskController.getTasksByCategory();
                            break;
                    }
                    break;
                case 3:
                    taskController.updateTask();
                    break;
                case 4:
                    taskController.deleteTask();
                    break;
            }

        } while (choice != 5);
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\t === Task Manager ===\n");
        Map<Integer, String> options = new LinkedHashMap<>(Map.ofEntries(
                Map.entry(1, "Create Task  "),
                Map.entry(2, "View Tasks   "),
                Map.entry(3, "Modify Task  "),
                Map.entry(4, "Delete Task  "),
                Map.entry(5, "Close Program")
        ));

        for (int i = 1; i <= options.size(); i++) {
            if (i == 5) System.out.println("\t[ " + i + " - " + options.get(i) + "\t]");
            else System.out.println("\t[ " + i + " - " + options.get(i) + "\t]");
        }

        System.out.print("\n\t- Select an option: ");
        return input.nextInt();
    }

    public static int taskListMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\t === Task List Menu ===\n");
        Map<Integer, String> options = new LinkedHashMap<>(Map.ofEntries(
                Map.entry(1,"All Tasks          "),
                Map.entry(2, "Status Tasks      "),
                Map.entry(3, "Priority Tasks    "),
                Map.entry(4, "Category Tasks    "),
                Map.entry(5, "Return            ")
        ));

        for (int i = 1; i <= options.size(); i++) {
            if (i == 6) System.out.println("\t[ " + i + " - " + options.get(i) + "\t]");
            else System.out.println("\t[ " + i + " - " + options.get(i) + "\t]");
        }


        System.out.print("\n\t- Select a type of classification: ");
        return input.nextInt();
    }

}
