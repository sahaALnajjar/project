package com.example.android.myproject.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.myproject.R;

import java.text.MessageFormat;
import java.util.Random;

public class BeginnerQuizActivity extends AppCompatActivity {


    //  make changes in here change the class name , methods , the id too .


    Button answer1, answer2, answer3;
    TextView question, score;

    TextView exit_the_quiz;
    // take object from the class Questions . to access its methods
    Questions_beginner mQuestions_beginner = new Questions_beginner();

    // make a variable to check if answers are correct .on the method updateQuestion
    private String mAnswer;

    // make the counter for the score  and start at 0 .
    private int mScore = 0;

    // will use this to privent the app from crushing when it run out of questions .
    private int mQuestionsLength = mQuestions_beginner.mQuestionsBeginner.length;

    // using the Random method .
    private Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);


// this code   setDisplayHomeAsUpEnabled(true); will show  the back arrow in the action bar
        // now you need to go to the manifest and new attribute android:parentActivityName=" the page we want to back to "

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // use this method to change the question randomly

        random = new Random();

        // finding the view of each button was made
        answer1 = (Button) findViewById(R.id.choice1);
        answer2 = (Button) findViewById(R.id.choice2);
        answer3 = (Button) findViewById(R.id.choice3);


        //finding the view for the Score to increase it later on , and the question
        // to add it later on

        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);

        exit_the_quiz = (TextView) findViewById(R.id.end_quizSimple);

        // to quit the quiz when clicked on the image .
        exit_the_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizOver();
            }
        });

        updateQuestion(random.nextInt(mQuestionsLength));

        // set the clicklistner for each Button " the choice 1  "

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // used if statement to check if the answer was correct and clicked on
                // and increase the counter " the score "
                if (answer1.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    Toast.makeText(BeginnerQuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));
                } else {
                    // show a message the quiz is over and you can start again or leave.
                    Toast.makeText(BeginnerQuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));

                }
            }
        });

        // set the clicklistner for each Button " the choice 2  "

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // used if statment to check if the answer was correct and clicked on
                // and increase the counter " the score "
                if (answer2.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    Toast.makeText(BeginnerQuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    updateQuestion(random.nextInt(mQuestionsLength));
                } else {
                    // show a message the quiz is over and you can start again or leave.
                    Toast.makeText(BeginnerQuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));


                }
            }
        });

        // set the clicklistner for each Button " the choice 3  "

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // used if statment to check if the answer was correct and clicked on
                // and increase the counter " the score "
                if (answer3.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    Toast.makeText(BeginnerQuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));
                } else

                {
                    // show a message the quiz is over and you can start again or leave.
                    Toast.makeText(BeginnerQuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));


                }

            }
        });

    }// end of oncreate method


    private void updateScore(int point) {
        score.setText(MessageFormat.format("{0}", mScore));
       // score.setText("" + mScore);
    }

    // this method is used to find and sent the correct answer .
    private void updateQuestion(int i) {
        //getting the question here
        question.setText(mQuestions_beginner.getQuestionBeginner(i));
        // getting the answers in here .
        answer1.setText(mQuestions_beginner.getChoice1Beginner(i));
        answer2.setText(mQuestions_beginner.getChoice2Beginner(i));
        answer3.setText(mQuestions_beginner.getChoice3Beginner(i));
        mAnswer = mQuestions_beginner.getCorrectAnswerBeginner(i);

    }

    // this method will show a dialog for the user telling him the quiz has ended .
    //it also show him the score he got through the quiz .
    private void quizOver() {
        AlertDialog.Builder myDialogBuilderbeginner = new AlertDialog.Builder(BeginnerQuizActivity.this);
        myDialogBuilderbeginner.setMessage("The Quiz is over ! you scored  " + mScore + " points")
                .setCancelable(false).setPositiveButton(" Try again ?",

                // in case user choice to try again this will send an intent to this page
                // so the user can start the quiz again.
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), BeginnerQuizActivity.class));

                    }
                    // in case the user did not want to play .
                }).setNegativeButton(" Exit ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        // to display the dialog at the end
        AlertDialog alertDialog = myDialogBuilderbeginner.create();
        alertDialog.show();

    }

    // this code allows the and setup the up navigation from activity to the
    // fragment i came from
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // start of a class question
    //  you can add questions using the class below .

    private static class Questions_beginner {

        // now  i have to create 3 arrays one to hold the question , the second for the choices , the 3rd one is for the answers .

        private  String[] mQuestionsBeginner = {
                "If you were depressed, why didn't you talk to ______?",
                "Thomas isn't a good manager; he never plans ______ next week.",
                "______ thinking about your brother?",
                " Which word form is NOT CORRECT?",
                "Hurry up; I need those documents ______ away."
                ,
                "They've ______ it already."
                ,
                "You look very tired; you ______ take a shower and freshen up if you like."
                ,
                "If she wants to catch the train, she ______ hurry up!"
        }; // end of my questions


        // this is the second string array that will hold the choices for each question
        private String[][] mChoicesBeginner = {

                {"everyone", "someone", "any"},
                {"throughout", "over", "beyond"},
                {"What you were", "Were you", "You were"},
                {"understandably", "understandation", "understanding"},
                {"right", "already", "really"},
                {"talked", "listened", "done"},
                {"could", "shall", "would"},
                {"should have", "had better", "would"},
        };// end of the choices


        // this the 3rd array and it will hold the correct answer for each question .
        private String[] mCorrectAnswerBeginner = {
                "someone", "beyond", "Were you", "understandation", "right"
                , "done", "could", "had better"}; // end of the answers


        // this method is used to find the question
       private String getQuestionBeginner(int i) {
            String question;
            question = mQuestionsBeginner[i];
            return question;
        }

        //this method is used to get the answer if it was at position "0" inside the array the_choices .
       private String getChoice1Beginner(int i) {
            String choice1;
            choice1 = mChoicesBeginner[i][0];
            return choice1;
        }

        //this method is used to get the answer if it was at position "1" inside the array the_choices .
        private String getChoice2Beginner(int i) {
            String choice2;
            choice2 = mChoicesBeginner[i][1];
            return choice2;
        }

        //this method is used to get the answer if it was at position "2" inside the array the_choices .
       private String getChoice3Beginner(int i) {
            String choice3;
            choice3 = mChoicesBeginner[i][2];
            return choice3;
        }

//        //this method is used to get the answer if it was at position "3" inside the array the_choices .
//        public String getChoice4 (int i){
//            String choice4 = mChoices[i][3];
//            return choice4;
//        }

//this method is used to return the correct answer from the array "theCorrectAnswer"

        private String getCorrectAnswerBeginner(int i) {
            String answer;
            answer = mCorrectAnswerBeginner[i];
            return answer;
        }


    }// end of class questions


} // end of main activity


