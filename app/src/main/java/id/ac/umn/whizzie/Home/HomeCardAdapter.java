package id.ac.umn.whizzie.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.umn.whizzie.IntentMovement;
import id.ac.umn.whizzie.ProfileActivity;
import id.ac.umn.whizzie.R;

import java.util.List;


public class HomeCardAdapter extends RecyclerView.Adapter<HomeCardAdapter.HomeCardHolder> {
    private Context ctx;
    private List<HomeCard> hcList;

    public HomeCardAdapter(Context ctx, List<HomeCard> hcList) {
        this.ctx = ctx;
        this.hcList = hcList;
    }

    @NonNull
    @Override
    public HomeCardHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.home_card, null);
        HomeCardHolder holder = new HomeCardHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return hcList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCardAdapter.HomeCardHolder homeCardHolder, int i) {
        HomeCard temp = hcList.get(i);

        homeCardHolder.tvHomeCardTitle.setText(temp.getCreatorName());

        homeCardHolder.btnHomeCardBigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentMovement im = new IntentMovement(ctx);

                im.moveToTargetNormal(ProfileActivity.class);
            }
        });

        homeCardHolder.imagebuttonHomeCardSmallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Akan memfollow

            }
        });
    }

    class HomeCardHolder extends RecyclerView.ViewHolder{
        TextView tvHomeCardTitle;
        ImageView imageviewHomeCardImage;
        Button btnHomeCardBigButton;
        ImageButton imagebuttonHomeCardSmallButton;

        public HomeCardHolder(@NonNull View itemView) {
            super(itemView);

            tvHomeCardTitle = itemView.findViewById(R.id.tvHomeCardTitle);
            imageviewHomeCardImage = itemView.findViewById(R.id.imageviewHomeCardImage);
            btnHomeCardBigButton = itemView.findViewById(R.id.btnHomeCardBigButton);
            imagebuttonHomeCardSmallButton = itemView.findViewById(R.id.imagebuttonHomeCardSmallButton);
        }
    }
}