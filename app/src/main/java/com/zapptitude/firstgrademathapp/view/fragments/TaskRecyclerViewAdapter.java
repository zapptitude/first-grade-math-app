package com.zapptitude.firstgrademathapp.view.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zapptitude.firstgrademathapp.R;
import com.zapptitude.firstgrademathapp.view.fragments.QuizFragment.OnListFragmentInteractionListener;

import org.firestar.model.DeckCard;

import java.util.List;

import timber.log.Timber;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DeckCard} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder> {

    private final List<DeckCard> mValues;
    private final OnListFragmentInteractionListener mListener;

    public TaskRecyclerViewAdapter(List<DeckCard> tasks, OnListFragmentInteractionListener listener) {
        mValues = tasks;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_level_expr, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTask = mValues.get(position);

        final String equation = mValues.get(position).getTitle();
        holder.mTaskEquation.setText(equation);
        holder.mTaskAnswer.setHint(R.string.hint_enter_answer);

        //TODO: Get this value from settings (sharedPrefs)
        holder.mNumTasks.setText("10");

        holder.mTaskAnswer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String answer = v.getText().toString();
                Timber.d("Answer entered: " + answer);
                if (isCorrect(equation, answer)) {
                    holder.mTaskFeedback.setText("Correct. Great work !");
                } else {
                    holder.mTaskFeedback.setText("Wrong. Try again !");
                }
                return false;
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mTask);
                }
            }
        });

    }

    //TODO: Add real implementation for answer checking
    private boolean isCorrect(String equation, String inputAnswer) {
        boolean success = false;

        //TODO: Do your magic to find out correct value for missing part and return feedbacl
        return success;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTaskEquation;
        public final TextView mTaskAnswer;
        public final TextView mTaskFeedback;

        public final TextView mNumTasks;
        //TODO: Add more UI elements handling here

        public DeckCard mTask;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTaskEquation = view.findViewById(R.id.taskEquation);
            mTaskAnswer = view.findViewById(R.id.taskAnswer);
            mTaskFeedback = view.findViewById(R.id.taskFeedback);
            mNumTasks = view.findViewById(R.id.num_tasks);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTaskEquation.getText() + "'";
        }
    }
}
