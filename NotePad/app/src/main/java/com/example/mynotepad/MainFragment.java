package com.example.mynotepad;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private AppCompatTextView notes;
    private AppCompatTextView cities;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        int tVNote = R.id.t_v_note;
        int imagePencil = R.drawable.note_gr;
        setImages(view, tVNote, imagePencil);

        int tVFavorite = R.id.t_v_city;
        int imageStar = R.drawable.star;
        setImages(view, tVFavorite, imageStar);

        int imageInsert = R.drawable.sitings;
        int tVInsert = R.id.t_v_sitings;
        setImages(view, tVInsert, imageInsert);

        int imageReminder = R.drawable.about;
        int tVReminder = R.id.t_v_about;
        setImages(view, tVReminder, imageReminder);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NotesFragment rnf = new NotesFragment();
        CitiesFragment cityFragment = new CitiesFragment();

        notes = view.findViewById(R.id.t_v_note);
        cities = view.findViewById(R.id.t_v_city);

        notes.setOnClickListener(view1 -> enableFragment(notes, rnf, "fragment_note"));
        cities.setOnClickListener(view1 -> enableFragment(cities, cityFragment, "fragment_cities"));

    }

    public void setImages(View view, int textViewId, int imageId) {
        TextView textView = view.findViewById(textViewId);
        if (getContext() != null) {
            Drawable img = ResourcesCompat.getDrawable(getResources(), imageId, getContext().getTheme());
            if (img != null) {
                img.setBounds(30, 0, 120, 90);
            }
            textView.setCompoundDrawables(img, null, null, null);
        }
    }

    public void enableFragment(AppCompatTextView textView, Fragment note, String fragmentName) {
        textView.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, note)
                .addToBackStack(fragmentName)
                .commit();
    }
}