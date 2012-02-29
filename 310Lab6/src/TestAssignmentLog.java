import java.util.PriorityQueue;

public class TestAssignmentLog
{

	public static void main(String[] args)
	{
		// Create the priority queue
		PriorityQueue<Assignment> workLoad = new PriorityQueue<Assignment>();

		// Add assignments to the priority queue
		workLoad.add(new Assignment("2012-02-29", "History 140", "Read Chapter 19", 15));
		workLoad.add(new Assignment("2012-03-01", "Discrete Math", "HW# 4", 15));
		workLoad.add(new Assignment("2012-02-29", "Engineering Physics II", "HW #6", 10));
		workLoad.add(new Assignment("2012-03-02", "Data Structures", "Lab #4", 5));
		workLoad.add(new Assignment("2012-02-28", "Database Management", "ER Diagrams for Project", 10));
		workLoad.add(new Assignment("2012-02-29", "History 140", "Read Handout", 5));
		workLoad.add(new Assignment("2012-02-27", "Data Structures", "Lab #6 with Extra Credit", 25));

		// Print out all of the assignments
		System.out.println("All of the assignments in the workload ");
		for (Assignment assignment : workLoad)
		{
			assignment.display();
			System.out.println("");
		}

		// Check the highest priority assignment
		System.out.println("The highest Priority assignment is: ");
		workLoad.peek().display();
		System.out.println("");

		// Remove a few assignments in order of their priority
		for (int i = 0; i < 3; i++)
		{
			System.out.println("The Assignment ");
			workLoad.poll().display();
			System.out.println("has been completed\n");
		}

		// Print out all of the assignments
		System.out.println("All of the assignments in the workload ");
		for (Assignment assignment : workLoad)
		{
			assignment.display();
			System.out.println("");
		}

		// Check the highest priority assignment
		System.out.println("The highest Priority assignment is: ");
		workLoad.peek().display();
		System.out.println("");

	}
}
