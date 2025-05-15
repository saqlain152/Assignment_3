public class Manager extends User {
    public Manager(String n, String e, String p) {
        super(n, e, p);
    }
    public String getRole() {
        return "Manager";
    }
    public void managerTasks() {
        System.out.println("Manager specific tasks here...");
    }
}
