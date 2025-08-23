package Model;

public enum Status {

    TODO("ToDo"),
    DOING("Doing"),
    DONE("Done");

    private String status;
    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

}
