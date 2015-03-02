import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import java.util.ArrayList;

public class MultiPassView
{
	/**
	 * The current question.
	 */
	private Label question;
	
	/**
	 * The buttons for MultiPass.
	 */
	private Button answerOne, answerTwo, answerThree, answerFour, submit;
	
	/**
	 * The menu bar for MultiPass.
	 */
	private Menu menuBar;
	
	/**
	 * Empty constructor.
	 */
	public MultiPassView()
	{
		Display display = new Display();
		Shell shell = CreateShell(display);
		shell.open();
		
		// Run while the shell is open.
		while(!shell.isDisposed())
		{
			// If their's an event, process it. Otherwise just wait around.
			if(!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}
	
	/**
	 * Creates the shell for MultiPass view.
	 * 
	 * @param display	The display associated with the shell.
	 * @return			The shell for the MultiPass view.
	 */
	private Shell CreateShell(final Display display)
	{
		final Shell shell = new Shell(display);
		shell.setText("MultiPass");
		
		GridLayout shellLayout = new GridLayout();
		shellLayout.numColumns = 1;
		shell.setLayout(shellLayout);
		
		// Question.
		question = new Label(shell, SWT.NONE);
		question.setText("This is the question?");
		
		// Buttons.
		answerOne = MultiPassButton(shell, "A", 10, new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		answerTwo = MultiPassButton(shell, "B", 10, new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		answerThree = MultiPassButton(shell, "C", 10, new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		answerFour = MultiPassButton(shell, "D", 10, new GridData(GridData.FILL, GridData.END, true, false));
		
		submit = MultiPassButton(shell, "Submit", 50, new GridData(GridData.END, GridData.END, true, false));
		
		shell.pack();
		return shell;
	}
	
	/**
	 * Method to create a generic MultiPass button.
	 * 
	 * @param shell				The shell associated with this button.
	 * @param buttonText		The text for this button.
	 * @param horizontalIndent	The horizontal indent for this button.
	 * @param layout			The GridData layout associated with this button.
	 * 
	 * @return					The newly created button.
	 */
	private Button MultiPassButton(Shell shell, String buttonText, int horizontalIndent, GridData layout)
	{
		// Create the button.
		Button button = new Button(shell, SWT.PUSH);
		button.setText(buttonText);
		
		// Set the buttons indent, layout, and selection listener.
		layout.horizontalIndent = horizontalIndent;
		button.setLayoutData(layout);
		button.addSelectionListener(AnswerSelection(buttonText));
		
		return button;
	}
	
	/**
	 * Creates a SelectionAdapter for a MultiPass answer.
	 * 
	 * @param answer		The title of the selected button.
	 * 
	 * @return				The SelectionAdapter for the associated answer.
	 */
	private SelectionAdapter AnswerSelection(String answer)
	{
		// Print the button that was clicked. (This is not a real adapter)
		SelectionAdapter adapter = new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				System.out.println("Selected the " + answer + " button.");
			}
		};
		
		return adapter;
	}
	
	/**
	 * Gets the file chosen by the user
	 * 
	 * @return			The string version of the path to the selected file.
	 */
	public String GetFile()
	{
		FileDialog dialog = new FileDialog(new Shell(new Display()) , SWT.OPEN);
		dialog.setFilterExtensions(new String [] {"*.txt"});
		return dialog.open();
	}
	
	/**
	 * Prints an ArrayList of questions.
	 * 
	 * @param questions	The ArrayList of questions to print.
	 */
	public void PrintQuestions(ArrayList<Question> questions)
	{
		for(Question tempQuest : questions)
		{
			System.out.println(tempQuest.question);
			
			for(Answer tempAnswer : tempQuest.answers)
			{
				if(tempAnswer.IsCorrect())
				{
					System.out.println(tempAnswer.answer + "\tCorrect! ");
				}
				else
				{
					System.out.println(tempAnswer.answer);
				}
			}
			
			System.out.println();
		}
	}
}
