import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * The translator class written by mcgeep
 */
public class Translator
{

	private JButton translate;
	private JTextField input;
	private JTextField output;
	private Properties table;
	private int width;
	private int height;
	private int numberOfCharacters;

	// set size
	// window destroyer
	// add listner
	
	
	
	public class WindowsExit extends WindowAdapter
	{
		public void windowCLosing (WindowEvent e)
		{
			System.exit(0);
		}
	}
	private void Translator()
	{
		ActionListener buttonListener = new ActionListener()
		{
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
		}
		catch (FileNotFoundException e)
		{
			output.setText("Error in loading dictionary.txt");
			e.printStackTrace();
		}
		// create a new table of properties
		// open the file with file stream
		// /table load
		// close the input

		// for exception "output error"
	}

	private void translate()
	{
		String inputMessage = input.getText();
		String translationWord;
		String translationOutput="";
		String[] words=inputMessage.split(" ");
		// create an array using split

		for (String word : words)
		{
			translationWord=table.getProperty(word);
			if(translationWord!=null)
				translationOutput+=(translationWord);
			else
				translationOutput+= word + "";
		}
		
		output.setText(translationOutput);
	}

}
