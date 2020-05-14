package Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.openx.AccountDetail;
import com.example.openx.MainActivity;
import com.example.openx.R;
import com.example.openx.UserPostDetail;
import com.example.openx.UserPostDetailTwoOpt;

import Model.User;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private Activity context;
    private String[] options;           // The profile options to chose from

    public ProfileAdapter(Activity context, String[] options) {
        this.context = context;
        this.options = options;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ViewHolder holder, int position) {

        String selOpt = options[position];
        holder.option.setText(selOpt);
    }

    @Override
    public int getItemCount() {
        return options.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView option;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            option = (TextView) itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View view) {
            // get the position of the row clicked
            int position = getAdapterPosition();
            Intent intent;
            String opt = options[position];


            // Active Posts, History
            if ((position == 1) || (position == 3)) {
                intent = new Intent(context, UserPostDetailTwoOpt.class);
                intent.putExtra("option", opt);

                // Account Page
            } else if (position == 0) {
                intent = new Intent(context, AccountDetail.class);
                intent.putExtra("option", opt);

                // favorite
            } else if (position == 2) {
                intent = new Intent(context, UserPostDetail.class);
                intent.putExtra("option", opt);

                // Logout
            } else {
                intent = new Intent(context, MainActivity.class);
                intent.putExtra("option", opt);



            }

            context.startActivity(intent);

            //Toast.makeText(context, opt.getOption(), Toast.LENGTH_LONG).show();
        }


    }
}
