package com.chloehouse.mopriongame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.chloehouse.mopriongame.R;

public class WelcomeFragment extends Fragment {

    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    // Fonction pour vérifier et activer le bouton
    private void verifierEtActiverBouton(EditText textJoueur1, EditText textJoueur2, Button button) {
        String valeurJoueur1 = textJoueur1.getText().toString().trim();
        String valeurJoueur2 = textJoueur2.getText().toString().trim();
        button.setEnabled(!valeurJoueur1.isEmpty() && !valeurJoueur2.isEmpty());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Trouver les vues
        Button button = view.findViewById(R.id.buttonJoueur);
        EditText textJoueur1 = view.findViewById(R.id.nameJoueur1);
        EditText textJoueur2 = view.findViewById(R.id.nameJoueur2);

        // Appeler la méthode pour desactiver le bouton
        verifierEtActiverBouton(textJoueur1, textJoueur2, button);

        //verifier si la saisie utilisateur n est pas vide -> autoriser le clic
        textJoueur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                verifierEtActiverBouton(textJoueur1, textJoueur2, button);
            }
        });
        //verifier si la saisie utilisateur n est pas vide -> autoriser le clic
        textJoueur2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                verifierEtActiverBouton(textJoueur1, textJoueur2, button);
            }
        });

        //initialise le viwModel
        MyViewModel nameViewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //enregistrer les noms dans viewModel
                String player1Name = textJoueur1.getText().toString();
                String player2Name = textJoueur2.getText().toString();
                nameViewModel.setPlayerName(player1Name, player2Name);

                //initialiser le fragment morpion
                Fragment destinationFragment = new MorpionFragment();
                // Naviguer vers fragment morpion
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view, destinationFragment);
                fragmentTransaction.commit();
            }
        });
    }
}