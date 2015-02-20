
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
	 * Sets this answer to be correct.
	 */
	public void SetCorrect()
	{
		this.correct = 1;
	}
	
	/**
	 * Sets this answer to be incorrect.
	 */
	public void SetIncorrect()
	{
		this.correct = 0;
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
