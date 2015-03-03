
public class Main
{
	/**
	 * The model for MultiPass.
	 */
	public static MultiPassModel model;
	
	/**
	 * The view for MultiPass.
	 */
	public static MultiPassView view;
	
	/**
	 * The controller for MultiPass.
	 */
	public static MultiPassController controller;
	
	/**
	 * Main method.
	 * 
	 * @param args		Arguments passed in from command line.
	 */
	public static void main(String[] args)
	{
		// Initialize the model and view.
		model = new MultiPassModel();
		view = new MultiPassView();
		
		// Add the view as the model's observer.
		model.addObserver(view);
		
		// Initialize the controller and set the model and view.
		controller = new MultiPassController();
		controller.AddModel(model);
		controller.AddView(view);
		controller.InitModel();
		
		// Add the controller to the view and run the program.
		view.AddController(controller);
		view.Run();
	}
	
}
