
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
	private String question;
	
	/**
	 * The array of answers associated with this Question.
	 */
	private Answer[] answers;
	
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
	
	/**
	 * Gets the question for this Question.
	 * 
	 * @return		This question.
	 */
	public String GetQuestion()
	{
		return question;
	}
	
	/**
	 * Gets all the answers for this Question.
	 * 
	 * @return		The array of Answers.
	 */
	public Answer[] GetAllAnswers()
	{
		return answers;
	}
	
	/**
	 * Gets answer A for this Question.
	 * 
	 * @return		The answer A.
	 */
	public String GetAnswerA()
	{
		return answers[0].answer;
	}
	
	/**
	 * Gets answer B for this Question.
	 * 
	 * @return		The answer B.
	 */
	public String GetAnswerB()
	{
		return answers[1].answer;
	}
	
	/**
	 * Gets answer C for this Question.
	 * 
	 * @return		The answer C.
	 */
	public String GetAnswerC()
	{
		return answers[2].answer;
	}
	
	/**
	 * Gets answer D for this Question.
	 * 
	 * @return		The answer D.
	 */
	public String GetAnswerD()
	{
		return answers[3].answer;
	}
	
}
