//Written by Matthew Graham

import java.io.*;
import java.util.Scanner;
public class Student {//Instance variables
	public double labSum;
	public double labCount;
	public double labRSum;
	public double labRCount;
	public double hwSum;
	public double hwCount;
	public double exam01;
	public double exam02;
	public double finalExam;
	
	public Student()//Default constructor
	{
		this.labSum = 0.0;
		this.labCount = 0.0;
		this.labRSum = 0.0;
		this.labRCount = 0.0;
		this.hwSum = 0.0;
		this.hwCount = 0.0;
		this.exam01 = 0.0;
		this.exam02 = 0.0;
		this.finalExam = 0.0;
	}
	//Computes Averages
	public double getLabAverage()
	{
		return this.labSum/this.labCount;
	}
	public double getLabReportAverage()
	{
		return this.labRSum/this.labRCount;
	}
	public double getHomeworkAverage()
	{
		return this.hwSum/this.hwCount;
	}
	public double getExam01()
	{
		return exam01;
	}
	public double getExam02()
	{
		return exam02;
	}
	public double getFinal()
	{
		return finalExam;
	}
	public void addGrade(String type, double grade)//Adds grades to certain sections
	{
		if(type.equals(SectionType.LABS)) 
		{
			this.labSum += grade;
			this.labCount++;
		}
		if(type.equals(SectionType.LAB_REPORTS))
		{
			this.labRSum += grade;
			this.labRCount++;
		}
		if(type.equals(SectionType.HOMEWORK))
		{
			this.hwSum += grade;
			this.hwCount++;
		}
		if(type.equals(SectionType.EXAM01))
		{
			this.exam01 = grade;
		}
		if(type.equals(SectionType.EXAM02))
		{
			this.exam02 = grade;
		}
		if(type.equals(SectionType.FINAL))
		{
			this.finalExam = grade;
		}
	}
	public double getGradeNumeric()//Gives the final grade number value
	{
		double grade = 0.0;
		grade = this.getLabAverage()*0.1+this.getLabReportAverage()*0.1+this.getHomeworkAverage()*0.2;
		//Find first and second exam scores
		if(this.getExam01() >= this.getExam02() && this.getFinal() >= this.getExam02())
			grade += this.getExam01()*0.3+this.getFinal()*0.3;
		else if(this.getExam02() >= this.getExam01() && this.getFinal() >= this.getExam01())
			grade += this.getExam02()*0.3+this.getFinal()*0.3;
		else
			grade += this.getExam01()*0.3+this.getExam02()*0.3;
		return grade;		
	}
	public double getGradeRounded()//Rounds the grade up 
	{
		return Math.ceil(this.getGradeNumeric());	
	}
	public String getGradeLetter()//Gives a letter grade according to final grade number
	{
		double grade = this.getGradeRounded();
		if(grade >= 90)
			return "A";
		else if(grade >= 85)
			return "B+";
		else if(grade >= 80)
			return "B";
		else if(grade >= 75)
			return "C+";
		else if(grade >= 70)
			return "C";
		else if(grade >= 65)
			return "D+";
		else if(grade >= 60)
			return "D";
		else
			return "F";
	}
	public void readGradeFile(String fileName)//Reads and computes the .txt file
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			String currSec = "";
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				if(fileLine.equals(SectionType.LABS))
					currSec = SectionType.LABS;
				else if(fileLine.equals(SectionType.LAB_REPORTS))
					currSec = SectionType.LAB_REPORTS;
				else if(fileLine.equals(SectionType.HOMEWORK))
					currSec = SectionType.HOMEWORK;
				else if(fileLine.equals(SectionType.EXAM01))
					currSec = SectionType.EXAM01;
				else if(fileLine.equals(SectionType.EXAM02))
					currSec = SectionType.EXAM02;
				else if(fileLine.equals(SectionType.FINAL))
					currSec = SectionType.FINAL;
				else
					this.addGrade(currSec, Double.parseDouble(fileLine));				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String toString()//prints the String
	{
		return "Lab Average: "+this.getLabAverage()+"\nLab Report Average: "+this.getLabReportAverage()
		+"\nHomework Average: "+this.getHomeworkAverage()+"\nExam 01: "+this.getExam01()
		+"\nExam 02: "+this.getExam02()+"\nFinal Exam: "+this.getFinal()+"\nRaw Total: "
		+this.getGradeNumeric()+"\nAdjusted: "+this.getGradeRounded()+"\nGrade: "+this.getGradeLetter();				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
