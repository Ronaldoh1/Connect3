package com.example.ronaldhernandez.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0 = Yellow and 1 = Red;
    int activePlayer = 0;
    //2 means unplayed.

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    //Keep track of Combination. Use an array of arrays for combinations.
    int[][] winningPositions ={{0,1,2}, {3,4,5},{6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view){

        ImageView counter = (ImageView)view;

        //need to move it off the screen.Apply red or yellow.


        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        //if it hasn't been tapped
        if (gameState[tappedCounter] == 2){
            counter.setTranslationY(-1000f);
            //set the image.
            if(activePlayer == 0){
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
                gameState[tappedCounter] = activePlayer;

            }else{
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            //Move it back to position
            counter.animate().translationYBy(1000f).rotation(180).setDuration(300);

            for(int[] winningPosition : this.winningPositions){
                //check if winning positions in game state.

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    String winner = "Red";

                    if(gameState[winningPosition[0]] == 0){
                        winner = "Yellow";
                    }

                    //Someon has one
                    TextView winnerMessage = (TextView)findViewById(R.id.winnerText);
                    winnerMessage.setText("Player " + activePlayer + " has won");

                    LinearLayout layout = (LinearLayout)findViewById(R.id.winnerlayout);

                    layout.setVisibility(view.VISIBLE);

                }

            }
        }


    }

    public void PlayAgain(View view){

        LinearLayout layout = (LinearLayout)findViewById(R.id.winnerlayout);

        layout.setVisibility(view.INVISIBLE);
       // this.gameState = {2,2,2,2,2,2,2,2,2};

        //0 = Yellow and 1 = Red;
        activePlayer = 0;
        //2 means unplayed.

        for (int i = 0; i <gameState.length; i++){
            gameState[i] = 2;
        }

        //reset the state of the images
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for(int i = 0; i<gridLayout.getChildCount(); i++){

            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

}
