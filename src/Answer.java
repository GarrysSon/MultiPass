
public class Answer
{
	
	/**
	 * Tells if the answer is correct.
	 * 0 : Incorrect
	 * 1 : Correct
	 */
	public char correct;
	
	/**
	 * The answer associated with this Answer.
	 */
	public String answer;
	
	/**
	 * Empty Constructor.
	 */
	public Answer()
	{
		correct = '0';
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
