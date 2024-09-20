class Complaints {
    private String description;
    private String status;
    private String Student_name;

    public Complaints(String description,String name){
        this.description = description;
        this.status = "Pending";
        this.Student_name=name;
    }

    public String getDescription() {
        return description;
    }
    public String getStudent_name() {
        return Student_name;
    }

    public String getStatus() {
        return status;
    }
    public void adminresolve() {
        status = "Resolved";
    }

}
