package main.Class.Conversations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ConversationWithHarun implements Conversation {
	private Scanner scanner;
	private String ask = "";
	private String name ="NPC Harun";

	private Map<Integer, String> questionList;
	private Map<Integer, String> firstQuestionList;
	private Map<Integer, String> secondQuestionList;
	private Map<Integer, String> thirdQuestionList;

	@Override
	public void talk() {
		
		loadQuestion();
		showQuestion(questionList);
		this.scanner = new Scanner(System.in);
		
		
		while (!ask.equals("4")) {
			ask=scanner.nextLine();
			System.out.println(">"+ask);
			choiseQuestion(ask);
		}

	}

	private void loadQuestion() {
		questionList = new HashMap<>();
		firstQuestionList = new HashMap<>();
		firstQuestionList.put(1, "ala ma kota");
		firstQuestionList.put(2, "a kot ale");
		firstQuestionList.put(3, "Cos tam");
		//firstQuestionList.put(4, "return");

		secondQuestionList = new HashMap<>();
		secondQuestionList.put(1, "yoy");
		secondQuestionList.put(2, "yoyo1");
		secondQuestionList.put(3, "yooy2");
		//secondQuestionList.put(4, "return");
		
		thirdQuestionList = new HashMap<>();
		thirdQuestionList.put(1, "xoxox1");
		thirdQuestionList.put(2, "xoxox2");
		thirdQuestionList.put(3, "xoxox3");
		//thirdQuestionList.put(4, "return");
		
		questionList.put(1,"first question");
		questionList.put(2,"second question");
		questionList.put(3,"third question");
		questionList.put(4,"bye");

	}

	public void showQuestion( Map<Integer, String> question) {
		
		int number = 1;
		StringBuilder builder = new StringBuilder();
		builder.append(this.name +"> Whot you need? \n");
		
		for(Map.Entry subject : question.entrySet()){
			builder.append(number++ +". "+ subject.getValue() + "\n");
			//builder.append(subject.getValue()+"\n");
		}
		
		
		System.out.println(builder.toString());
	}
	
	
	public void choiseQuestion(String ask2){
		if(ask2.equals("1"))showQuestion(firstQuestionList);
		if(ask2.equals("2"))showQuestion(secondQuestionList);
		if(ask2.equals("4"))showQuestion(thirdQuestionList);
	}

}
