package com.example.mynotepad.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mynotepad.R;
import com.example.mynotepad.data.NotesDataSource;
import com.example.mynotepad.interfaces.INotesDataSource;
import com.example.mynotepad.interfaces.RvOnClickListener;
import com.example.mynotepad.pojo.Note;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SearchFragment extends Fragment implements RvOnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.list);
        MaterialButton searchButton = view.findViewById(R.id.search_button);
        EditText searchText = view.findViewById(R.id.search_text);

        INotesDataSource dataSource = NotesDataSource.getInstance();

        List<String> listOfTitles = Objects.requireNonNull(dataSource.getNotesList()).stream().map(Note::getTitle).collect(Collectors.toList());
        List<String> listOfTitlesToView = new ArrayList<>();

        searchButton.setOnClickListener(view1 -> {
            if (!listOfTitlesToView.isEmpty()) {
                listOfTitlesToView.clear();
            }
            if (searchText.getText() != null) {
                for (String s : listOfTitles) {
                    if (findByLetters(s, searchText.getText().toString())) {
                        listOfTitlesToView.add(s);
                    }
                }
                if (!listOfTitlesToView.isEmpty()) {
                    ArrayAdapter<Note> adapter = new ArrayAdapter(requireActivity(),
                            android.R.layout.simple_list_item_1,
                            listOfTitlesToView.toArray());
                    listView.setAdapter(adapter);
                } else {
                    listOfTitlesToView.add("По этому запросу ни чего не найдено");
                    ArrayAdapter<Note> adapter = new ArrayAdapter(requireActivity(),
                            android.R.layout.simple_list_item_1,
                            listOfTitlesToView.toArray());
                    listView.setAdapter(adapter);
                }
            }
        });

        listView.setOnItemClickListener((adapterView, view12, i, l) -> {
            for (Note note : dataSource.getNotesList()) {
                if (listOfTitlesToView.get(i).equals(note.getTitle())) {
                    switchFragment(note);
                }
            }
        });
    }

    private void enableFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack("fragment_search")
                .commit();
    }

    @Override
    public void onDestroyView() {
        hideKeyboard(requireActivity());
        super.onDestroyView();
    }

    private static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private boolean findByLetters(String result, String key) {
        result = result.toLowerCase().trim();
        key = key.toLowerCase().trim();

        char[] letters = key.toCharArray();
        for (char c : letters) {
            if (!result.contains(String.valueOf(c))) {
                return false;
            }
            result = result.substring(result.indexOf(c));
        }
        return true;
    }

    @Override
    public void switchFragment(Note note) {
        CreateNoteFragment fragment = new CreateNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("note", note);
        fragment.setArguments(bundle);
        enableFragment(fragment);
    }
}