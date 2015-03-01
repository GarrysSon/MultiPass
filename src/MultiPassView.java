import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import java.util.ArrayList;

public class MultiPassView
{
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
