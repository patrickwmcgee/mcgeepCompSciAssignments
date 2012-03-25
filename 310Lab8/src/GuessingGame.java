import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GuessingGame
{

	private BinaryTree<String> decisionTree;
	private static Scanner scanner = new Scanner(System.in);

	public GuessingGame()
	{
		decisionTree = new BinaryTree(new BinaryNode("Is the animal warm blooded?"));
		// decisionTree.getRoot().setData("Is the animal warm blooded?");
		decisionTree.getRoot().setLeft(new BinaryNode("Is the animal an amphibian?"));
		decisionTree.getRoot().setRight(new BinaryNode("Does the animal have four legs?"));

		decisionTree.getRoot().getLeft().setLeft(new BinaryNode("Does the reptile slither?"));
		decisionTree.getRoot().getLeft().getLeft().setLeft(new BinaryNode("Your animal is a lizard!"));
		decisionTree.getRoot().getLeft().getLeft().setRight(new BinaryNode("Your animal is a snake!"));

		decisionTree.getRoot().getLeft().setRight(new BinaryNode("Does the Amphibian hop?"));
		decisionTree.getRoot().getLeft().getRight().setLeft(new BinaryNode("Your animal is a gecko!"));
		decisionTree.getRoot().getLeft().getRight().setRight(new BinaryNode("Your animal is a frog!"));

		decisionTree.getRoot().getRight().setLeft(new BinaryNode("Is the two legged animal a marsupial?"));
		decisionTree.getRoot().getRight().getLeft().setLeft(new BinaryNode("Your animal is a human!"));
		decisionTree.getRoot().getRight().getLeft().setRight(new BinaryNode("Your animal is a kangaroo!"));

		decisionTree.getRoot().getRight().setRight(new BinaryNode("Does the four legged animal meow?"));
		decisionTree.getRoot().getRight().getRight().setLeft(new BinaryNode("Your animal is a dog!"));
		decisionTree.getRoot().getRight().getRight().setRight(new BinaryNode("Your animal is a cat!"));

	}

	public void play()
	{
		String userInput;

		System.out.println("This simple counting game will guess an animal, to answer a question prompted answer clearly Yes or No");
		while (!decisionTree.getCurrentNode().isLeaf())
		{
			System.out.println(decisionTree.getCurrentNode().getData());
			if (isUserResponseYes(getUserResponse()) == true)
			{
				decisionTree.advanceRight();
			}
			else
			{
				decisionTree.advanceLeft();
			}

		}
		System.out.println(decisionTree.getCurrentNode().getData());
		decisionTree.resetCurrentNode();
	}

	public String getUserResponse()
	{
		return scanner.nextLine();
	}

	public boolean isUserResponseYes(String userResponse)
	{
		if (userResponse.equals("Yes"))
		{
			return true;
		}
		else if (userResponse.equals("yes"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public static void levelorderTraverse(BinaryNode<?> n)
	{
		Queue<BinaryNode<?>> nodequeue = new LinkedList<BinaryNode<?>>();

		if (n != null)
			nodequeue.add(n);
		while (!nodequeue.isEmpty())
		{
			BinaryNode<?> next = nodequeue.remove();
			System.out.print(next.getData() + " \n");
			if (next.getLeft() != null)
			{
				nodequeue.add(next.getLeft());
			}
			if (next.getRight() != null)
			{
				nodequeue.add(next.getRight());
			}
		}
	}

	public static void main(String[] args)
	{
		GuessingGame game = new GuessingGame();
		boolean continuePlay = true;
		System.out.println("Level order traverse of decisionTree");
		levelorderTraverse(game.decisionTree.getRoot());

		System.out.println("\n");
		while (continuePlay)
		{
			game.play();
			System.out.println("Would you like to play again? Enter Yes or No");
			continuePlay = game.isUserResponseYes(game.getUserResponse());
		}

	}
}
