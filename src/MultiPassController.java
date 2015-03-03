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
		if(arg.getSource() == view.answerOne)
		{
			// Set the selected answer as answer one.
		}
		else if(arg.getSource() == view.answerTwo)
		{
			// Set the selected answer as answer two.
		}
		else if(arg.getSource() == view.answerThree)
		{
			// Set the selected answer as answer three.
		}
		else if(arg.getSource() == view.answerFour)
		{
			// Set the selected answer as answer four.
		}
		else if(arg.getSource() == view.submit)
		{
			model.NextQuestion();
		}
	}
}
