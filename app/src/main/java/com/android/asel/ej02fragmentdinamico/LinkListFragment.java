package com.android.asel.ej02fragmentdinamico;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by aselr on 02/02/2017.
 */

public class LinkListFragment extends ListFragment {

    private OnListFragmentSelectionListener mListener;
    private int posicionSeleccionada = -1;

    public LinkListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null)
            posicionSeleccionada = savedInstanceState.getInt("position");

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, MainActivity.titulos));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        if (posicionSeleccionada != -1)
            getListView().setItemChecked(posicionSeleccionada, true);

    }

    public interface OnListFragmentSelectionListener {
        void onListFragmentSelection(int pos);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentSelectionListener) {
            mListener = (OnListFragmentSelectionListener) context;
        } else {
            throw new RuntimeException(context.toString()+" debe implementar OnListFragmentSelectionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //getListView().setSelector(R.color.colorAccentTransparent);
        posicionSeleccionada = position;

        mListener.onListFragmentSelection(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("position", posicionSeleccionada);

    }

}


