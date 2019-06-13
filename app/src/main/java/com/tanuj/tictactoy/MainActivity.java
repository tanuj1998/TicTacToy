package com.tanuj.tictactoy;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BuClick(View view) {
        Button buSelected = (Button) view;


        int CellID = 0;

        switch ((buSelected.getId())){
            case R.id.bu1:
                CellID = 1;
                break;

            case R.id.bu2:
                CellID = 2;
                break;

            case R.id.bu3:
                CellID = 3;
                break;

            case R.id.bu4:
                CellID = 4;
                break;

            case R.id.bu5:
                CellID = 5;
                break;

            case R.id.bu6:
                CellID = 6;
                break;

            case R.id.bu7:
                CellID = 7;
                break;

            case R.id.bu8:
                CellID = 8;
                break;

            case R.id.bu9:
                CellID = 9;
                break;
        }
        PlayGame(CellID,buSelected);
    }

    int ActivePlayer = 1; // 1 -> First player, 2 -> Second player
    ArrayList<Integer> Player1 = new ArrayList<>(); //Hold player 1 data
    ArrayList<Integer> Player2 = new ArrayList<>(); //Hold player 2 data

    void PlayGame(int CellID, Button buSelected){
        Log.d("Player", String.valueOf(CellID));

            if (ActivePlayer == 1) {
                buSelected.setText("X");
                buSelected.setBackgroundColor(Color.RED);
                Player1.add(CellID);
                ActivePlayer = 2;
                AutoPlay();

            } else if (ActivePlayer == 2) {
                buSelected.setText("O");
                buSelected.setBackgroundColor(Color.BLUE);
                Player2.add(CellID);
                ActivePlayer = 1;

            }

        buSelected.setEnabled(false);
        CheckWinner();

    }

    void CheckWinner() {
        int winner = -1;

        //Row 1
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            winner = 1;
        }

        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            winner = 2;
        }

        //Row 2
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            winner = 1;
        }

        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            winner = 2;
        }

        //Row 3
        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            winner = 1;
        }

        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            winner = 2;
        }

        //Col 1
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            winner = 1;
        }

        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            winner = 2;
        }

        //Col 2
        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winner = 1;
        }

        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            winner = 2;
        }

        //Col 3
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            winner = 1;
        }

        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            winner = 2;
        }

        //Diagonal 1
        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
            winner = 1;
        }

        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            winner = 2;
        }

        //Diagonal 2
        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
            winner = 1;
        }

        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            winner = 2;
        }

        if(winner != -1){

            if(winner == 1){
                Toast.makeText(this, "Player 1 won", Toast.LENGTH_LONG).show();
            }

            if(winner == 2){
                Toast.makeText(this, "Player 2 won", Toast.LENGTH_LONG).show();
            }
        }
    }

    void AutoPlay(){
        ArrayList<Integer> EmptyCells = new ArrayList<>(); // all empty cells
        for(int cellId = 1; cellId  < 10; cellId ++){
            if(!(Player1.contains(cellId) || Player2.contains(cellId))){
            EmptyCells.add(cellId);
            }
        }

        int CellID = 0;
        if(EmptyCells.size() != 0) {
            Random r = new Random();
            int RandomIndex = r.nextInt(EmptyCells.size() - 0) + 0;
            CellID = EmptyCells.get(RandomIndex);
        }
        Button buSelected;

        switch (CellID){
            case 1:
                buSelected = findViewById(R.id.bu1);
                break;

            case 2:
                buSelected = findViewById(R.id.bu2);
                break;

            case 3:
                buSelected = findViewById(R.id.bu3);
                break;

            case 4:
                buSelected = findViewById(R.id.bu4);
                break;

            case 5:
                buSelected = findViewById(R.id.bu5);
                break;

            case 6:
                buSelected = findViewById(R.id.bu6);
                break;

            case 7:
                buSelected = findViewById(R.id.bu7);
                break;

            case 8:
                buSelected = findViewById(R.id.bu8);
                break;

            case 9:
                buSelected = findViewById(R.id.bu9);
                break;

            default:
                buSelected = findViewById(R.id.bu1);
                break;

        }
        PlayGame(CellID,buSelected);
    }
}
