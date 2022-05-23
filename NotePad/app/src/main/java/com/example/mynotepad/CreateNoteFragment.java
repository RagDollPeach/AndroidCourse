package com.example.mynotepad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;

public class CreateNoteFragment extends Fragment implements View.OnClickListener {

    private TextInputEditText title;
    private TextInputEditText text;
    private String note;
    private String noteTitle;
    private String keyNote = "note";
    private String keyTitle = "title";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_note, container, false);
        AppCompatButton saveButton = rootView.findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.t_in_title);
        text = view.findViewById(R.id.t_in_text);
        AppCompatButton backButton = view.findViewById(R.id.back_button);

        MainFragment fragment = new MainFragment();
        backButton.setOnClickListener(view1 -> enableFragment(fragment, "fragment_main"));
    }

    @Override
    public void onClick(View view) {
        CreateNoteFragment fragment = new CreateNoteFragment();
        if (text.getText() != null && title.getText() != null) {
            if (title.getText().toString().equals("")) {
                Bundle bundle = new Bundle();
                noteTitle = "Без названия";
                bundle.putString(keyTitle, noteTitle);
                fragment.setArguments(bundle);
                note = text.getText().toString();

            }
            else if (!text.getText().toString().equals("")) {
                note = text.getText().toString();
                noteTitle = title.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(keyNote, note);
                bundle.putString(keyTitle, noteTitle);
                fragment.setArguments(bundle);
            }
        }
        text.setText("");
        title.setText("");
    }

    public void enableFragment(Fragment fragment, String fragmentName) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragmentName)
                .commit();
    }
}