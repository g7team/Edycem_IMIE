package com.imie.g7.edycem_android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.imie.g7.edycem_android.R;
import com.imie.g7.edycem_android.database.TestInternetConectivity;
import com.imie.g7.edycem_android.database.dao.ProjectDao;
import com.imie.g7.edycem_android.database.dto.ProjectDto;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        userId = getIntent().getIntExtra("userId", -1);
        if (userId == -1) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            if(TestInternetConectivity.testConnexion(this)) {
                // recup des nouveaux projets sur la bdd distante
            }
            List<ProjectDto> lisProjects = ProjectDao.getListProject(this);
        }
    }

    public void clickButtonAddProject(View view) {
        Intent intent = new Intent(this, AddProjectActivity.class);
        intent.putExtra("userId", userId);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void onClicItem(int position)
    {
        // go to project detail page
    }
}
