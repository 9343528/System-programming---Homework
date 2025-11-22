//אנה סספורטה 337664932
//איוב 326305398

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner; 

public class Files {
	
	public static long parseID(String line) { //פונקצייץ עזר לניתוח שורה והוצאת מספר תז
		try (Scanner lineScanner = new Scanner(line)) {
	    	String idStr = lineScanner.next();
	    	lineScanner.close();
	    	return Long.parseLong(idStr.trim());
	        
	    } catch (Exception e) {
	        System.err.println("ID number incorrect ");
	        throw new RuntimeException("ID error", e);
	    }
	}
	
	
	public static void writeLine(String studentLine, String gradesLine, FileWriter writer) 
	        throws IOException, NumberFormatException {
	    
	    String studentID = "";
	    String studentName = ""; // הערה: קריאת השם המלא תדרוש קצת התאמה!
	    double averageScore = 0.0;

	    try (Scanner studentScanner = new Scanner(studentLine)) {
	        studentID = studentScanner.next(); //קורא תז
	        studentName = studentScanner.nextLine().trim(); //קורא עד סוף השורה - כלומר שם מלא
	        studentScanner.close();
	    }

	    try (Scanner gradesScanner = new Scanner(gradesLine)) {
	        gradesScanner.next(); //קורא תז ומדלג עליו
	        
	        double score1 = gradesScanner.nextDouble(); //קראית ציון - ישר בדאבל, כהה החלוקה תהיה מדוייקת
	        double score2 = gradesScanner.nextDouble(); // קורא ציון הבא
	        averageScore = (score1 + score2) / 2.0; //חישוב ממוצע
	        gradesScanner.close();
	    }
	    String outputLine = studentID + " " + 
	                        studentName + " " +       
	                        String.format("%.2f", averageScore); //מחברים את התשובה בשביל "להדביק" בקובץ

	    writer.write(outputLine + "\n");
	}


	public static void main(String[] args) {
		try {
		File studentsData = new File ("Students.txt");
		File javaCourseGrades = new File ("Java course grades.txt");
		
		if (!studentsData.exists() || !studentsData.canRead() || studentsData.length() == 0) 
			throw new IOException("Student's data file is empty/not exist/not readable");
	        
	    if (!javaCourseGrades.exists() || !javaCourseGrades.canRead() || javaCourseGrades.length() == 0) 
	    		throw new IOException("Course grades file is empty/not exist/not readable");
	       
	    
		File report = new File("report.txt");
		
	    if (!report.createNewFile())           // Try to create the file
	    	  	throw new IOException("Cannot create the report file");

		       
		Scanner scanStudents = new Scanner(studentsData);
		Scanner scanGrades = new Scanner(javaCourseGrades);
		FileWriter myWriter = new FileWriter("report.txt", true); 
		
		// נניח שיצרת והגדרת את scanStudents ו-scanGrades
		String studentLine = scanStudents.hasNextLine() ? scanStudents.nextLine() : null;
		String gradesLine = scanGrades.hasNextLine() ? scanGrades.nextLine() : null;
		
		while (studentLine != null && gradesLine != null) {

			long studentIDNum = parseID(studentLine); //פונקציה מחזירה רק מספר תז בצורת long
			long gradesIDNum = parseID(gradesLine);
			if (studentIDNum < gradesIDNum)//אם תז מקובץ אחד שונה משני -מתקדמים לשורה הבאה באחד הקבצים
				studentLine = scanStudents.hasNextLine() ? scanStudents.nextLine() : null;
			else if (studentIDNum > gradesIDNum)
				gradesLine = scanGrades.hasNextLine() ? scanGrades.nextLine() : null;
			else { //אם אותו תז מופיע פעמיים בשני הקבצים
				writeLine(studentLine, gradesLine, myWriter); //קורא לפונקציית עזר לכתיבה בקובץ מיזוג
				studentLine = scanStudents.hasNextLine() ? scanStudents.nextLine() : null;
				gradesLine = scanGrades.hasNextLine() ? scanGrades.nextLine() : null;

			}
		}
		        
			   
		myWriter.close();	    
		scanGrades.close();	    
		scanStudents.close();
		System.out.println("Report file created!");
		}
		catch (IOException e) {
	      e.printStackTrace();	
	}



}
}
