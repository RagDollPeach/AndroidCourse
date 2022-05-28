package com.example.mynotepad;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainFragment extends Fragment {

    private MaterialButton notes;
    private MaterialButton cities;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        int tVNote = R.id.material_button_note;
        int imagePencil = R.drawable.note_gr;
        setImages(view, tVNote, imagePencil);

        int tVFavorite = R.id.material_button_cities;
        int imageStar = R.drawable.star;
        setImages(view, tVFavorite, imageStar);

        int imageInsert = R.drawable.sitings;
        int tVInsert = R.id.material_button_sitings;
        setImages(view, tVInsert, imageInsert);

        int imageReminder = R.drawable.photos;
        int tVReminder = R.id.material_button_photos;
        setImages(view, tVReminder, imageReminder);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NotesFragment notesFragment = new NotesFragment();
        CitiesFragment cityFragment = new CitiesFragment();

        notes = view.findViewById(R.id.material_button_note);
        cities = view.findViewById(R.id.material_button_cities);

        notes.setOnClickListener(view1 -> enableFragment(notesFragment, "fragment_note"));
        cities.setOnClickListener(view1 -> enableFragment(cityFragment, "fragment_cities"));

    }

    public void setImages(View view, int textViewId, int imageId) {
        TextView textView = view.findViewById(textViewId);
        Drawable img = ResourcesCompat.getDrawable(getResources(), imageId, requireContext().getTheme());
        if (img != null) {
            img.setBounds(30, 0, 120, 90);
        }
        textView.setCompoundDrawables(img, null, null, null);
    }

    public void enableFragment(Fragment note, String fragmentName) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, note)
                .addToBackStack(fragmentName)
                .commit();
    }
}