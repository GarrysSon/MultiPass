
/**
 * Class to represent an answer in the MultiPass application.
 * 
 * @author John Garrison
 */
public class Answer
{
	
	/**
	 * Tells if the answer is correct.
	 * 0 : Incorrect
	 * 1 : Correct
	 */
	private char correct;
	
	/**
	 * The setter for the correct field.
	 * 0 : Incorrect
	 * 1 : Correct
	 * 
	 * @param correct	The value to set correct to.
	 */
	public void SetCorrect(char correct)
	{
		if(correct == '0' || correct == '1')
		{
			this.correct = correct;
		}
		else
		{
			System.out.println("Correct can only be set to 0 (Incorrect) or 1 (Correct).");
		}
	}
	
	/**
	 * The answer associated with this Answer.
	 */
	public String answer;
	
	/**
	 * Constructor.
	 * 
	 * @param correct	Character to tell if this is the correct answer. 
	 * @param answer	The answer for this.
	 */
	public Answer(char correct, String answer)
	{
		this.correct = correct;
		this.answer = answer;
	}
	
	/**
	 * Tells whether this answer is correct.
	 * 
	 * @return	Whether this answer is correct.
	 */
	public boolean IsCorrect()
	{
		return correct == 1;
	}
	
}
