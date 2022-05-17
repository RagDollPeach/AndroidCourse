package com.example.mynotepad;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainFragment extends Fragment {

    int tVNote = R.id.t_v_notes;
    int imagePencil = R.drawable.note_gr;
    int tVFavorite = R.id.t_v_favorite;
    int imageStar = R.drawable.star;
    int imageInsert = R.drawable.insert_gr;
    int imageReminder = R.drawable.reminder;
    int imageBasket = R.drawable.basket;
    int tVInsert = R.id.t_v_inserts;
    int tVReminder = R.id.t_v_reminder;
    int tVBasket = R.id.t_v_basket;
    AppCompatTextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setImages(view, tVNote, imagePencil);
        setImages(view, tVFavorite, imageStar);
        setImages(view, tVInsert, imageInsert);
        setImages(view, tVReminder, imageReminder);
        setImages(view, tVBasket, imageBasket);

        textView = view.findViewById(R.id.t_v_notes);
        textView.setOnClickListener(view1 -> {
            NoteFragment note = new NoteFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container,note).addToBackStack("fragment_note").commit();
        });
    }

    public void setImages(View view, int textViewId, int imageId) {
        TextView textView = view.findViewById(textViewId);
        Drawable img = getResources().getDrawable(imageId);
        img.setBounds(30, 0, 120, 90);
        textView.setCompoundDrawables(img, null, null, null);
    }

}