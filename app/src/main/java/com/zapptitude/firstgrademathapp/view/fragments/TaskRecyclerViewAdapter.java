package com.zapptitude.firstgrademathapp.view.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zapptitude.firstgrademathapp.R;
import com.zapptitude.firstgrademathapp.view.fragments.QuizFragment.OnListFragmentInteractionListener;

import org.firestar.model.DeckCard;

import java.util.List;

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
                .inflate(R.layout.fragment_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTask = mValues.get(position);
        holder.mTaskEquation.setText(mValues.get(position).getTitle());
        holder.mTaskDescription.setText(mValues.get(position).getDescription());

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

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTaskEquation;
        public final TextView mTaskDescription;

        public DeckCard mTask;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTaskEquation = view.findViewById(R.id.taskEquation);
            mTaskDescription = view.findViewById(R.id.taskDescription);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTaskEquation.getText() + "'";
        }
    }
}
