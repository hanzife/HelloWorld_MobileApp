package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    private Button button;
    private EditText txtNom;
    private TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        button = (Button) findViewById(R.id.btn_send);
        txtNom = findViewById(R.id.txtNom);
        txt_result = findViewById(R.id.txt_result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NameStored = txtNom.getText().toString();

                txt_result.setText(NameStored);
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            super.onCreate(savedInstanceState);

            setPreferencesFromResource(R.xml.root_preferences, rootKey);




        }
    }
}