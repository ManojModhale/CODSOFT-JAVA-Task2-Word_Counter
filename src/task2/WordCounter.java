package task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter 
{
	public void count()
	{
		
	}
	
	public static String readFile(String filePath)
	{
		StringBuilder content=new StringBuilder();
		try 
		{			
			FileReader fr=new FileReader(filePath);
			BufferedReader reader=new BufferedReader(fr);
			
			String pline;
			while((pline=reader.readLine())!=null)
			{
				content.append(pline).append("\n");
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return content.toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter '1' to input text\t'2' to provide a file");
		int choice=sc.nextInt();
		sc.nextLine();
		
		String inputText = null;
		if(choice==1)
		{
			System.out.println("Enter your text : ");
			inputText=sc.nextLine();
		}
		else if(choice==2)
		{
			System.out.println("Enter File Name with Full path : ");
			String filePath=sc.nextLine();
			inputText=readFile(filePath);
			
		}
		else
		{
			System.out.println("Invalid Choice. Exiting");
		}
		
		String[] words=inputText.split("[\\s\\p{Punct}]+");		
		int wordCount=0;
		
		for (String word : words) 
		{
			if(!word.isEmpty())
			{
				wordCount++;
			}
		}
		
		System.out.println("Total Word Count = "+wordCount);
		sc.close();
	}

}
