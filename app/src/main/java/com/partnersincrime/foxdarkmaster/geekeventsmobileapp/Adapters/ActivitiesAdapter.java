package com.partnersincrime.foxdarkmaster.geekeventsmobileapp.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.partnersincrime.foxdarkmaster.geekeventsmobileapp.Activities.ActivityContainerActivities;
import com.partnersincrime.foxdarkmaster.geekeventsmobileapp.Activities.DetailsActivity;
import com.partnersincrime.foxdarkmaster.geekeventsmobileapp.Models.ActivityModel;
import com.partnersincrime.foxdarkmaster.geekeventsmobileapp.R;

import java.util.List;

import static com.partnersincrime.foxdarkmaster.geekeventsmobileapp.Utilities.Utils.decodeSampledBitmapFromResource;

/**
 * Created by foxdarkmaster on 07-07-2016.
 */
public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {
    private List<ActivityModel> activitiesList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActivitiesAdapter(List<ActivityModel> activitiesList) {
        this.activitiesList = activitiesList;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return activitiesList.size();
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final ActivityModel activityData = activitiesList.get(position);

        holder.mTitleView.setText(activityData.getTitle());
        holder.mTimeStartView.setText(activityData.getTime());
        holder.mLocationView.setText(activityData.getLocation());
        holder.mImageView.setImageBitmap(activityData.getImageId());

        holder.mReadMoreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// button click event
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("ACTIVITY_DATA_POSITION", position);
                v.getContext().startActivity(intent);
            }
        });

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ActivitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_card, parent, false);

        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTitleView;
        protected TextView mTimeStartView;
        protected TextView mLocationView;
        protected ImageView mImageView;
        protected TextView mReadMoreView;

        public ViewHolder(View v) {
            super(v);

            mTitleView = (TextView) v.findViewById(R.id.card_title);
            mTimeStartView = (TextView) v.findViewById(R.id.card_hour_start);
            mLocationView = (TextView) v.findViewById(R.id.card_location);
            mImageView = (ImageView) v.findViewById(R.id.card_image);

            mReadMoreView = (TextView) v.findViewById(R.id.card_read_more);
        }
    }
}
