
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Scott Braaten
 */

/********************************************************** 
Program Name: Student.java
Programmer's Name: Scott Braaten
Program Description: This class handles storing the student information
* in its own class, as well as providing the methods that calculate
* the test averages and the letter grade.
***********************************************************/

public class Student {
    // properties
    private String name;
    private int[] scores;

    // constructors
    public Student() {
    }

    public Student(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
    
    // custom method to easily populate scores
    public void pushScores(int index, int score) {
        this.scores[index] = score;
    }
    
    // method that returns average of three test scores
    public double getAvg() {
        return (double) Arrays.stream(this.scores).reduce(0, (sub, el) -> sub + el) / scores.length;
    }
    
    // method that returns letter grade of average
    public String getLetterGrade() {
        if (this.getAvg() >= 90.0) {
            return "A";
        } else if (this.getAvg() >= 80.0) {
            return "B";
        } else if (this.getAvg() >= 70.0) {
            return "C";
        } else if (this.getAvg() >= 60.0) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // method displaying name of student by default
    @Override
    public String toString() {
        return this.name;
    }
}
