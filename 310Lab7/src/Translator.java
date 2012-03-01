import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * The translator class written by mcgeep
 */
public class Translator extends JFrame
{
	private JFrame frame;
	private JButton translate;
	private JTextField input;
	private JTextField output;
	private Properties table;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int NUMBER_OF_CHAR = 20;

	// set size
	// window destroyer
	// add listner

	public class WindowsExit extends WindowAdapter
	{
		public void windowCLosing(WindowEvent e)
		{
			System.exit(0);
		}
	}

	private void Translator()
	{
		setSize(WIDTH, HEIGHT);

		frame = new JFrame();
		WindowsExit listener = new WindowsExit();
		ActionListener buttonListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				translate();

			}
		};

		translate.addActionListener(buttonListener);
	}

	// performed if action.command equals translate, translate

	private void loadDictionary()
	{
		table = new Properties();

		try
		{
			FileInputStream input = new FileInputStream("dictionary.txt");
			table.load(input);
			input.close();
		}
		catch (IOException e)
		{
			output.setText("Error in loading dictionary.txt");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// create a new table of properties
	// open the file with file stream
	// /table load
	// close the input

	// for exception "output error"

	private void translate()
	{
		String inputMessage = input.getText();
		String translationWord;
		String translationOutput = "";
		String[] words = inputMessage.split(" ");
		// create an array using split

		for (String word : words)
		{
			translationWord = table.getProperty(word);
			if (translationWord != null)
				translationOutput += (translationWord);
			else
				translationOutput += word + "";
		}

		output.setText(translationOutput);
	}

	public static void main(String[] args)
	{
		Translator translateGui = new Translator();
		translateGui.show();
	}

}
