package com.zapptitude.firstgrademathapp.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zapptitude.firstgrademathapp.R;

import org.firestar.model.Deck;
import org.firestar.model.DeckBundle;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LevelsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LevelsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LevelsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DECK_BUNDLE = "ARG_DECK_BUNDLE";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private DeckBundle mDeckBundle;

    private OnFragmentInteractionListener mListener;

    public LevelsFragment() {
        // Required empty public constructor
    }

    public static LevelsFragment newInstance(DeckBundle deckBundle) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_DECK_BUNDLE, deckBundle);

        LevelsFragment fragment = new LevelsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDeckBundle = getArguments().getParcelable(ARG_DECK_BUNDLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_levels, container, false);

        //TODO: Implement a dynamic way to pass levels and handle interaction
        rootView.findViewById(R.id.level1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open level1 quiz
                if (mListener != null) {
                    Deck deck = mDeckBundle.getDeckList().get(0);
                    mListener.onLevelClick(deck);
                }
            }
        });

        rootView.findViewById(R.id.level2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open level1 quiz
                if (mListener != null) {
                    Deck deck = mDeckBundle.getDeckList().get(1);
                    mListener.onLevelClick(deck);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onLevelClick(Deck deck);
    }
}
