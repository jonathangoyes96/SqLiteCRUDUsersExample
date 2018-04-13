package com.optic.sqlitecrudusersexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.optic.sqlitecrudusersexample.activities.LawyersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent lawyerIntent = new Intent(this, LawyersActivity.class);
        startActivity(lawyerIntent);
    }
}
