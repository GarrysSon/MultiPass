import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
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
	 * The composite for the question.
	 */
	private Composite questionComposite;
	
	/**
	 * The grid data for the question.
	 */
	private GridData questionData;
	
	/**
	 * The buttons for MultiPass.
	 */
	public Button buttonA, buttonB, buttonC, buttonD, submit, moveOn;
	
	/**
	 * The answers for MultiPass.
	 */
	public Label answerA, answerB, answerC, answerD;
	
	/**
	 * The Shell associated with this view.
	 */
	private Shell shell;
	
	/**
	 * The Display associated with this view.
	 */
	private Display display;
	
	/**
	 * The composite for the answers.
	 */
	private Composite answerComposite;
	
	/**
	 * The grid data for the answers.
	 */
	private GridData answerData;
	
	/**
	 * The composite for the submit/continue buttons.
	 */
	private Composite submitComposite;
	
	/**
	 * The grid data for the submit/continue buttons.
	 */
	private GridData submitData;
	
	/**
	 * Empty constructor.
	 */
	public MultiPassView()
	{
		// Creating the display.
		display = new Display();
		shell = CreateShell();
	}
	
	/**
	 * Creates the shell for MultiPass view.
	 * 
	 * @param display		The display associated with the shell.
	 * @return				The shell for the MultiPass view.
	 */
	private Shell CreateShell()
	{
		/*	Shell  */
		Shell shell = new Shell(display);
		shell.setText("MultiPass");
		shell.setMinimumSize(450, 275);
		shell.setLocation(GetCenter(shell));
		shell.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		
		GridLayout shellLayout = new GridLayout();
		shellLayout.numColumns = 1;
		shellLayout.makeColumnsEqualWidth = true;
		shell.setLayout(shellLayout);
		/*	End of Shell  */
		
		/*	Question.  */
		questionComposite = new Composite(shell, SWT.NONE);
		question = new Label(questionComposite, SWT.WRAP);
		
		questionData = new GridData(SWT.NONE, SWT.NONE, false, false);
		
		questionComposite.setLayout(new GridLayout());
		questionComposite.setLayoutData(questionData);
		questionComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		/*	End of Question  */
		
		/*	Answers  */
		// Making the composite for the answers area.
		answerComposite = new Composite(shell, SWT.BORDER);
		GridLayout answerLayout = new GridLayout();
		answerLayout.numColumns = 3;
		answerLayout.makeColumnsEqualWidth = false;
		
		answerData = new GridData(SWT.FILL, SWT.DEFAULT, true, true);
		
		answerComposite.setLayout(answerLayout);
		answerComposite.setLayoutData(answerData);
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
		buttonA = AnswerButton(buttonsComposite, "A", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerA = new Label(buttonsComposite, SWT.NONE);
		answerA.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Answer B.
		buttonB = AnswerButton(buttonsComposite, "B", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerB = new Label(buttonsComposite, SWT.NONE);
		answerB.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Answer C.
		buttonC = AnswerButton(buttonsComposite, "C", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerC = new Label(buttonsComposite, SWT.NONE);
		answerC.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Answer D.
		buttonD = AnswerButton(buttonsComposite, "D", 10, new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
		answerD = new Label(buttonsComposite, SWT.NONE);
		answerD.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, false));
		
		// Empty end label to center the buttons.
		Label emptyEnd = CenterLabel(answerComposite);
		/*	End of Answers.  */
		
		/*	Submit and Continue.  */
		// Making the save/continue composite.
		submitComposite = new Composite(shell, SWT.NONE);
		GridLayout submitLayout = new GridLayout();
		submitLayout.numColumns = 3;
		submitLayout.makeColumnsEqualWidth = false;
		
		submitData = new GridData(SWT.FILL, SWT.DEFAULT, true, false);
		
		submitComposite.setLayout(submitLayout);
		submitComposite.setLayoutData(submitData);
		submitComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		// End of save/continue composite.
		
		// Empty begin label to right align the buttons.
		Label beginEmpty = CenterLabel(submitComposite);
		
		// Submit and Continue buttons.
		submit = SubmitButton(submitComposite, "Submit", new GridData(GridData.END, GridData.END, false, false));
		submit.setEnabled(false);
		moveOn = SubmitButton(submitComposite, "Continue", new GridData(GridData.END, GridData.END, false, false));
		moveOn.setEnabled(false);
		/*	End of Submit and Continue  */
		
		shell.pack();
		return shell;
	}
	
	/**
	 * Shows the results of the quiz.
	 */
	private void ShowResults(float result)
	{
		// Hide the question.
		questionData.exclude = !questionData.exclude;
		questionComposite.setVisible(!questionData.exclude);
		questionComposite.getParent().pack();
        
        // Hide the submit/continue buttons.
        submitData.exclude = !submitData.exclude;
        submitComposite.setVisible(!submitData.exclude);
        submitComposite.getParent().pack();
        
        for(Control control : answerComposite.getChildren())
        {
        	control.dispose();
        }
      		
        /*	Results  */
        // Empty begin label to center the results.
 		Label emptBegin = CenterLabel(answerComposite);
 		
 		// Center composite for results label.
 		Composite resultsComposite = new Composite(answerComposite, SWT.NONE);
 		GridLayout resultLayout = new GridLayout();
 		resultLayout.numColumns = 1;
 		resultLayout.makeColumnsEqualWidth = false;
 		
 		resultsComposite.setLayout(resultLayout);
 		resultsComposite.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, false, true));
 		resultsComposite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
 		
 		// The label for the results.
 		Label resultsLabel = new Label(resultsComposite, SWT.NONE);
 		resultsLabel.setText(String.format("Results: %3.2f%%", result));
 		resultsLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
 		
 		// Empty end label to center the results.
 		Label emptEnd = CenterLabel(answerComposite);
 		answerComposite.layout();
		/*	End of Results  */
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
	 * Creates a MultiPass answer button.
	 * 
	 * @param composite			The composite associated with this button.
	 * @param buttonText		The text for this button.
	 * @param horizontalIndent	The horizontal indent for this button.
	 * @param layout			The GridData layout associated with this button.
	 * 
	 * @return					The newly created button.
	 */
	private Button AnswerButton(Composite composite, String buttonText, int horizontalIndent, GridData layout)
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
	 * Creates a MultiPass submit button.
	 * 
	 * @param composite			The composite associated with this button.
	 * @param buttonText		The text for this button.
	 * @param layout			The GridData layout associated with this button.
	 * 
	 * @return					The newly created button.
	 */
	private Button SubmitButton(Composite composite, String buttonText, GridData layout)
	{
		// Create the button and set its layout.
		Button button = new Button(composite, SWT.PUSH);
		button.setText(buttonText);
		button.setLayoutData(layout);
		
		return button;
	}
	
	/**
	 * Resets the buttons to their default visual states.
	 */
	public void ResetUI()
	{
		// Reset answer A button and text.
		if(!answerA.isDisposed() && !buttonA.isDisposed())
		{
			answerA.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			buttonA.setSelection(false);
			buttonA.setEnabled(true);
		}
		
		// Reset answer B button and text.
		if(!answerB.isDisposed() && !buttonB.isDisposed())
		{
			answerB.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			buttonB.setSelection(false);
			buttonB.setEnabled(true);
		}
		
		// Reset answer C button and text.
		if(!answerC.isDisposed() && !buttonC.isDisposed())
		{
			answerC.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			buttonC.setSelection(false);
			buttonC.setEnabled(true);
		}
		
		// Reset answer D button and text.
		if(!answerD.isDisposed() && !buttonD.isDisposed())
		{
			answerD.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
			buttonD.setSelection(false);
			buttonD.setEnabled(true);
		}
		
		shell.layout(true, true);
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
		moveOn.addSelectionListener(controller);
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
		
		if(arg instanceof Question)
		{
			Question currentQuestion = (Question)arg;
			
			// Test if the user has selected an answer.
			if(currentQuestion.chose)
			{
				// Set the chosen button as wrong.
				switch(currentQuestion.choice)
				{
					case A:
						answerA.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
						break;
					case B:
						answerB.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
						break;
					case C:
						answerC.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
						break;
					case D:
						answerD.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
						break;
				}
				
				Answer[] answers = currentQuestion.GetAllAnswers();
				
				// Set the correct answer as right.
				if(answers[0].IsCorrect())
				{
					answerA.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
				}
				else if(answers[1].IsCorrect())
				{
					answerB.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
				}
				else if(answers[2].IsCorrect())
				{
					answerC.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
				}
				else if(answers[3].IsCorrect())
				{
					answerD.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
				}
			}
			else
			{
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
			}
			
			shell.pack();
		}
		else if(arg instanceof Float)
		{
			ShowResults((float)arg);
		}
	}
}
