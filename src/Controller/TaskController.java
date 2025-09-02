package Controller;

import Model.Task;

import java.util.*;

public class TaskController {
    int id;
    private Map<Integer, Task> tasks = new LinkedHashMap<>();


    public void addTaskToList() {
        try {
            Scanner input = new Scanner(System.in);

            System.out.print("\n\t- Enter task name: ");
            String name = input.nextLine();

            System.out.print("\t- Enter task description: ");
            String description = input.nextLine();

            System.out.print("\t- Enter task category: ");
            String category = input.nextLine();

            System.out.print("\t- (optional) Enter task end date ( dd/MM/yyyy:HH:mm:ss ): ");
            String endDate = input.nextLine();

            System.out.print("\t- Enter task priority (1 - 5): ");
            int priority = input.nextInt();

            Task task = new Task(name, description, category, endDate, priority);
            tasks.put(id, task);

            id++;
        } catch (Exception e) {
            System.out.println("\n\t\t- Invalid input -");
        }
    }

    public void getTasks() {
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            System.out.println("\n\t" + "TaskID : " + entry.getKey() + "\n" + entry.getValue() + "\n\t\t\t-");
        }
    }

    public void getTasksByStatus() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\t- Select status (ToDo - Doing - Done): ");
        String status =  input.nextLine();

        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getStatus().toString().equals(status.toUpperCase())) {
                System.out.println("\n\t" + "TaskID : " + entry.getKey() + "\n" + entry.getValue() + "\n\t\t\t-");
            }

        }
    }

    public void getTasksByPriority() {
        for(int i = 5; i > 0;  i--) {
            for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
                if (entry.getValue().getPriority() == i) {
                    System.out.println("\n\t" + "TaskID : " + entry.getKey() + "\n" + entry.getValue() + "\n\t\t\t-");
                }
            }
        }
    }
    public void getTasksByCategory() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\t- Select category: ");
        String category = input.nextLine();

        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if (entry.getValue().getCategory().equalsIgnoreCase(category)) {
                System.out.println("\n\t" + "TaskID : " + entry.getKey() + "\n" + entry.getValue() + "\n\t\t\t-");
            }
        }

    }

    public void updateTask() {
        Scanner input = new Scanner(System.in);

        System.out.print("\n\t- Enter TaskID: ");
        int id = Integer.parseInt(input.nextLine());

        Task task = tasks.get(id);

        if (task != null) {
            try {
                System.out.print("\n\t- Change the status of the task (ToDo - Doing - Done) (Skip do not change): ");
                String status = input.nextLine();
                if (!status.isEmpty()) task.setStatus(status.toUpperCase());

                System.out.print("\t- Enter new task name (Skip do not change): ");
                String name = input.nextLine();
                if (!name.isEmpty()) task.setName(name);

                System.out.print("\t- Enter new task description (Skip do not change): ");
                String description = input.nextLine();
                if (!description.isEmpty()) task.setDescription(description);

                System.out.print("\t- Enter new task category (Skip do not change): ");
                String category = input.nextLine();
                if (!category.isEmpty()) task.setCategory(category);

                System.out.print("\t- Enter new task end date ( dd/MM/yyyy:HH:mm:ss ) (Skip do not change): ");
                String endDate = input.nextLine();
                if (!endDate.isEmpty()) task.setEndDate(endDate);

                System.out.print("\t- Enter new task priority (1 - 5) (0 do not change): ");
                int priority = input.nextInt();
                if (!(priority == 0)) task.setPriority(priority);

            } catch (IllegalArgumentException e) {
                System.out.println("\n\t\t- Invalid input -");
            }
        } else {
            System.out.println("\n\t\t- Invalid Model.Task -");
        }

    }

    public void deleteTask() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n\t- Enter TaskID: ");
        int id = input.nextInt();

        tasks.remove(id);
    }

    public void alertTask() {
        System.out.println();

        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if(entry.getValue().getEndDate() != null){
                if (entry.getValue().getEndDate().getTime() > new Date().getTime() && (entry.getValue().getEndDate().getTime() - 1000 * 60 * 60 * 2) < new Date().getTime()) {
                    System.out.println("\t[Alert] Task: " + entry.getKey() + " is close to the due date!");
                }
            }
        }

    }
}
