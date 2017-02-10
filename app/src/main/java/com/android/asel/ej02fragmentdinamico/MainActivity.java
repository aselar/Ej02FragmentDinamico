package com.android.asel.ej02fragmentdinamico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LinkListFragment.OnListFragmentSelectionListener {

    public static ArrayList<TutorialAndroid> listaTutoriales = new ArrayList<TutorialAndroid>();
    public static String []titulos;
    public static String []enlaces;
    private WebViewFragment wVFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();
    }

    private void cargarDatos() {

        titulos=getResources().getStringArray(R.array.lista_enlaces_tutoriales_Android);
        enlaces=getResources().getStringArray(R.array.urls_enlaces_tutoriales_Android);

        for (int i = 0; i< titulos.length;i++) {
            listaTutoriales.add(new TutorialAndroid(titulos[i], enlaces[i]));
        }

    }

    @Override
    public void onListFragmentSelection(int pos) {

        String url = listaTutoriales.get(pos).getEnlaceContenido();

        wVFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.webFragment);

        if (wVFragment == null) {

            Intent i = new Intent(this, SegundaActivity.class);
            i.putExtra("enlace", url);
            startActivity(i);

        } else {

            if(!wVFragment.getActualUrl().equals(url))
                wVFragment.mostrarUrl(url);

        }

    }
}
