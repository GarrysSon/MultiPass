import java.io.IOException;

public class MultiPassController
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
	 * Empty constructor.
	 */
	public MultiPassController()
	{
		model = new MultiPassModel();
		view = new MultiPassView();
	}
	
	/**
	 * Runs this controller.
	 * 
	 * @throws IOException
	 */
	public void Run() throws IOException
	{
		//model.ReadQuestions(view.GetFile());
	    //view.PrintQuestions(model.questions);
	}
}
