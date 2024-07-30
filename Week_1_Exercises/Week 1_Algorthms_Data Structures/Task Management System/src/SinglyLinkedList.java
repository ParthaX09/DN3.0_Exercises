public class SinglyLinkedList {
    private Node head;

    // Node class
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add a task at the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Not found
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; // Not found
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        // Add tasks
        taskList.addTask(new Task("T001", "Task 1", "Pending"));
        taskList.addTask(new Task("T002", "Task 2", "Completed"));
        taskList.addTask(new Task("T003", "Task 3", "In Progress"));

        // Traverse tasks
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task
        Task foundTask = taskList.searchTask("T002");
        System.out.println("Search Result: " + (foundTask != null ? foundTask : "Not found"));

        // Delete a task
        boolean deleted = taskList.deleteTask("T003");
        System.out.println("Delete Result: " + (deleted ? "Deleted successfully" : "Not found"));

        // Traverse tasks again
        System.out.println("All Tasks After Deletion:");
        taskList.traverseTasks();
    }
}
