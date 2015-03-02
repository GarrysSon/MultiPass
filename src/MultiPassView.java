import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import java.util.ArrayList;

public class MultiPassView
{
	/**
	 * The current question.
	 */
	private Text question;
	
	/**
	 * The button associated with answer number 1.
	 */
	private Button answer1;
	
	/**
	 * The button associated with answer number 2.
	 */
	private Button answer2;
	
	/**
	 * The button associated with answer number 3.
	 */
	private Button answer3;
	
	/**
	 * The button associated with answer number 4.
	 */
	private Button answer4;
	
	private Menu menuBar;
	
	/**
	 * Empty constructor.
	 */
	public MultiPassView()
	{
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("MultiPass");
		shell.setSize(250, 200);
		
		// Create the menu bar.
		menuBar = new Menu(shell, SWT.BAR);
		MenuItem fileHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileHeader.setText("&File");
		
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		
		MenuItem open = new MenuItem(fileMenu, SWT.PUSH);
		open.setText("&Open");
		//TODO: Need to set up with controller.
		open.addSelectionListener(new SelectionAdapter()
		{
			@Override
            public void widgetSelected(SelectionEvent e)
			{
                System.exit(0);
            }
		});
		
		fileHeader.setMenu(fileMenu);
		// End of menu bar.
		
		// Question.
		question = new Text(shell, SWT.NONE);
		
		// Buttons.
		Composite buttons = new Composite(shell, SWT.NONE);
		buttons.setLayout(new FillLayout());
		
		answer1 = new Button(buttons, SWT.PUSH);
		answer1.setText("Answer 1");
		
		answer2 = new Button(buttons, SWT.PUSH);
		answer2.setText("Answer 2");
		
		answer3 = new Button(buttons, SWT.PUSH);
		answer3.setText("Answer 3");
		
		answer4 = new Button(buttons, SWT.PUSH);
		answer4.setText("Answer 4");
		// End of buttons.
		
		shell.setMenuBar(menuBar);
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
