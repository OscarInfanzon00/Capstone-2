package com.infanzon.collaborativestorybuilder.MainApp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.infanzon.collaborativestorybuilder.R;
import com.infanzon.collaborativestorybuilder.StoryHandler.CollaborativeStory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CollaborativeStory.class);
            startActivity(intent);
        });
    }
}