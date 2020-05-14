package com.example.openx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.openx.R;

import java.util.List;

public class BuyCardViewAdapter extends RecyclerView.Adapter<BuyCardViewAdapter.BuyCardViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<BuyCardView> buyCardList;

    //getting the context and product list with constructor
    public BuyCardViewAdapter(Context mCtx, List<BuyCardView> buyCardList) {
        this.mCtx = mCtx;
        this.buyCardList = buyCardList;
    }

    @Override
    public BuyCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_buy_card_view, null);
        return new BuyCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BuyCardViewHolder holder, int position) {
        //getting the product of the specified position
        BuyCardView buyCardView = buyCardList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(buyCardView.getitemTitle());
        holder.textViewPrice.setText(String.valueOf(buyCardView.printPrice()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(buyCardView.getImage()));
        holder.textViewTagList.setText(String.valueOf(buyCardView.printTagList()));
    }

    @Override
    public int getItemCount() {
        return buyCardList.size();
    }


    class BuyCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewShortDesc, textViewPrice, textViewTagList;
        ImageView imageView;

        public BuyCardViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTagList = itemView.findViewById(R.id.textViewTagList);
        }

        @Override
        public void onClick(View view){
            mCtx.startActivity(new Intent(mCtx, ImageSlider.class));
        }
    }
}
