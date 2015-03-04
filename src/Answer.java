
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
	 * Tells if the answer was chosen.
	 * 0 : Not chosen
	 * 1 : Chosen
	 */
	private char chosen;
	
	/**
	 * The answer associated with this Answer.
	 */
	public String answer;
	
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
	 * Sets this answer to be the chosen answer.
	 */
	public void SetChosen()
	{
		chosen = '1';
	}
	
	/**
	 * Tells whether this answer is the chosen answer.
	 * 
	 * @return Whether this answer is the chosen answer.
	 */
	public boolean IsChosen()
	{
		return chosen == 1;
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
	
	/**
	 * Empty constructor.
	 */
	public Answer()
	{
		correct = '0';
		chosen = '0';
		answer = "";
	}
	
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
	
}
