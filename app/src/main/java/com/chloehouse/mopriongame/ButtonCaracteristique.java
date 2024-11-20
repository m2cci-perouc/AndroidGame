package com.chloehouse.mopriongame;

import android.widget.ImageButton;
import android.widget.TextView;

public class ButtonCaracteristique {
        //cette classe permet d'ajouter les regles du jeu et de vérifier si un joueur gagne

        private ImageButton imageButton;
        private TextView textView;
        private Integer numJoueur;

        // Constructeur
    public ButtonCaracteristique(ImageButton imageButton, TextView textView, Integer numJoueur) {
        this.imageButton = imageButton;
        this.textView = textView;
        this.numJoueur = numJoueur;
    }

    // Getters
        public ImageButton getImageButton() {
            return imageButton;
        }

        public TextView getTextView() {
            return textView;
        }

        public Integer getNumJoueur() {
            return numJoueur;
        }

    // Setters
        public void setImageButton(ImageButton imageButton) {
            this.imageButton = imageButton;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public void setNumJoueur(Integer numJoueur) {
            this.numJoueur = numJoueur;
        }
}
