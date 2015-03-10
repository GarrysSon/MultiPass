
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
	 * Boolean to tell if the user has chosen an answer.
	 */
	public Boolean chose;
	
	/**
	 * The chosen answer.
	 */
	public Choices choice;
	
	/**
	 * Empty constructor.
	 */
	public Question()
	{
		answers = new Answer[MAX_ANSWERS];
		question = "";
		chose = false;
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
	 * Sets the question for this Question.
	 * 
	 * @param question	The question to for this Question.
	 */
	public void SetQuestion(String question)
	{
		this.question = question;
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
	 * Sets answer A as chosen.
	 */
	public Boolean SetAChosen()
	{
		choice = Choices.A;
		answers[0].SetChosen();
		chose = true;
		
		return answers[0].IsCorrect();
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
	 * Sets answer B as chosen.
	 */
	public Boolean SetBChosen()
	{
		choice = Choices.B;
		answers[1].SetChosen();
		chose = true;
		
		return answers[1].IsCorrect();
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
	 * Sets answer C as chosen.
	 */
	public Boolean SetCChosen()
	{
		choice = Choices.C;
		answers[2].SetChosen();
		chose = true;
		
		return answers[2].IsCorrect();
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
	
	/**
	 * Sets answer D as chosen.
	 */
	public Boolean SetDChosen()
	{
		choice = Choices.D;
		answers[3].SetChosen();
		chose = true;
		
		return answers[3].IsCorrect();
	}
	
}
