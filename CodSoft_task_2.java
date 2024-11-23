import java.util.Scanner;
 class Student_Grade_Calculator
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		System.out.print(" Enter the total number of your subject:");
		int numSubjects=sc.nextInt();
		int marks[]=new int[numSubjects];
		int totalMarks=0;

		 for(int i=0;i<numSubjects;i++)
		 {
		 	System.out.println("Enter marks obtained in subject"+(i+1)+"(out of 100):");
		 	marks[i]=sc.nextInt();
		 	totalMarks+=marks[i];
		 }
		 double averagePercentage=(double)totalMarks/numSubjects;

		 String grade;
		 if(averagePercentage>=90)
		 {
		 	grade="A+";
		 	
		 }
		 else if(averagePercentage>=80)
		 {
		 	grade="A";
		 	

		 }
		 else if(averagePercentage>=70)
		 {
		 	grade="B";

		 }
		 else if(averagePercentage>=60)
		 {
		 grade="C";
		  }
		  else if(averagePercentage>=50)
		  {
		  grade="D";
		  }
		  else
		  {
		  	grade="F";

		  }
		  System.out.println("---HERE IS YOUR RESULT---");
		  System.out.println("TOTAL MARKS:"+totalMarks);
		  System.out.println("AVERAGE PERCENTAGES:"+averagePercentage+"%");
		  System.out.println("GRADE:"+grade);
		  if (!grade.equals("F")) {
            System.out.println("\nCongratulations! You have done a great job. ");
        } else {
            System.out.println("\nDon't lose hope! Keep working hard and you'll improve.");
        }
		  sc.close();
		



	}
}