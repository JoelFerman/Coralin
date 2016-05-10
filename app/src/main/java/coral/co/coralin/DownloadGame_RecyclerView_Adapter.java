package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by joelferman on 4/28/16.
 */
public class DownloadGame_RecyclerView_Adapter extends RecyclerView.Adapter<DownloadedGame_View_Holder> {

    GlobalVars GV = new GlobalVars();
    String gameURL = "http://coral.rosalilastudio.com/game.html?user_email="+GV.userEmail+"&user_token="+GV.userToken+"&current_level=1";
    List<DownloadGameData> list = Collections.emptyList();
    Context context;

    public DownloadGame_RecyclerView_Adapter(List<DownloadGameData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public DownloadedGame_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.downloaded_game_layout, parent, false);
        DownloadedGame_View_Holder holder = new DownloadedGame_View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(final DownloadedGame_View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.txtGameName.setText(list.get(position).gameName);
        holder.imageView.setImageResource(list.get(position).imageId);
        holder.imageView2.setImageResource(list.get(position).imageId2);
        holder.imageView3.setImageResource(list.get(position).imageId3);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gameURL));
                context.startActivity(browserIntent);
            }
        });

        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, DownloadGameData data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(DownloadGameData data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}