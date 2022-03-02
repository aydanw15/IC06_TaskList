import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String name, dueDate, deadline;
        int priority, count = 0;

        Task taskList[] = new Task[10];

        Scanner keyboard = new Scanner(System.in);

        File binaryFile = new File("Tasks.dat");
        System.out.println("Previously saved tasks: ");
            if(binaryFile.exists() && binaryFile.length() > 1L)
            {
                try{
                    ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                    taskList = ((Task[]) fileReader.readObject());

                    while(taskList[count] != null)
                        System.out.println(taskList[count++]);
                    fileReader.close();
                }
                catch(IOException | ClassNotFoundException e){
                    System.out.println("Error: " + e.getMessage());
                }

            }
            else
            {
                System.out.println("No previous tasks found.");
            }

        do{

            System.out.print("Please enter task name (or \"quit\" to exit): ");
            name = keyboard.nextLine();
            if (name.equalsIgnoreCase("quit"))
                break;
            System.out.print("Please enter the due date (MM/DD/YYYY): ");
            dueDate = keyboard.nextLine();
            System.out.print("Please enter the time (00:00 AM/PM): ");
            deadline = keyboard.nextLine();
            System.out.print("Please enter priority: ");
            priority = keyboard.nextInt();

            taskList[count++] = new Task(name,dueDate,deadline,priority);

            keyboard.nextLine();

        }
        while(true);

        try{
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(taskList);
            fileWriter.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
    }

    }
}
