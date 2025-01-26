package com.infanzon.collaborativestorybuilder.StoryHandler;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import com.infanzon.collaborativestorybuilder.R;
import com.infanzon.collaborativestorybuilder.databinding.ActivityStoryViewerBinding;

public class StoryViewer extends AppCompatActivity {

    private ActivityStoryViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStoryViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        Button goBackButton = findViewById(R.id.GoBack);
        goBackButton.setOnClickListener(v -> {
            finish();
        });
    }
}