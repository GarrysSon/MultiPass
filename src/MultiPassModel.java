import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MultiPassModel
{
	/**
	 * The list of questions.
	 */
	ArrayList<Question> questions = new ArrayList<Question>();
	
	/**
	 * Reads the questions from the file at the given path.
	 * 
	 * @param path			The location of the file from root.
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
	    	tempQuest.question = line;
	        
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
	}
}
