package com.android.asel.ej02fragmentdinamico;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LinkListFragment.OnListFragmentSelectionListener {

    public static ArrayList<TutorialAndroid> listaTutoriales = new ArrayList<TutorialAndroid>();
    public static String []titulos;
    public static String []enlaces;

    private FrameLayout listFragmentContenedor, webFragmentContenedor;
    private FragmentManager fragmentManager;

    private WebViewFragment wVFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();

        //crear el fragment listado
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.listFragmentContenedor, new LinkListFragment());
        ft.commit();

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

        webFragmentContenedor=(FrameLayout)findViewById(R.id.webFragmentContenedor);

        if (webFragmentContenedor == null) {
            //dispositivo pequeño
            Intent i = new Intent(this, SegundaActivity.class);
            i.putExtra("enlace", url);
            startActivity(i);

        } else {
            //dispositivo grande
            if (wVFragment == null) {
                wVFragment = new WebViewFragment();
            }

            if (!wVFragment.isAdded()) {

                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.add(R.id.webFragmentContenedor, wVFragment);
                ft.addToBackStack(null);
                ft.commit();

            }

            if(!wVFragment.getActualUrl().equals(url))
                wVFragment.mostrarUrl(url);

        }

    }
}
