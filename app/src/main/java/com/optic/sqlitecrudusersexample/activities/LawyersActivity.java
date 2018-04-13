package com.optic.sqlitecrudusersexample.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.optic.sqlitecrudusersexample.R;
import com.optic.sqlitecrudusersexample.fragments.LawyersFragment;

public class LawyersActivity extends AppCompatActivity {

    public static final String EXTRA_LAWYER_ID = "extra_lawyer_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // AÑADIENDO EL FRAGMENT LawyersFragment A ESTA ACTIVITY
        LawyersFragment fragment = (LawyersFragment)
                getSupportFragmentManager().findFragmentById(R.id.lawyers_container);

        if (fragment == null) {
            fragment = LawyersFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.lawyers_container, fragment)
                    .commit();
        }
    }

}
