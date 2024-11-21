package com.chloehouse.mopriongame;

import android.util.Log;
import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<Pair<String, String>> playerNames = new MutableLiveData<>();
    private final MutableLiveData<Pair<Integer, Integer>> playerScore = new MutableLiveData<>();

    //constructor
    public MyViewModel() {Log.i("ViewModelName", "ViewModel is created !");}

    //noms
    public void setPlayerName(String player1, String player2) {
        playerNames.setValue(new Pair<>(player1, player2));
        Log.i("ViewModelName", "player set !");
    }

    public LiveData<Pair<String, String>> getPlayerName() {
        Log.i("ViewModelName", "player get !");
        return playerNames;
    }

    // scores
    public void setPlayerScore() {
        playerScore.setValue(new Pair<>(0,0));
        Log.i("ViewModelScore", "player score set !");
    }

    public LiveData<Pair<Integer, Integer>> getPlayerScore(){
        Log.i("ViewModelScore", "score get !");
        return playerScore;
    }

    public void incrementPlayer1Score() {
        Pair<Integer, Integer> currentScores = playerScore.getValue();
        playerScore.setValue(new Pair<>(currentScores.first + 1, currentScores.second));
    }

    public void incrementPlayer2Score() {
        Pair<Integer, Integer> currentScores = playerScore.getValue();
        playerScore.setValue(new Pair<>(currentScores.first, currentScores.second + 1));
    }

    // detruire viewmodel
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("ViewModelName", "ViewModel is destroyed !");
    }
}
