package com.example.menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_SAVED_CHOICE = "saved_choice";

    private TextView tvSaved;
    private SharedPreferences sharedPreferences;
    private String selectedSpinnerItem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Spinner spinner = findViewById(R.id.spinner);
        ListView listView = findViewById(R.id.listView);
        ImageView imageView = findViewById(R.id.imageView);
        tvSaved = findViewById(R.id.tvSaved);

        imageView.setImageResource(R.mipmap.ic_launcher);
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        loadSavedPreference();
        String[] spinnerItems = {"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, spinnerItems);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSpinnerItem = spinnerItems[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        String[] listItems = {"Item A", "Item B", "Item C", "Item D"};
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = listItems[position];
            Toast.makeText(MainActivity.this,
                    getString(R.string.msg_clicked, selectedItem),
                    Toast.LENGTH_SHORT).show();
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_save) {
            savePreference(selectedSpinnerItem);
            return true;
        } else if (id == R.id.action_clear) {
            clearPreference();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void savePreference(String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SAVED_CHOICE, value);
        editor.apply();

        tvSaved.setText(getString(R.string.saved_preference_format, value));
        Toast.makeText(this, getString(R.string.msg_saved, value), Toast.LENGTH_SHORT).show();
    }

    private void loadSavedPreference() {
        String defaultNone = getString(R.string.saved_none);
        String savedValue = sharedPreferences.getString(KEY_SAVED_CHOICE, defaultNone);
        tvSaved.setText(getString(R.string.saved_preference_format, savedValue));
    }

    private void clearPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        String defaultNone = getString(R.string.saved_none);
        tvSaved.setText(getString(R.string.saved_preference_format, defaultNone));
        Toast.makeText(this, getString(R.string.msg_cleared), Toast.LENGTH_SHORT).show();
    }
}
