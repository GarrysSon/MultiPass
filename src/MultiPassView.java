import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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
	public Button buttonA, buttonB, buttonC, buttonD, submit;
	
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
		/*	Shell  */
		final Shell shell = new Shell(display);
		shell.setText("MultiPass");
		shell.setMinimumSize(450, 250);
		shell.setLocation(GetCenter(shell));
		shell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		
		GridLayout shellLayout = new GridLayout();
		shellLayout.numColumns = 1;
		shellLayout.makeColumnsEqualWidth = true;
		shell.setLayout(shellLayout);
		/*	End of Shell  */
		
		/*	Question.  */
		question = new Label(shell, SWT.WRAP);
		
		/*	Answers  */
		// Making the composite for the answers area.
		Composite answerComposite = new Composite(shell, SWT.BORDER);
		GridLayout answerLayout = new GridLayout();
		answerLayout.numColumns = 3;
		answerLayout.makeColumnsEqualWidth = false;
		
		answerComposite.setLayout(answerLayout);
		answerComposite.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, true));
		answerComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		// End answer area composite.
		
		// Empty beginning label to center the buttons.
		Label emptyBegin = CenterLabel(answerComposite);
		
		// Making the composite for all the buttons and answers.
		Composite buttonsComposite = new Composite(answerComposite, SWT.NONE);
		GridLayout buttonsLayout = new GridLayout();
		buttonsLayout.numColumns = 2;
		buttonsLayout.makeColumnsEqualWidth = true;
		
		buttonsComposite.setLayout(buttonsLayout);
		buttonsComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		// End button and answer composite.
		
		// Answer A.
		buttonA = MultiPassButton(buttonsComposite, "A", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerA = new Label(buttonsComposite, SWT.NONE);
		answerA.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Answer B.
		buttonB = MultiPassButton(buttonsComposite, "B", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerB = new Label(buttonsComposite, SWT.NONE);
		answerB.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Answer C.
		buttonC = MultiPassButton(buttonsComposite, "C", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerC = new Label(buttonsComposite, SWT.NONE);
		answerC.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Answer D.
		buttonD = MultiPassButton(buttonsComposite, "D", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerD = new Label(buttonsComposite, SWT.NONE);
		answerD.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Empty end label to center the buttons.
		Label emptyEnd = CenterLabel(answerComposite);
		/*	End of Answers.  */
		
		/*	Submit button.  */
		submit = MultiPassButton(shell, "Submit", 50, new GridData(GridData.END, GridData.END, false, true));
		
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
	 * Creates an empty label to help center widgets.
	 * 
	 * @param composite			The composite of the label.
	 * @return					The empty label.
	 */
	private Label CenterLabel(Composite composite)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, true));
		return label;
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
		Button button = new Button(composite, SWT.TOGGLE);
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
		buttonA.addSelectionListener(controller);
		buttonB.addSelectionListener(controller);
		buttonC.addSelectionListener(controller);
		buttonD.addSelectionListener(controller);
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
	
	/**
	 * Gets the location for the shell centered.
	 * 
	 * @param shell			The shell to center.
	 * @return				The location where the shell is to be centered.
	 */
	private Point GetCenter(Shell shell)
	{
		// Get the rects for the display and the shell.
	    Rectangle bounds = Display.getCurrent().getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    // Get the x and y position for the new location.
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    // Return the new point.
	    return new Point(x, y);
	}

	@Override
	/**
	 * Updates this view.
	 */
	public void update(Observable o, Object arg)
	{
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
