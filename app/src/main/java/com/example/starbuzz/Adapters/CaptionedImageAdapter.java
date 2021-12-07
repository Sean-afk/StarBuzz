package com.example.starbuzz.Adapters;

import android.graphics.drawable.Drawable;
import android.location.GpsStatus;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starbuzz.R;

public class CaptionedImageAdapter extends RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder> {

    private String[] captions;  //We’re using these variables for the captions and image resource IDs.
    private int[] imageIds;
    private Listener listener;  //Add the Listener as a private variable.

    public interface Listener{  //Add the interface.
        void onClick(int position);
    }

    public CaptionedImageAdapter(String[] captions, int[] imageIds) { //Pass data to the adapter in its constructor.
        this.captions = captions;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public CaptionedImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,parent,false);
        return new ViewHolder(cardView); //Use the layout we created earlier for the CardViews.
    }

    @Override
    public void onBindViewHolder(@NonNull CaptionedImageAdapter.ViewHolder holder,final int position) { //You need to change the position variable to final, as it's used in an inner class.
        CardView cardView = holder.cardView;
        ImageView imageView =cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView = cardView.findViewById(R.id.info_text);  //Populate the CardView’s ImageView and TextView with data.
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //When the CardView is clicked, call the Listener onClick() method.
                if(listener != null){
                    listener.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() { //The number of data items
        return captions.length;
    }

    public void setListener(Listener listener){  //Activities and fragments will use this method to register as a listener.
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(@NonNull CardView itemView) {  //Each ViewHolder will display a CardView.
            super(itemView);
            cardView = itemView;
        }
    }
}
