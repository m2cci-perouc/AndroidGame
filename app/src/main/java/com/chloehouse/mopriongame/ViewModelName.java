package com.chloehouse.mopriongame;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelName extends ViewModel {

    private final MutableLiveData<String> player1 = new MutableLiveData<>();

    //constructor
    public ViewModelName() {
        Log.i("ViewModelName", "ViewModel is created !");
    }

    public void setPlayerName(String player1) {
        this.player1.setValue(player1);
        Log.i("ViewModelName", "player set !");
    }

    public LiveData<String> getPlayerName() {
        Log.i("ViewModelName", "player get !");
        return player1;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("ViewModelName", "ViewModel is destroyed !");
    }
}
