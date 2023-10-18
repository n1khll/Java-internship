import java.util.*;
public class ToDoList {
    private ArrayList<String> todoList=new ArrayList<String>();
    public void displayList(){
        if(todoList.isEmpty())
            System.out.println("No tasks to Display!\n");
        else{
            for(int i=0;i<todoList.size();i++)
                System.out.println("Task"+(i+1)+":"+todoList.get(i));
        }
    }
    public void addTask(String task){
        todoList.add(task);
        System.out.println("Task added successfully!\n");
    }
    public void removeTask(int taskIndex){
        if(taskIndex>=0 && taskIndex<todoList.size()){
            todoList.remove(taskIndex);
            System.out.println("Task removed at index"+taskIndex);
        }}
public static void main(String[] args) {
    ToDoList app = new ToDoList(); //instantiation of class
    Scanner sc = new Scanner(System.in);
    int ch;
    do{
        System.out.println("MENU:\n1.Display To Do list\n2.Add a new task\n3.Remove task at specified index\n4.Exit");
        System.out.println("Enter your choice:");
        ch = sc.nextInt();
        sc.nextLine();
        switch (ch) {
            case 1:
                app.displayList();
                break;
            case 2:
                System.out.println("Enter the task to be added:");
                String task = sc.nextLine();
                app.addTask(task);
                break;
            case 3:
                System.out.println("Enter the index of the task to be removed:");
                int i = sc.nextInt();
                sc.nextLine();
                app.removeTask(i);
                break;
            case 4:
                System.out.println("Exited Successfully!");
                break;
            default:
                System.out.println("Invalid choice. Please try again!");
        }
    }
    while(ch!=4);
    sc.close();
}}


