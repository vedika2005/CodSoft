import java.util.*;


public class QuizApp {
    
    static String[][] quizData = {
            {"What is the chemical symbol for gold?", "Au", "Ag", "Pb", "Fe", "1"},
            {"Which element has the atomic number 1?", "Oxygen", "Hydrogen", "Carbon", "Nitrogen", "2"},
            {"What is the hardest natural substance on Earth?", "Gold", "Diamond", "Iron", "Platinum", "2"}
    };

    static int score = 0; 
    static boolean timeUp = false; 
    static String[] resultSummary = new String[quizData.length]; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---WELCOME TO QUIZE!!! ANSWER THE QUESTIONS BEFORE TIMER RUNS OUT---");

        for (int i = 0; i < quizData.length; i++) {
            String question = quizData[i][0];
            String option1 = quizData[i][1];
            String option2 = quizData[i][2];
            String option3 = quizData[i][3];
            String option4 = quizData[i][4];
            String correctAnswer = quizData[i][5];

            
            System.out.println("\nQuestion " + (i + 1) + ": " + question);
            System.out.println("1. " + option1);
            System.out.println("2. " + option2);
            System.out.println("3. " + option3);
            System.out.println("4. " + option4);

            
            Timer timer = new Timer();
            timeUp = false;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up! Moving to the next question...");
                    synchronized (scanner) {
                        scanner.notify();
                    }
                }
            }, 10000); 

            
            int userAnswer = 0;
            synchronized (scanner) {
                while (!timeUp && userAnswer == 0) {
                    System.out.print("Your answer (1-4): ");
                    try {
                        if (scanner.hasNextInt()) {
                            userAnswer = scanner.nextInt();
                            if (userAnswer >= 1 && userAnswer <= 4) {
                                break;
                            } else {
                                System.out.println("Please enter a valid option (1-4).");
                                userAnswer = 0;
                            }
                        } else {
                            scanner.next(); 
                            System.out.println("Please enter a valid option (1-4).");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
            timer.cancel();

            // Check the answer and update score
            if (!timeUp && String.valueOf(userAnswer).equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
                resultSummary[i] = "Question " + (i + 1) + ": Correct";
            } else if (!timeUp) {
                System.out.println("Incorrect! The correct answer was: " + correctAnswer);
                resultSummary[i] = "Question " + (i + 1) + ": Incorrect";
            } else {
                resultSummary[i] = "Question " + (i + 1) + ": Timed Out";
            }
        }

       
        System.out.println("\nQUIZE OVER!");
        System.out.println("Your final score: " + score + "/" + quizData.length);
        System.out.println("\nSummary:");
        for (String result : resultSummary) {
            System.out.println(result);
        }

      
        if (score == quizData.length) {
            System.out.println("\nOutstanding! You answered every question correctly! You're a genius!");
        } else if (score == quizData.length - 1) {
            System.out.println("\nExcellent! You almost got them all right! Keep up the great work!");
        } else if (score >= quizData.length / 2) {
            System.out.println("\nWell done! You scored more than half of the questions correctly. Keep going!");
        } else {
            System.out.println("\nDon't worry! Every quiz is a learning opportunity. Keep practicing, and you'll do better next time!");
        }

        scanner.close();
    }
}
