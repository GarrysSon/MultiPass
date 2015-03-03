import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import java.util.Observable;

public class MultiPassView implements java.util.Observer
{
	/**
	 * The model for MultiPas
	 */
	private MultiPassController controller;
	
	/**
	 * The current question.
	 */
	public Label question;
	
	/**
	 * The buttons for MultiPass.
	 */
	public Button answerOne, answerTwo, answerThree, answerFour, submit;
	
	/**
	 * The answers for MultiPass.
	 */
	public Label answerA, answerB, answerC, answerD;
	
	/**
	 * The menu bar for MultiPass.
	 */
	public Menu menuBar;
	
	/**
	 * The Shell associated with this view.
	 */
	private Shell shell;
	
	/**
	 * The Display associated with this view.
	 */
	private Display display;
	
	/**
	 * Empty constructor.
	 */
	public MultiPassView()
	{
		// Creating the display.
		display = new Display();
		shell = CreateShell(display);
	}
	
	/**
	 * Creates the shell for MultiPass view.
	 * 
	 * @param display		The display associated with the shell.
	 * @return				The shell for the MultiPass view.
	 */
	private Shell CreateShell(final Display display)
	{
		final Shell shell = new Shell(display);
		shell.setText("MultiPass");
		shell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		
		GridLayout shellLayout = new GridLayout();
		shellLayout.numColumns = 1;
		shell.setLayout(shellLayout);
		
		// Question.
		question = new Label(shell, SWT.WRAP);
		
		// Buttons.
		Composite compositeA = MultiPassComposite(shell);
		answerOne = MultiPassButton(compositeA, "A", 10, new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		answerA = new Label(compositeA, SWT.NONE);
		answerA.setLayoutData(new GridData(GridData.END, GridData.END, true, false));
		
		////////////////////////////////////////////////////////////////////////
		Composite compositeB = MultiPassComposite(shell);
		answerTwo = MultiPassButton(compositeB, "B", 10, new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		answerB = new Label(compositeB, SWT.NONE);
		answerB.setLayoutData(new GridData(GridData.END, GridData.END, true, false));
		
		////////////////////////////////////////////////////////////////////////
		Composite compositeC = MultiPassComposite(shell);
		answerThree = MultiPassButton(compositeC, "C", 10, new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		answerC = new Label(compositeC, SWT.NONE);
		answerC.setLayoutData(new GridData(GridData.END, GridData.END, true, false));
		
		////////////////////////////////////////////////////////////////////////
		Composite compositeD = MultiPassComposite(shell);
		answerFour = MultiPassButton(compositeD, "D", 10, new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		answerD = new Label(compositeD, SWT.NONE);
		answerD.setLayoutData(new GridData(GridData.END, GridData.END, true, false));
		
		////////////////////////////////////////////////////////////////////////
		submit = MultiPassButton(shell, "Submit", 50, new GridData(GridData.END, GridData.END, true, false));
		// End of Buttons.
		
		shell.pack();
		return shell;
	}
	
	/**
	 * Runs the view.
	 */
	public void Run()
	{
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
	 * Creates a generic MultiPass composite.
	 * 
	 * @param shell				The associated shell.
	 * @return					The newly created composite.
	 */
	private Composite MultiPassComposite(Shell shell)
	{
		// Create the temporary composite.
		Composite composite = new Composite(shell, SWT.NONE);
		
		// Create the layout for the composite.
		GridLayout compositeLayout = new GridLayout();
		compositeLayout.numColumns = 2;
		
		// Set the values needed on the composite.
		composite.setLayout(compositeLayout);
		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		
		return composite;
	}
	
	/**
	 * Creates a generic MultiPass button.
	 * 
	 * @param composite			The composite associated with this button.
	 * @param buttonText		The text for this button.
	 * @param horizontalIndent	The horizontal indent for this button.
	 * @param layout			The GridData layout associated with this button.
	 * 
	 * @return					The newly created button.
	 */
	private Button MultiPassButton(Composite composite, String buttonText, int horizontalIndent, GridData layout)
	{
		// Create the button.
		Button button = new Button(composite, SWT.PUSH);
		button.setText(buttonText);
		
		// Set the buttons indent and layout.
		layout.horizontalIndent = horizontalIndent;
		button.setLayoutData(layout);
		
		return button;
	}
	
	/**
	 * Adds the controller to this view.
	 * 
	 * @param tempcontroller	The MultiPass controller.
	 */
	public void AddController(MultiPassController tempcontroller)
	{
		this.controller = tempcontroller;
		
		// Add the controller to all buttons as the selection listener.
		answerOne.addSelectionListener(controller);
		answerTwo.addSelectionListener(controller);
		answerThree.addSelectionListener(controller);
		answerFour.addSelectionListener(controller);
		submit.addSelectionListener(controller);
	}
	
	/**
	 * Gets the file chosen by the user
	 * 
	 * @return				The string version of the path to the selected file.
	 */
	public String GetFile()
	{
		FileDialog dialog = new FileDialog(new Shell(display) , SWT.OPEN);
		dialog.setFilterExtensions(new String [] {"*.txt"});
		return dialog.open();
	}

	@Override
	/**
	 * Updates this view.
	 */
	public void update(Observable o, Object arg)
	{
		System.out.println("In the update function.");
		Question currentQuestion = (Question)arg;
		
		question.setText(currentQuestion.GetQuestion());
		question.getParent().layout();
		
		answerA.setText(currentQuestion.GetAnswerA());
		answerA.getParent().layout();
		
		answerB.setText(currentQuestion.GetAnswerB());
		answerB.getParent().layout();
		
		answerC.setText(currentQuestion.GetAnswerC());
		answerC.getParent().layout();
		
		answerD.setText(currentQuestion.GetAnswerD());
		answerD.getParent().layout();
		
		shell.pack();
	}
}
