package com.chloehouse.mopriongame;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.buttonJoueur);
        EditText textJoueur1 = view.findViewById(R.id.nameJoueur1);
        EditText textJoueur2 = view.findViewById(R.id.nameJoueur2);

        //boutton non cliquable
        button.setEnabled(false);

        //verifier si la saisie utilisateur1 n est pas vide -> autoriser le clic + creer joueur1
        textJoueur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean isEmpty = s.toString().isEmpty();
                //autoriser clic
                button.setEnabled(!isEmpty);
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
                boolean isEmpty = s.toString().isEmpty();
                //autoriser clic
                button.setEnabled(!isEmpty);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Chloe", "--- Clic ---");

                //enregistrer les noms
                Bundle bundle = new Bundle();
                bundle.putString("nom1", textJoueur1.getText().toString());
                bundle.putString("nom2", textJoueur2.getText().toString());

                Fragment destinationFragment = new MoprionFragment();
                destinationFragment.setArguments(bundle);


                // Naviguer vers fragment morpion
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view, destinationFragment);
                fragmentTransaction.commit();
            }
        });
    }
}