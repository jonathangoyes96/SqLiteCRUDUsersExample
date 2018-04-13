package com.optic.sqlitecrudusersexample.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.optic.sqlitecrudusersexample.R;
import com.optic.sqlitecrudusersexample.adapters.LawyersCursorAdapter;
import com.optic.sqlitecrudusersexample.db.LawyersDbHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class LawyersFragment extends Fragment {


    private LawyersDbHelper mLawyersDbHelper;

    private ListView mLawyersList;
    private LawyersCursorAdapter mLawyersAdapter;
    private FloatingActionButton mAddButton;


    public LawyersFragment() {
        // Required empty public constructor
    }

    public static LawyersFragment newInstance() {
        return new LawyersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lawyers, container, false);

        // Referencias UI
        mLawyersList = (ListView) root.findViewById(R.id.lawyers_list);
        mLawyersAdapter = new LawyersCursorAdapter(getActivity(), null);
        mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mLawyersList.setAdapter(mLawyersAdapter);

        // Instancia de helper
        mLawyersDbHelper = new LawyersDbHelper(getActivity());

        // Carga de datos
        loadLawyers();

        return root;
    }

    /*
     * EJECUTO LA TAREA ASINCRONA QIE CARGA LA LISTA DE ABOGADOS
     */
    private void loadLawyers() {
        new LawyersLoadTask().execute();
    }


    /*
     * Tarea asíncrona la cuál reciba como resultado un Cursor.
     * Esto con el fin de no entorpecer el hilo principal con el acceso a la base de datos
     */
    private class LawyersLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mLawyersDbHelper.getAllLawyers();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mLawyersAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }
}
