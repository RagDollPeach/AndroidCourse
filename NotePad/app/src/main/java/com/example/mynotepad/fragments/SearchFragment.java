package com.example.mynotepad.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.mynotepad.R;
import com.example.mynotepad.adpter.NoteAdapter;
import com.example.mynotepad.data.NotesDataSource;
import com.example.mynotepad.interfaces.INotesDataSource;
import com.example.mynotepad.pojo.Note;

public class SearchFragment extends Fragment {

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
        INotesDataSource dataSource = NotesDataSource.getInstance();
        ArrayAdapter<Note> adapter = new ArrayAdapter(requireActivity(),
                android.R.layout.simple_list_item_1,
                dataSource.getNotesList().stream().map(Note::getTitle).toArray());
        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        hideKeyboard(requireActivity());
        super.onDestroyView();

    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}