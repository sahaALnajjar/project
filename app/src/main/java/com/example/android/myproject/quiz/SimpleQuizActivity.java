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

public class SimpleQuizActivity extends AppCompatActivity {

    Button answer1, answer2, answer3;
    TextView question, score;

    TextView exit_the_quiz;
    // take object from the class Questions . to access its methods
    private Questions mQuestions = new Questions();

    // make a variable to check if answers are correct .on the method updateQuestion
    private String mAnswer;

    // make the counter for the score  and start at 0 .
    private int mScore = 0;

    // will use this to privent the app from crushing when it run out of questions .
    private int mQuestionsLength = mQuestions.mQuestions.length;

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
                // used if statment to check if the answer was correct and clicked on
                // and increase the counter " the score "
                if (answer1.getText() == mAnswer) {
                    mScore++;
                    updateScore(mScore);
                    Toast.makeText(SimpleQuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));
                } else {
                    // show a message the quiz is over and you can start again or leave.
                    Toast.makeText(SimpleQuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(SimpleQuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    updateQuestion(random.nextInt(mQuestionsLength));
                } else {
                    // show a message the quiz is over and you can start again or leave.
                    Toast.makeText(SimpleQuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(SimpleQuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));
                } else

                {
                    // show a message the quiz is over and you can start again or leave.
                    Toast.makeText(SimpleQuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion(random.nextInt(mQuestionsLength));


                }

            }
        });

    }// end of oncreate method


    private void updateScore(int point) {
        score.setText(MessageFormat.format("{0}", mScore));
    }

    // this method is used to find and sent the correct answer .
    private void updateQuestion(int i) {
        //getting the question here
        question.setText(mQuestions.getQuestion(i));
        // getting the answers in here .
        answer1.setText(mQuestions.getChoice1(i));
        answer2.setText(mQuestions.getChoice2(i));
        answer3.setText(mQuestions.getChoice3(i));
        mAnswer = mQuestions.getCorrectAnswer(i);

    }

    // this method will show a dialog for the user telling him the quiz has ended .
    //it also show him the score he got through the quiz .
    private void quizOver() {
        AlertDialog.Builder myDialogBuilder = new AlertDialog.Builder(SimpleQuizActivity.this);
        myDialogBuilder.setMessage("The Quiz is over ! you scored  " + mScore + " points")
                .setCancelable(false).setPositiveButton(" Try again ?",

                // in case user choice to try again this will send an intent to this page
                // so the user can start the quiz again.
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), SimpleQuizActivity.class));

                    }
                    // in case the user did not want to play .
                }).setNegativeButton(" Exit ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        // to display the dialog at the end
        AlertDialog alertDialog = myDialogBuilder.create();
        alertDialog.show();

    }

    // this code allows the and setup the up navigation from activity to the fragment i came from
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

    private static class Questions {

        // now  i have to create 3 arrays one to hold the question , the second for the choices , the 3rd one is for the answers .

        private String[] mQuestions = {
                "Shhh! Please don't talk so loud; the baby _____  ",
                "The train goes ____ many tunnels on the way to Rome",
                "What is she doing? ",
                "We get good grades ______ we study.",
                "Excuse me, where is the post office? ,I'm sorry, I ______ English."
                ,
                "Are there any good restaurants around here? Yes, ______ the highway."
                ,
                "    _____tired from working so much?",
                "They ______ the pyramids when they went to Egypt."}; // end of my questions


        // this is the second string array that will hold the choices for each question
        private String[][] mChoices = {

                {"sleeps", "is sleeping", "are sleeping"},
                {"in", "to", "through"},
                {"she cooking dinner", "she are watching TV", "she's waiting for you."},
                {"but", "except", "because"},
                {"am not speaking", "speak not", "don't speak"},
                {"are some on", "there are many on", "there are some to"},
                {"are you", "Is", "You are"},
                {"didn't", "seed", "did not saw"},
        };// end of the choices


        // this the 3rd array and it will hold the correct answer for each question .
        private String[] mCorrectAnswer = {
                "is sleeping", "through", "she's waiting for you.", "because", "don't speak"
                , "there are many on", "are you", "didn't"}; // end of the answers


        // this method is used to find the question
        private String getQuestion(int i) {
            String question;
            question = mQuestions[i];
            return question;
        }

        //this method is used to get the answer if it was at position "0" inside the array the_choices .
        private String getChoice1(int i) {
            String choice1;
            choice1 = mChoices[i][0];
            return choice1;
        }

        //this method is used to get the answer if it was at position "1" inside the array the_choices .
        private String getChoice2(int i) {
            String choice2;
            choice2 = mChoices[i][1];
            return choice2;
        }

        //this method is used to get the answer if it was at position "2" inside the array the_choices .
        private String getChoice3(int i) {
            String choice3;
            choice3 = mChoices[i][2];
            return choice3;
        }

//        //this method is used to get the answer if it was at position "3" inside the array the_choices .
//        public String getChoice4 (int i){
//            String choice4 = mChoices[i][3];
//            return choice4;
//        }

//this method is used to return the correct answer from the array "theCorrectAnswer"

        private String getCorrectAnswer(int i) {
            String answer;
            answer = mCorrectAnswer[i];
            return answer;
        }


    }// end of class questions


} // end of main activity








