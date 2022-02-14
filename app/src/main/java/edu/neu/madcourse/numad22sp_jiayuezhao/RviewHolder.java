package edu.neu.madcourse.numad22sp_jiayuezhao;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder {

        public TextView itemName;
        public TextView itemDesc;

        public RviewHolder(View itemView, final ItemClickListener listener) {
            super(itemView);
            this.itemName = itemView.findViewById(R.id.item_name);
            this.itemDesc = itemView.findViewById(R.id.item_desc);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        //which item did we just tap in and get its location
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            String url = itemDesc.getText().toString();
                            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                                url = "http://" + url;
                            }
                            Log.i("Location , ", url);
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            (itemView.getContext()).startActivity(browserIntent);

                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
}
