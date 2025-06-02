package com.example.practica_04;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AppComponentFactory;
import android.os.Bundle;

public class acitivityMain extends AppComponentFactory {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
    }
}
