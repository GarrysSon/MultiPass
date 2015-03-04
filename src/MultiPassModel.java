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
		if(index < questions.size())
		{
			currentQuestion = questions.get(index++);
			setChanged();
			notifyObservers(currentQuestion);
		}
		else
		{
			System.out.println("Finished the quiz!");
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
						question.SetAChosen();
						break;
					case B:
						question.SetBChosen();
						break;
					case C:
						question.SetCChosen();
						break;
					case D:
						question.SetDChosen();
						break;
				}
				
				break normal;
			}
		}
	}
}
