package com.android.asel.ej01listfragmentweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        String url = getIntent().getStringExtra("enlace");

        WebViewFragment wVFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.webFragment);

        if(!wVFragment.getActualUrl().equals(url))
            wVFragment.mostrarUrl(url);

    }

}
