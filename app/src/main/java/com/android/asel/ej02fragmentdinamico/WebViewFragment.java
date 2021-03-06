package com.android.asel.ej02fragmentdinamico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by aselr on 02/02/2017.
 */

public class WebViewFragment extends Fragment {

    private String actualUrl = "";
    private WebView webView;

    public String getActualUrl() { return actualUrl; }

    public void mostrarUrl(String url) {

        actualUrl = url;

        if (webView != null) {

            webView.getSettings().setJavaScriptEnabled(true);

            webView.loadUrl(url);

        }

    }

    public WebViewFragment() {
    }

    public static WebViewFragment newInstance(String url) {
        WebViewFragment fragment = new WebViewFragment();
        if (url != null) {

            Bundle args = new Bundle();
            args.putString("URL_SELECCIONADA", url);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args=getArguments();
        if (args!=null) {
            actualUrl=args.getString("URL_SELECCIONADA");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.webviewfragment_layout, container, false);
        webView = (WebView) v.findViewById(R.id.WebViewPage);

        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(actualUrl);
        }

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("position", actualUrl);
        webView.saveState(outState);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            actualUrl = savedInstanceState.getString("position");
            webView.restoreState(savedInstanceState);
        }
    }
}
