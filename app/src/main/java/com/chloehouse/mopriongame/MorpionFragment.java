package com.chloehouse.mopriongame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MorpionFragment extends Fragment {

    private MyViewModel nameViewModel;
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private ImageButton button5;
    private ImageButton button6;
    private ImageButton button7;
    private ImageButton button8;
    private ImageButton button9;
    ButtonCaracteristique butCaract1 = new ButtonCaracteristique(button1, null, null);
    ButtonCaracteristique butCaract2 = new ButtonCaracteristique(button2, null, null);
    ButtonCaracteristique butCaract3 = new ButtonCaracteristique(button3, null, null);
    ButtonCaracteristique butCaract4 = new ButtonCaracteristique(button4, null, null);
    ButtonCaracteristique butCaract5 = new ButtonCaracteristique(button5, null, null);
    ButtonCaracteristique butCaract6 = new ButtonCaracteristique(button6, null, null);
    ButtonCaracteristique butCaract7 = new ButtonCaracteristique(button7, null, null);
    ButtonCaracteristique butCaract8 = new ButtonCaracteristique(button8, null, null);
    ButtonCaracteristique butCaract9 = new ButtonCaracteristique(button9, null, null);
    private LottieAnimationView lottieAnimationView;
    private TextView textViewGagant;
    private TextView textViewMatchNull;

    public static MorpionFragment newInstance() {
        return new MorpionFragment();
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
        TextView scoreJoueur1 = view.findViewById(R.id.textViewScoreJoueur1);
        TextView scoreJoueur2 = view.findViewById(R.id.textViewScoreJoueur2);
        TextView tvPolitique = view.findViewById(R.id.tvPolitiqueConfidentialite);
        lottieAnimationView = view.findViewById(R.id.lottie_animation_view);
        textViewGagant= view.findViewById(R.id.nomGagnant);
        textViewMatchNull= view.findViewById(R.id.matchNull);

        nameViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        Log.i("ViewModelName", "nameViewModel is Initielized !");

        // affiche les noms des joueurs
        nameViewModel.getPlayerName().observe(getViewLifecycleOwner(), names -> {
            textJoueur1.setText(names.first);
            textJoueur2.setText(names.second);
        });
        // affiche les scores des joueurs
        nameViewModel.getPlayerScore().observe(getViewLifecycleOwner(), scores -> {
            scoreJoueur1.setText(String.valueOf(scores.first));
            scoreJoueur2.setText(String.valueOf(scores.second));
        });

        // choisi au hasard le premier joueur
        // player1Turn si c'est au joueur 1 de jouer
        final Boolean[] player1Turn = {firstPlayer(textJoueur1, textJoueur2, scoreJoueur1, scoreJoueur2)};


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button1, butCaract1,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button2, butCaract2,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button3, butCaract3,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button4, butCaract4,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button5, butCaract5,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button6,butCaract6,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button7, butCaract7,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button8, butCaract8,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jouerUneCase(button9, butCaract9,buttonRejouer,
                        R.drawable.cross_80px, R.drawable.round_80px,
                        player1Turn, player1Turn[0],
                        textJoueur1,  textJoueur2,
                        scoreJoueur1, scoreJoueur2);
            }
        });

        buttonRejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Naviguer vers nouveau fragment morpion
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MorpionFragment morpionFragment = MorpionFragment.newInstance();
                fragmentTransaction.replace(R.id.fragment_container_view, morpionFragment);
                fragmentTransaction.commit();
            }
        });

        // lien confidentialite cliquable
        tvPolitique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.privacypolicies.com/live/671e4fb6-889b-4ba4-ad6f-0387e9840aaa"));
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void jouerUneCase(ImageButton button, ButtonCaracteristique butCaract,
                              Button buttonRejouer,
                              @DrawableRes int imageCroix,
                              @DrawableRes int imageRond,
                              Boolean[] player1Turn,
                              Boolean player1TurnBool,
                              TextView textJoueur1, TextView textJoueur2,
                              TextView scoreJoueur1, TextView scoreJoueur2){
        if (boutonVide(button)){
            ButtonCaracteristique[] mesBoutons = {butCaract1, butCaract2, butCaract3, butCaract4,
                    butCaract5, butCaract6, butCaract7, butCaract8,butCaract9 };
            boolean matchNull;

            updateImage(button, butCaract, imageCroix, imageRond, player1TurnBool, textJoueur1, textJoueur2);
            matchNull = verifierFinPartie(mesBoutons, player1TurnBool, textJoueur1, textJoueur2);
            if (matchNull){
                textViewMatchNull.setText("Match nul...");
                YoYo.with(Techniques.SlideInDown)
                        .duration(2000)
                        .playOn(textViewMatchNull);
            }
            player1Turn[0] = changerTour(textJoueur1,  textJoueur2, scoreJoueur1, scoreJoueur2,player1Turn[0]);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void updateImage(ImageButton button,
                             ButtonCaracteristique butCaract,
                             @DrawableRes int imageCroix,
                             @DrawableRes int imageRond,
                             Boolean player1Turn,
                             TextView textJoueur1, TextView textJoueur2){
        if (boutonVide(button)){
            if (player1Turn) {
                button.setImageResource(imageRond);
                butCaract.setTextView(textJoueur1);
                butCaract.setNumJoueur(1);
            } else {
                button.setImageResource(imageCroix);
                butCaract.setTextView(textJoueur2);
                butCaract.setNumJoueur(2);
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

    private boolean verifierFinPartie(ButtonCaracteristique[] boutons, Boolean player1TurnBool,
                                     TextView textJoueur1, TextView textJoueur2) {
        // fonction verifie si toutes les cases sont jouees ou si un joueur a aligne ses cases

        boolean matchNull = false;
        Boolean gagne;
        Boolean plateauPlein = true;

        //test si gagné
        gagne = testAlignement(boutons, player1TurnBool);
        //personalise le message avec nom du joueur
        if (gagne){
            if (player1TurnBool){
                //affichage du feu d'artifice
                lottieAnimationView.setVisibility(View.VISIBLE);
                lottieAnimationView.playAnimation();
                textViewGagant.setText(textJoueur1.getText());
                //affichage du nom gagnant
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(5)
                        .playOn(textViewGagant);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(() -> {
                    YoYo.with(Techniques.FlipOutX)
                            .duration(700)
                            .playOn(textViewGagant);
                }, 4000);

                nameViewModel.incrementPlayer1Score();
            }else{
                //affichage du feu d'artifice
                lottieAnimationView.setVisibility(View.VISIBLE);
                lottieAnimationView.playAnimation();
                textViewGagant.setText(textJoueur2.getText());
                //affichage du nom gagnant
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(5)
                        .playOn(textViewGagant);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(() -> {
                    YoYo.with(Techniques.FlipOutX)
                            .duration(700)
                            .playOn(textViewGagant);
                }, 4000);

                nameViewModel.incrementPlayer2Score();
            }
        }else {
            //test si plus de case libre
            for (ButtonCaracteristique bouton : boutons) {
                if (bouton.getNumJoueur() == null) {
                    plateauPlein = false;
                }
            }
            if (plateauPlein){
                matchNull = true;
            }
        }
        return matchNull;
    }

    private Boolean testAlignement(ButtonCaracteristique[] boutons, Boolean player1TurnBool){
        // fonction test si joueur a aligne ses cases
        boolean gagner = false;
        Integer joueurActuel = player1TurnBool ? 1 : 2;

        // test Ligne
        for (int ligne = 0; ligne < 3; ligne++) {
            if (boutons[ligne * 3] != null &&
                    boutons[ligne * 3 + 1] != null &&
                    boutons[ligne * 3 + 2] != null &&
                    boutons[ligne * 3].getNumJoueur() == (joueurActuel) &&
                    boutons[ligne * 3 + 1].getNumJoueur() == (joueurActuel) &&
                    boutons[ligne * 3 + 2].getNumJoueur() == (joueurActuel)) {
                gagner = true;
                break;
            }
        }

        //test Colonne
        for (int colonne = 0; colonne < 3; colonne++) {
            if (boutons[colonne] != null &&
                    boutons[colonne + 3] != null &&
                    boutons[colonne + 6] != null &&
                    boutons[colonne].getNumJoueur() == (joueurActuel) &&
                    boutons[colonne + 3].getNumJoueur() == (joueurActuel) &&
                    boutons[colonne + 6].getNumJoueur() == (joueurActuel)) {
                gagner = true;
                break;
            }
        }

        //test digonale
        if (boutons[0] != null && boutons[4] != null && boutons[8] != null &&
                boutons[0].getNumJoueur() == (joueurActuel) &&
                boutons[4].getNumJoueur() == (joueurActuel) &&
                boutons[8].getNumJoueur() == (joueurActuel)) {
            gagner = true;
        }
        if (boutons[2] != null && boutons[4] != null && boutons[6] != null &&
                boutons[2].getNumJoueur() == (joueurActuel) &&
                boutons[4].getNumJoueur() == (joueurActuel) &&
                boutons[6].getNumJoueur() == (joueurActuel)){
            gagner = true;
        }
        return gagner;
    }

    private Boolean firstPlayer(TextView textJoueur1, TextView textJoueur2,
                                TextView scoreJoueur1, TextView scoreJoueur2){
        //player1Start true si player1 tiré au sort pour commencer
        boolean player1Start;

        Random random = new Random();
        player1Start = random.nextBoolean();

        // met de la transparence sur les noms
        if (player1Start){
            textJoueur2.setAlpha(0.2f);
            scoreJoueur2.setAlpha(0.2f);
        }else {
            textJoueur1.setAlpha(0.2f);
            scoreJoueur1.setAlpha(0.2f);
        }
        return player1Start;
    }

    private Boolean changerTour(TextView textJoueur1, TextView textJoueur2,
                                TextView scoreJoueur1, TextView scoreJoeur2,
                                Boolean player1Turn){
        player1Turn = !player1Turn;
        if (player1Turn){
            textJoueur1.setAlpha(0.7f);
            scoreJoueur1.setAlpha(0.7f);
            textJoueur2.setAlpha(0.2f);
            scoreJoeur2.setAlpha(0.2f);
        }else {
            textJoueur1.setAlpha(0.2f);
            scoreJoueur1.setAlpha(0.2f);
            textJoueur2.setAlpha(0.7f);
            scoreJoeur2.setAlpha(0.7f);
        }
        return player1Turn;
    }
}