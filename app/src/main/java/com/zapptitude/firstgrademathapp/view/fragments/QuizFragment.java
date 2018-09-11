package com.zapptitude.firstgrademathapp.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zapptitude.firstgrademathapp.R;
import com.zapptitude.firstgrademathapp.view.fragments.dummy.DummyContent;

import org.firestar.model.Deck;
import org.firestar.model.DeckCard;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class QuizFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_DECK = "ARG_DECK";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private Deck mDeck;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public QuizFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static QuizFragment newInstance(Deck deck) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_DECK, deck);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mDeck = getArguments().getParcelable(ARG_DECK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(
                    new TaskRecyclerViewAdapter(mDeck.getDeckCardList(), mListener));

            PagerSnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView((RecyclerView) view);
            ((RecyclerView) view).setLayoutManager(
                    new LinearLayoutManager(
                            context, LinearLayoutManager.HORIZONTAL ,
                            false));

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DeckCard task);
    }
}
