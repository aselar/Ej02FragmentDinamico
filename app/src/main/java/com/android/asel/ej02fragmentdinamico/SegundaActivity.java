package com.android.asel.ej02fragmentdinamico;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity {

    private WebViewFragment wVFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        String url = getIntent().getStringExtra("enlace");

        if (wVFragment == null) {
            wVFragment = new WebViewFragment();
        }

        if (!wVFragment.isAdded()) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.webFragmentContenedor, wVFragment);
            getSupportFragmentManager().executePendingTransactions();
            ft.commit();

        }

        if(!wVFragment.getActualUrl().equals(url))
            wVFragment.mostrarUrl(url);
    }

}
