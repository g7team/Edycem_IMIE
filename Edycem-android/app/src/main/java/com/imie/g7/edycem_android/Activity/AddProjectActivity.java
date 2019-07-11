package com.imie.g7.edycem_android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.imie.g7.edycem_android.R;
import com.imie.g7.edycem_android.database.TestInternetConectivity;
import com.imie.g7.edycem_android.database.dao.ProjectDao;
import com.imie.g7.edycem_android.database.dto.ProjectDto;
import com.imie.g7.edycem_android.database.webservice.UsersService;

public class AddProjectActivity extends AppCompatActivity {

    int userId;
    EditText eSociete;
    EditText eName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);
        userId = getIntent().getIntExtra("userId", -1);
        if (userId == -1) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            eSociete = findViewById(R.id.editText);
            eName = findViewById(R.id.editText2);
        }
    }

    public void clickButtonSave(View view) {
        ProjectDto p = new ProjectDto();
        p.setName(eName.getText().toString());
        p.setSociety(eSociete.getText().toString());
        p.setUserId(userId);
        if(TestInternetConectivity.testConnexion(this)) {
            // taper dans l'api
            //p.setId();
        }
        int projectId = ProjectDao.insertNewProject(this, p);
        //InformationSection
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("userId", userId);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);
    }
}
