import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Task {
    private String description;
    private Date date;

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
}

public class ToDoList {
    private ArrayList<Task> taskList;
    private Timer timer;

    public ToDoList() {
        taskList = new ArrayList<>();
        timer = new Timer();
    }

    public void addTask(String description, Date date) {
        Task task = new Task(description, date);
        taskList.add(task);

        TimerTask scheduledTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Reminder: " + description);
            }
        };

        timer.schedule(scheduledTask, date);
    }

    public void showTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks pending.");
        } else {
            System.out.println("To-Do List:");
            for (Task task : taskList) {
                System.out.println("Description: " + task.getDescription());
                System.out.println("Date: " + task.getDate());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        // Add sample tasks
        toDoList.addTask("Complete report", new Date());
        toDoList.addTask("Go for a run", new Date(System.currentTimeMillis() + 30000)); // Task in 30 seconds

        // Show tasks
        toDoList.showTasks();
    }
}
