
/**
 * Class to represent an answer in the MultiPass application.
 * 
 * @author John Garrison
 */
public class Question
{
	
	/**
	 * The current number of answers for this question.
	 */
	private int numOfAnswers;
	
	/**
	 * The max number of answers for each question.
	 */
	public final int MAX_ANSWERS = 4;
	
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
		answers = new Answer[MAX_ANSWERS];
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
		numOfAnswers = 0;
		
		for(Answer answer : answers)
		{
			this.AddAnswer(answer);
		}
		
		this.question = question;
	}
	
	/**
	 * Adds an answer to this question.
	 * 
	 * @param answer		The answer to add.
	 */
	public void AddAnswer(Answer answer)
	{
		if(numOfAnswers < MAX_ANSWERS)
		{
			this.answers[numOfAnswers++] = answer;
		}
		else
		{
			System.out.println("You are trying to add an answer to a question that already has 4! Stop it you jerk!");
		}
	}
	
}
