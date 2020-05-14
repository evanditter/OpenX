package Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.openx.AccountDetail;
import com.example.openx.BuyItemCategory;
import com.example.openx.ImageSlider;
import com.example.openx.MainActivity;
import com.example.openx.R;
import com.example.openx.UpdateActivePosts;
import com.example.openx.UserPostDetail;
import com.example.openx.UserPostDetailTwoOpt;

import java.util.ArrayList;

import Model.ItemData;
import Model.User;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostDetailAdapter extends RecyclerView.Adapter<PostDetailAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ItemData> posts;
    private String opt;
    private ArrayList<String> tagList;

    public PostDetailAdapter(Context context, String postOption) {
        this.context = context;

        // Get the right type of post to display from the profile
        if (postOption.compareToIgnoreCase("Favorites") == 0) {
            this.posts = MainActivity.profile.getFavorites();
        } else if (postOption.compareToIgnoreCase("History") == 0 ||
                   postOption.compareToIgnoreCase("Bought") == 0)  {
            posts = MainActivity.profile.getBought();
        } else if (postOption.compareToIgnoreCase("Active Posts") == 0 ||
                   postOption.compareToIgnoreCase("Buying") == 0){
            posts = MainActivity.profile.getActivePostsBuy();
        } else if (postOption.compareToIgnoreCase("Selling") == 0){
            posts = MainActivity.profile.getActivePostsSell();
        } else if (postOption.compareToIgnoreCase("Sold") == 0){
            posts = MainActivity.profile.getSold();
        }

        opt = postOption;

    }

    @NonNull
    @Override
    public PostDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostDetailAdapter.ViewHolder holder, final int position) {

        // the item to display
        ItemData post = posts.get(position);

        // set heart icon to gray
        //holder.favIcon.setColorFilter( Color.parseColor("#FF9FA6A7"), PorterDuff.Mode.SRC_ATOP);

        if (opt.compareToIgnoreCase("Favorites") == 0)
            holder.favIcon.setVisibility(View.VISIBLE);


        // to display the first picture
        ArrayList<String> img = post.getPictures();
        if (img.size() > 0) {
            int drawID = context.getResources().getIdentifier(img.get(0), "drawable", context.getPackageName());
            holder.itemImg.setImageResource(drawID);
        }

        // display title
        String itemTitle = post.getTitle();
        if (itemTitle != null) {
            holder.title.setText(itemTitle);
        }

        String itemPrice = post.getPrice();
        if (itemTitle != null) {
            holder.price.setText(itemPrice);
        }

        String itemLocation = post.getLocation();
        if (itemTitle != null) {
            holder.location.setText(itemLocation);
        }

        tagList = post.getTags();
        String tagGet = "";
        for (int i = 0; i < tagList.size() && i < 3; i++) {
            tagGet += tagList.get(i) + " ";
        }
        holder.tags.setText(tagGet);

        String sellername = post.getSeller();
        if (itemTitle != null && (opt.compareToIgnoreCase("Selling") != 0 && opt.compareToIgnoreCase("Sold") != 0)) {
            holder.seller.setText(sellername);
        } else {
            holder.seller.setText("You");
        }

        String oxPoints = post.getSellerPoints();
        if (itemTitle != null && (opt.compareToIgnoreCase("Selling") != 0 && opt.compareToIgnoreCase("Sold") != 0)) {
            holder.sellerPoints.setText(oxPoints);
        } else {
            if (opt.compareToIgnoreCase("Selling") == 0 ) {
                holder.sellerPoints.setText(MainActivity.profile.getPoints());
            } else {
                holder.sellerPoints.setText("------");
            }
        }


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView itemImg;
        public TextView title;
        public TextView price;
        public TextView location;
        public ImageView favIcon;
        public TextView tags;
        public TextView seller;
        public TextView sellerPoints;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            favIcon = (ImageView) itemView.findViewById(R.id.favIconId);
            itemImg = (ImageView) itemView.findViewById(R.id.itemPicID);
            title = (TextView) itemView.findViewById(R.id.postDetailTitleID);
            price = (TextView) itemView.findViewById(R.id.itemPriceID);
            location = (TextView) itemView.findViewById(R.id.itemLocationID);
            tags = (TextView) itemView.findViewById(R.id.textView6);
            seller = (TextView) itemView.findViewById(R.id.sellersName_ID);
            sellerPoints = (TextView) itemView.findViewById(R.id.sellersPoints_ID);


        }

        @Override
        public void onClick(View view) {

            // get the position of the row clicked
            int position = getAdapterPosition();
            Intent intent;
            if (opt.compareToIgnoreCase("Selling") == 0) {
                intent = new Intent(context, UpdateActivePosts.class);
                intent.putExtra("option", opt);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }


            String seller = MainActivity.profile.getActivePostsBuy().get(position).getSeller();
            if ((opt.compareToIgnoreCase("Buying") == 0 || opt.compareToIgnoreCase("Active Posts") == 0 ) &&
                seller.compareToIgnoreCase("iLuvPJFleck") == 0) {
                intent = new Intent(context, ImageSlider.class);
                intent.putExtra("option", opt);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }

            //Toast.makeText(context, opt.getOption(), Toast.LENGTH_LONG).show();

        }
    }
}
