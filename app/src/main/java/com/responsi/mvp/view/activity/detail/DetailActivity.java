package com.responsi.mvp.view.activity.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.responsi.mvp.R;

public class DetailActivity extends AppCompatActivity {
    private String nama, email, no, location, gender ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nama = getIntent().getStringExtra("nama");
        no = getIntent().getStringExtra("no");
        email = getIntent().getStringExtra("email");
        gender = getIntent().getStringExtra("gender");
        location = getIntent().getStringExtra("lokasi");

        TextView text = findViewById(R.id.tvTest);
        TextView noT = findViewById(R.id.no);
        TextView emailT = findViewById(R.id.email);
        TextView genderT = findViewById(R.id.gender);
        text.setText(nama);
        noT.setText(no);
        emailT.setText(email);
        genderT.setText(gender);
    }
}
