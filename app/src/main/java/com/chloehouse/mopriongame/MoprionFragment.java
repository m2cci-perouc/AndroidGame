package com.chloehouse.mopriongame;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class MoprionFragment extends Fragment {

    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private ImageButton button5;
    private ImageButton button6;
    private ImageButton button7;
    private ImageButton button8;
    private ImageButton button9;

    public static MoprionFragment newInstance() {
        MoprionFragment fragment = new MoprionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moprion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button1 = view.findViewById(R.id.button_1);
        button2 = view.findViewById(R.id.button_2);
        button3 = view.findViewById(R.id.button_3);
        button4 = view.findViewById(R.id.button_4);
        button5 = view.findViewById(R.id.button_5);
        button6 = view.findViewById(R.id.button_6);
        button7 = view.findViewById(R.id.button_7);
        button8 = view.findViewById(R.id.button_8);
        button9 = view.findViewById(R.id.button_9);
        Button buttonRejouer = view.findViewById(R.id.buttonRejouer);
        TextView textJoueur1 = view.findViewById(R.id.textViewNomJoueur1);
        TextView textJoueur2 = view.findViewById(R.id.textViewNomJoueur2);

        MyViewModel nameViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        Log.i("ViewModelName", "nameViewModel is Initielized !");

        nameViewModel.getPlayerName().observe(getViewLifecycleOwner(), names -> {
            textJoueur1.setText(names.first);
            textJoueur2.setText(names.second);
        });

        // choisi au hasard le premier joueur
        // player1Turn si c'est au joueur 1 de jouer
        final Boolean[] player1Turn = {firstPlayer(textJoueur1, textJoueur2)};

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button1, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button2, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button3, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button4, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button5, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button6, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button7, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button8, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button9, R.drawable.cross_20px, R.drawable.round_40px, player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2);
            }
        });

        buttonRejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Naviguer vers nouveau fragment morpion
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MoprionFragment morpionFragment = MoprionFragment.newInstance();
                fragmentTransaction.replace(R.id.fragment_container_view, morpionFragment);
                fragmentTransaction.commit();
            }
        });
    }

    private Boolean jouerUneCase(ImageButton button, @DrawableRes int imageCroix,
                                 @DrawableRes int imageRond, Boolean[] player1Turn,
                                 Boolean player1TurnBool,
                                 TextView textJoueur1, TextView textJoueur2){
        if (boutonVide(button)){
            updateImage(button, imageCroix, imageRond, player1TurnBool);
            player1Turn[0] = changerTour(textJoueur1,  textJoueur2, player1Turn[0]);
        }
        return player1Turn[0];
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void updateImage(ImageButton button, @DrawableRes int imageCroix,
                             @DrawableRes int imageRond, Boolean player1Turn){
        if (boutonVide(button)){
            if (player1Turn) {
                button.setImageResource(imageRond);
            } else {
                button.setImageResource(imageCroix);
            }
        }
    }

    private boolean boutonVide(ImageButton button){
        //true si le bouton est vide
        Drawable buttonDrawable = button.getDrawable();
        Drawable encadreDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.encadre, null);

        if (buttonDrawable instanceof BitmapDrawable && encadreDrawable instanceof BitmapDrawable) {
            Bitmap bitmap1 = ((BitmapDrawable) buttonDrawable).getBitmap();
            Bitmap bitmap2 = ((BitmapDrawable) encadreDrawable).getBitmap();

            return bitmap1.sameAs(bitmap2);
        }
        return false;
    }

    private Boolean firstPlayer(TextView textJoueur1, TextView textJoueur2){
        //player1Start si player1 tiré au sort pour commencer
        boolean player1Start;

        Random random = new Random();
        player1Start = random.nextBoolean();

        if (player1Start){
            textJoueur2.setAlpha(0.2f);
        }else {
            textJoueur1.setAlpha(0.2f);
        }
        return player1Start;
    }

    private Boolean changerTour(TextView textJoueur1, TextView textJoueur2, Boolean player1Turn){
        player1Turn = !player1Turn;
        if (player1Turn){
            textJoueur1.setAlpha(1f);
            textJoueur2.setAlpha(0.2f);

        }else {
            textJoueur1.setAlpha(0.2f);
            textJoueur2.setAlpha(1f);
        }
        return player1Turn;
    }
}