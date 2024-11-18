package com.chloehouse.morpiongame;

import android.widget.ImageButton;
import android.widget.TextView;

public class ButtonCaracteristique {
        //cette classe permet d'ajouter les regles du jeu et de vérifier si un joueur gagne

        private ImageButton imageButton;
        private TextView textView;

        // Constructeur
        public ButtonCaracteristique(ImageButton imageButton, TextView textView) {
            this.imageButton = imageButton;
            this.textView = textView;
        }

        // Getters
        public ImageButton getImageButton() {
            return imageButton;
        }

        public TextView getTextView() {
            return textView;
        }

        // Setters
        public void setImageButton(ImageButton imageButton) {
            this.imageButton = imageButton;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
}
