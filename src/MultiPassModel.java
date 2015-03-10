import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MultiPassModel extends java.util.Observable
{
	/**
	 * The index of the currently selected question.
	 */
	private int index;
	
	/**
	 * The total number of correctly answered questions.
	 */
	private int numCorrect;
	
	/**
	 * The total number of questions.
	 */
	private int totalQuestions;
	
	/**
	 * The list of questions.
	 */
	public ArrayList<Question> questions;
	
	/**
	 * The currently selected question.
	 */
	private Question currentQuestion;
	
	/**
	 * Empty constructor.
	 */
	public MultiPassModel()
	{
		index = 0;
		numCorrect = 0;
		totalQuestions = 0;
		questions = new ArrayList<Question>();
		currentQuestion = new Question();
	}
	
	/**
	 * Reads the questions from the file at the given path.
	 * 
	 * @param path		The location of the file from root.
	 * @throws IOException
	 */
	public void ReadQuestions(String path) throws IOException
	{
		String line = null;
		Question tempQuest;
		Answer tempAns;
		
		BufferedReader reader = Files.newBufferedReader(Paths.get(path));
		
		// Read in from the file line by line.
	    while((line = reader.readLine()) != null)
	    {
	    	tempQuest = new Question();
	    	tempQuest.SetQuestion(line);
	        
	        // Loop over the answers.
	        for(int i = 0; i < 4; i++)
	        {
	        	tempAns = new Answer();
	        	
	        	line = reader.readLine();
	        	
	        	if(line.startsWith("C"))
	        	{
	        		tempAns.answer = line.replace("C",  " ");
	        		tempAns.SetCorrect();
	        	}
	        	else
	        	{
	        		tempAns.answer = line;
	        	}
	        	
	        	tempQuest.AddAnswer(tempAns);
	        }
	        
	        // Add the question to the list of questions and then read in the empty line.
	        questions.add(tempQuest);
	        totalQuestions++;
	        line = reader.readLine();
	    }
	    
	    // Setting the initial question.
	    NextQuestion();
	}
	
	/**
	 * Sets the current question to the next question in the list.
	 */
	public void NextQuestion()
	{
		// Check to make sure there is another question.
		if(index < questions.size())
		{
			// Set to the next question and notify the observer.
			currentQuestion = questions.get(index++);
			setChanged();
			notifyObservers(currentQuestion);
		}
		else
		{
			// Notify the observer that the quiz is finished.
			System.out.println("Finished the quiz!");
			setChanged();
			notifyObservers(((float)numCorrect / totalQuestions) * 100);
		}
	}
	
	public void SetSelected(Choices answer)
	{
		// For loop to iterate over the questions.
		normal :
		for(Question question : questions)
		{
			// Test if the question is the current question.
			if(currentQuestion.equals(question))
			{
				// Set the selected answer as such.
				switch(answer)
				{
					case A:
						currentQuestion.SetAChosen();
						
						if(question.SetAChosen())
						{
							numCorrect++;
						}
						break;
					case B:
						currentQuestion.SetBChosen();
						
						if(question.SetBChosen())
						{
							numCorrect++;
						}
						break;
					case C:
						currentQuestion.SetCChosen();
						
						if(question.SetCChosen())
						{
							numCorrect++;
						}
						break;
					case D:
						currentQuestion.SetCChosen();
						
						if(question.SetDChosen())
						{
							numCorrect++;
						}
						break;
				}
				
				setChanged();
				notifyObservers(currentQuestion);
				
				break normal;
			}
		}
	}
}
