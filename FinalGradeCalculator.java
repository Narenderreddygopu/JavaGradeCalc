/*
	Name: Narender Reddy Gopu
	ID: 999901076
	Course Code: MCIS 5103
	Course Name: Advanced Programming Concepts
*/

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

class FinalGradeCalculator 
{
    	public static void main(String[] args) 
	{
        	BufferedReader bufferedReader = null;
        	ArrayList<String[]> gradeData = new ArrayList<>();
        
		//grade counts array to handle 5 grades
        	int[] gradeCount = new int[] { 0, 0, 0, 0, 0 };
        
		try 
		{
			//Requirement1:Ingesting student_grades_input.txt
            		//initialize buffered reader
            		bufferedReader = new BufferedReader(new FileReader("student_grades_input.txt"));
            
			//to skip the header
            		bufferedReader.readLine();
            
			//Convert data to list of string array
            		String line = null;
            
			//repeat until all lines are processed
            		while ((line = bufferedReader.readLine()) != null) 
			{
				//Requirement1:Comma delimited input line
                		String tokens[] = line.split(",");
                
				//Requirement2:Computing the final numerical grade for each student
                		double homework = 0.45 * (((Integer.parseInt(tokens[1]) + Integer.parseInt(tokens[2]) + Integer.parseInt(tokens[3])))/3);
                		double project = 0.25 * Integer.parseInt(tokens[5]);
		                double midFinal = 0.30 * (((Integer.parseInt(tokens[4]) + Integer.parseInt(tokens[6])))/2);
                		int final_numeric_grade = (int) (homework + project + midFinal);
                
				//Requirement3:Determining the final letter grade
				//calculate the letter grade and grade counts from A-F in 0-4 indices
                		char letter_grade = 'F';
                		if(final_numeric_grade >= 90) 
				{
                    			letter_grade = 'A';
                    			gradeCount[0]++;
                		} 
				else if(final_numeric_grade >= 80) 
				{
                    			letter_grade = 'B';
                    			gradeCount[1]++;
                		} 
				else if(final_numeric_grade >= 70) 
				{
                    			letter_grade = 'C';
                    			gradeCount[2]++;
                		} 
				else if(final_numeric_grade >= 60) 
				{
                    			letter_grade = 'D';
                    			gradeCount[3]++;
                		} 
				else 
				{
                    			gradeCount[4]++;
                		}
                		
				//Requirement5:GUI to display the final letter grade for each student
				// add array consisting name and grade to data
                		gradeData.add(new String[] { tokens[0], letter_grade + "" });
            		}
            		
			//Requirement4:GUI for display grades and counts
            		JFrame frame = new JFrame("Final Grades Calculator");
            		frame.setLayout(new BorderLayout());

            		JTable table = new JTable(gradeData.toArray(new String[0][0]), new String[] { "Name of Student", "Grade of Student" });
            		
			//Requirement4:Adding ScrollPane
			JScrollPane jsp = new JScrollPane(table);
            		frame.getContentPane().add(jsp);

			//Requirement5:Displaying Grade and its count
            		JLabel label = new JLabel("A:" + gradeCount[0] + " B:" + gradeCount[1] + " C:" + gradeCount[2] + " D:"
                    		+ gradeCount[3] + " F:" + gradeCount[4], SwingConstants.CENTER);
            		frame.getContentPane().add(label, BorderLayout.PAGE_END);

            		frame.setSize(400, 400);
            		frame.setVisible(true);
            		frame.setResizable(false);
            		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	} 
		catch (Exception e) 
		{
            		e.printStackTrace();
        	} 
		finally 
		{
            		if (bufferedReader != null) 
			{
                		try 
				{
                    			bufferedReader.close();
                		} 
				catch (Exception e) 
				{
                    			e.printStackTrace();
                		}
            		}
       		 }
    	}
}