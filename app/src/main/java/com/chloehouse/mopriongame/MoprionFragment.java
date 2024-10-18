package com.chloehouse.mopriongame;

import static android.content.Intent.getIntent;

import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.net.URISyntaxException;
import java.util.HashMap;


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
    private Button buttonRejouer;

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
        buttonRejouer = view.findViewById(R.id.buttonRejouer);
        TextView textJoueur1 = view.findViewById(R.id.textViewNomJoueur1);
        TextView textJoueur2 = view.findViewById(R.id.textViewNomJoueur2);

        ViewModelName nameViewModel = new ViewModelProvider(requireActivity()).get(ViewModelName.class);
        Log.i("ViewModelName", "nameViewModel is Initielized !");

        nameViewModel.getPlayerName().observe(getViewLifecycleOwner(), names -> {
            textJoueur1.setText(names.first);
            textJoueur2.setText(names.second);
        });
        /*ViewModelName nameViewModel = new ViewModelProvider(this).get(ViewModelName.class);
        Log.i("MyTag", "afficher les noms avec modelview");
        nameViewModel.getPlayerNames().observe(getViewLifecycleOwner(), names -> {
            Log.i("MyTag", "entre dans getPlayerNames");
            if (names != null) {
                textJoueur1.setText(names.first);
                textJoueur2.setText(names.second);
                Log.e("MyTag", "les noms sont affiches");
            } else {
                // Gérer le cas où les noms ne sont pas encore définis
                Log.e("MyTag", "Les noms des joueurs ne sont pas définis.");
            }
        });*/

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button1, R.drawable.round_40px);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button2, R.drawable.round_40px);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button3, R.drawable.round_40px);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button4, R.drawable.round_40px);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button5, R.drawable.round_40px);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button6, R.drawable.round_40px);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button7, R.drawable.round_40px);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button8, R.drawable.round_40px);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateImage(button9, R.drawable.round_40px);
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

    private void updateImage(ImageButton button, @DrawableRes int fichier){
        button.setImageResource(fichier);
    }
}