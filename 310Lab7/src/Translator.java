import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
public class Translator extends JFrame implements ActionListener
{

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

	private Translator()
	{
		setSize(WIDTH, HEIGHT);

		loadDictionary();
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.GRAY);
		contentPane.setLayout(new FlowLayout());
		
		translate = new JButton("Translate");
		translate.addActionListener(this);
		contentPane.add(translate);
		
		input=new JTextField("Enter input text here");
		contentPane.add(input);
		output=new JTextField("Enter output text here");
		contentPane.add(output);

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
		translateGui.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Translate"))
		{
			translate();
		}

	}

}
