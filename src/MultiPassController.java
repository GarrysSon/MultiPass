import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class MultiPassController implements SelectionListener 
{
	/**
	 * The model associated with this controller.
	 */
	MultiPassModel model;
	
	/**
	 * The view associated with this controller.
	 */
	MultiPassView view;
	
	/**
	 * Adds the MultiPass model to this controller.
	 * 
	 * @param model		The model associated with this controller.
	 */
	public void AddModel(MultiPassModel model)
	{
		this.model = model;
	}
	
	/**
	 * Adds the MultiPas view to this controller.
	 * 
	 * @param view		The view associated with this controller.
	 */
	public void AddView(MultiPassView view)
	{
		this.view = view;
	}
	
	/**
	 * Initializes the model.
	 */
	public void InitModel()
	{
		try
		{
			model.ReadQuestions(view.GetFile());
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg)
	{
		// Pointless method as of right now.
	}

	@Override
	public void widgetSelected(SelectionEvent arg)
	{
		if(arg.getSource() == view.buttonA)
		{
			// Set all other buttons as not selected.
			view.buttonB.setSelection(false);
			view.buttonC.setSelection(false);
			view.buttonD.setSelection(false);
		}
		else if(arg.getSource() == view.buttonB)
		{
			// Set all other buttons as not selected.
			view.buttonA.setSelection(false);
			view.buttonC.setSelection(false);
			view.buttonD.setSelection(false);
		}
		else if(arg.getSource() == view.buttonC)
		{
			// Set all other buttons as not selected.
			view.buttonA.setSelection(false);
			view.buttonB.setSelection(false);
			view.buttonD.setSelection(false);
		}
		else if(arg.getSource() == view.buttonD)
		{
			// Set all other buttons as not selected.
			view.buttonA.setSelection(false);
			view.buttonB.setSelection(false);
			view.buttonC.setSelection(false);
		}
		else if(arg.getSource() == view.submit)
		{
			// Mark the selected answer as such.
			if(view.buttonA.getSelection())
			{
				
			}
			else if(view.buttonB.getSelection())
			{
				
			}
			else if(view.buttonC.getSelection())
			{
				
			}
			else if(view.buttonD.getSelection())
			{
				
			}
			
			// Toggle the submit and continue buttons.
			view.moveOn.setEnabled(true);
			view.submit.setEnabled(false);
		}
		else if(arg.getSource() == view.moveOn)
		{
			// Move to the next question.
			model.NextQuestion();
			
			// Toggle the submit and continue buttons.
			view.moveOn.setEnabled(false);
			view.submit.setEnabled(true);
		}
	}
}
