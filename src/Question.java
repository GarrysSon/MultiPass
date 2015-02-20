
/**
 * Class to represent an answer in the MultiPass application.
 * 
 * @author John Garrison
 */
public class Question
{
	
	/**
	 * The number of answers for each question.
	 */
	public final int NUM_OF_ANSWERS = 4;
	
	/**
	 * The question associated with this Question.
	 */
	public String question;
	
	/**
	 * The array of answers associated with this Question.
	 */
	public Answer[] answers;
	
	/**
	 * Empty constructor.
	 */
	public Question()
	{
		answers = new Answer[NUM_OF_ANSWERS];
		question = "";
	}
	
	/**
	 * Constructor.
	 * 
	 * @param answers		The answers for this.
	 * @param question		The question for this.
	 */
	public Question(Answer[] answers, String question)
	{
		this.answers = answers;
		this.question = question;
	}
	
}
