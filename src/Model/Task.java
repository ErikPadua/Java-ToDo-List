package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String name, description, category;
    private Date endDate;
    private int priority;
    private Status status;

    public Task(String name, String description, String category, String endDate, int priority) throws IllegalArgumentException {

        this.name = name;
        this.description = description;
        this.category = category;
        this.status = Status.TODO;

        try {
            if (priority > 0 && priority < 6) this.priority = priority;
            else throw new Exception();
        } catch (Exception e) {
            System.out.println("Priority out of range (1 - 5)");
            throw new IllegalArgumentException();
        }

        if (!endDate.isEmpty()) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.endDate = format.parse(endDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format try this format - ( dd/MM/yyyy )");
                throw new IllegalArgumentException();
            }
        } else {
            this.endDate = null;
        }
    }

    @Override
    public String toString() {
        return "\tName : " + name + "\n\t" + "Description : " + description + "\n\t" + "Category : " + category + "\n\t" + "Due Date : " + endDate + "\n\t" + "Priority : " + priority + "\n\t" + "Model.Status : " + status.getStatus();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.endDate = format.parse(endDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format try this format - ( dd/MM/yyyy )");
            throw new IllegalArgumentException();
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) throws IllegalArgumentException {
        try {
            if (priority > 0 && priority < 6) this.priority = priority;
            else throw new Exception();
        } catch (Exception e) {
            System.out.println("Priority out of range (1 - 5)");
            throw new IllegalArgumentException();
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        try {
            this.status = Status.valueOf(status);
        } catch (IllegalArgumentException e) {
            System.out.println("Model.Status should be (ToDo - Doing - Done)");
        }
    }
}
