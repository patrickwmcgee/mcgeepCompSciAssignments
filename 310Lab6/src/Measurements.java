import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Measurements
{
	Deque<Integer> arrayDeque;
	Deque<Integer> linkedListDeque;
	Stack<Integer> stack;
	ArrayDeque<Integer> arrayStack;

	Measurements()
	{
		arrayDeque = new ArrayDeque<Integer>();
		linkedListDeque = new LinkedList<Integer>();
		stack = new Stack<Integer>();
		arrayStack = new ArrayDeque<Integer>();
		fillRandomNumbers();

	}

	public static void main(String[] args)
	{
		Measurements measurement = new Measurements();

		System.out.println(measurement.toString());
	}

	public void fillRandomNumbers()
	{
		int randomNumber = 0;
		for (int i = 0; i < 100000; i++)
		{
			randomNumber = (1 + (int) (Math.random() * 100));
			arrayDeque.add(randomNumber);
			linkedListDeque.add(randomNumber);
			stack.push(randomNumber);
			arrayStack.push(randomNumber);
		}

	}

	public long dequeLinkedListGetFirst()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		linkedListDeque.getFirst();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeArrayGetFirst()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayDeque.getFirst();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeLinkedListGetLast()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		linkedListDeque.getLast();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeArrayGetLast()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayDeque.getLast();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeLinkedListAddFirst()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		linkedListDeque.addFirst(1);

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeArrayAddFirst()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayDeque.addFirst(1);

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeLinkedListAddLast()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		linkedListDeque.addLast(12);

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeArrayAddLast()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayDeque.addLast(12);

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeLinkedListRemoveFirst()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		linkedListDeque.removeFirst();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeArrayRemoveFirst()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayDeque.removeFirst();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeLinkedListRemoveLast()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		linkedListDeque.removeLast();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long dequeArrayRemoveLast()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayDeque.removeLast();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long stackVectorPeek()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		stack.peek();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long stackVectorPush()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		stack.push(42);

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long stackVectorPop()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		stack.pop();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long arrayStackPeek()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayStack.peek();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long arrayStackPush()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayStack.push(42);

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public long arrayStackPop()
	{
		// Measure elapsed time in nanoseconds
		long start = System.nanoTime();

		arrayStack.pop();

		// Stop timing
		long end = System.nanoTime();
		long elapsedTime = end - start;
		// return time
		return elapsedTime;

	}

	public String toString()
	{
		String returnString = "";
		
		returnString+="ArrayDeque<E> implementation vs. LinkedList<E> implementation for Deque\n";
		
		returnString += "GetFirst time for LinkedList<E> Implementation " + dequeLinkedListGetFirst() + " Nanoseconds\n";
		returnString += "GetFirst time for ArrayDeque<E> Implementation " + dequeArrayGetFirst() + " Nanoseconds\n";

		returnString += "GetLast time for LinkedList<E> Implementation " + dequeArrayGetLast() + " Nanoseconds\n";
		returnString += "GetLast time for ArrayDeque<E> Implementation " + dequeArrayGetLast() + " Nanoseconds\n";
		
		returnString += "AddFirst time for LinkedList<E> Implementation " + dequeArrayAddFirst() + " Nanoseconds\n";
		returnString += "AddFirst time for ArrayDeque<E> Implementation " + dequeArrayAddFirst() + " Nanoseconds\n";
		
		returnString += "AddLast time for LinkedList<E> Implementation " + dequeArrayAddLast() + " Nanoseconds\n";
		returnString += "AddLast time for ArrayDeque<E> Implementation " + dequeArrayAddLast() + " Nanoseconds\n";
		
		returnString += "RemoveFirst time for LinkedList<E> Implementation " + dequeArrayRemoveFirst() + " Nanoseconds\n";
		returnString += "RemoveFirst time for ArrayDeque<E> Implementation " + dequeArrayRemoveFirst() + " Nanoseconds\n";
		
		returnString += "RemoveLast time for LinkedList<E> Implementation " + dequeArrayRemoveLast() + " Nanoseconds\n";
		returnString += "RemoveLast time for ArrayDeque<E> IWWmplementation " + dequeArrayRemoveLast() + " Nanoseconds\n";
		
		returnString+="\n";
		returnString+= "Stack<E> implementation vs. ArrayDeque<E> implementation for Stack\n";
		
		returnString += "Peek time for Stack<E> Implementation " + stackVectorPeek() + " Nanoseconds\n";
		returnString += "Peek time for ArrayDeque<E> Implementation " + arrayStackPeek() + " Nanoseconds\n";
		
		returnString += "Push time for Stack<E> Implementation " + stackVectorPush() + " Nanoseconds\n";
		returnString += "Push time for ArrayDeque<E> Implementation " + arrayStackPush() + " Nanoseconds\n";
		
		returnString += "Pop time for Stack<E> Implementation " + stackVectorPop() + " Nanoseconds\n";
		returnString += "Pop time for ArrayDeque<E> Implementation " + arrayStackPop() + " Nanoseconds\n";
		
		return returnString;
	}
}
