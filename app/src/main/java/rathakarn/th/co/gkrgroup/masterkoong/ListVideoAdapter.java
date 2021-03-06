package rathakarn.th.co.gkrgroup.masterkoong;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListVideoAdapter extends RecyclerView.Adapter<ListVideoAdapter.ListVideoViewHolder>{

    private Context context;
    private ArrayList<String> nameStringArrayList, iconStringArrayList, durationStringArrayList, detailStringArrayList;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;

    public ListVideoAdapter(Context context, ArrayList<String> nameStringArrayList, ArrayList<String> iconStringArrayList, ArrayList<String> durationStringArrayList, ArrayList<String> detailStringArrayList, OnClickItem onClickItem) {
        this.layoutInflater = LayoutInflater.from(context);
        this.nameStringArrayList = nameStringArrayList;
        this.iconStringArrayList = iconStringArrayList;
        this.durationStringArrayList = durationStringArrayList;
        this.detailStringArrayList = detailStringArrayList;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public ListVideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.recycler_video, viewGroup, false);
        ListVideoViewHolder listVideoViewHolder = new ListVideoViewHolder(view);

        return listVideoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListVideoViewHolder listVideoViewHolder, int i) {

        String name = nameStringArrayList.get(i);
        String urlImage = iconStringArrayList.get(i);
        String duration = "Duration : " + durationStringArrayList.get(i);
        String detail = detailStringArrayList.get(i);


        listVideoViewHolder.nameTextView.setText(name);
        Picasso.get().load(urlImage).into(listVideoViewHolder.iconImageView);

        listVideoViewHolder.durationTextView.setText(duration);
        listVideoViewHolder.detailTextView.setText(detail);

        listVideoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickItem(v, listVideoViewHolder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameStringArrayList.size();
    }

    public class ListVideoViewHolder extends RecyclerView.ViewHolder {

        private ImageView iconImageView;
        private TextView nameTextView;
        private TextView durationTextView, detailTextView;

        public ListVideoViewHolder(@NonNull View itemView) {
            super(itemView);

            iconImageView = itemView.findViewById(R.id.imvIcon);
            nameTextView = itemView.findViewById(R.id.txtName);
            durationTextView = itemView.findViewById(R.id.txtDuration);
            detailTextView = itemView.findViewById(R.id.txtDetail);

        }
    }

}   // Main Class
