import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Assignment implements Comparable<Assignment>
{

	private Date dueDate;
	private String courseName;
	private String assignmentName;
	private int points;

	Assignment(String Date, String CourseName, String AssignmentName, int Points)
	{
		courseName = CourseName;
		assignmentName = AssignmentName;
		courseName = CourseName;
		dueDate = java.sql.Date.valueOf(Date);
		points = Points;
	}

	public int getPoints()
	{
		return points;
	}

	public Date getDueDate()
	{
		return dueDate;
	}

	private String getCourseName()
	{
		return courseName;
	}

	private String getAssignmentName()
	{
		return assignmentName;
	}

	public int compareTo(Assignment other)
	{
		if (this.dueDate.compareTo(other.getDueDate()) < 0)
			return (-1);
		else if (this.dueDate.compareTo(other.getDueDate()) > 0)
			return 1;
		else if (this.dueDate.compareTo(other.getDueDate()) == 0)
		{
			if (this.points > other.points)
				return (-1);
			else if (this.points < other.points)
				return 1;
			else if (this.points == other.points)
				return 0;

		}
		return 0; // default cause that should never happen
	}

	public void display()
	{
		System.out.print("Course: " + courseName + "\n" + "Assignment Name: " + assignmentName + "\n" + "Due Date: " + dueDate.toString() + "\n" + "Weight: " + points + "\n");

	}
}