package com.chloehouse.mopriongame;

import android.util.Log;
import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelName extends ViewModel {

    private final MutableLiveData<Pair<String, String>> playerNames = new MutableLiveData<>();

    //constructor
    public ViewModelName() {
        Log.i("ViewModelName", "ViewModel is created !");
    }

    public void setPlayerName(String player1, String player2) {
        playerNames.setValue(new Pair<>(player1, player2));
        Log.i("ViewModelName", "player set !");
    }

    public LiveData<Pair<String, String>> getPlayerName() {
        Log.i("ViewModelName", "player get !");
        return playerNames;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("ViewModelName", "ViewModel is destroyed !");
    }
}
