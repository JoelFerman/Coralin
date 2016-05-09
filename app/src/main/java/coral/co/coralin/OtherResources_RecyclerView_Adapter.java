package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by joelferman on 4/28/16.
 */
public class OtherResources_RecyclerView_Adapter extends RecyclerView.Adapter<OtherResources_View_Holder> {

    List<OtherResourcesData> list = Collections.emptyList();
    Context context;

    public OtherResources_RecyclerView_Adapter(List<OtherResourcesData> list, OtherResourcesFragment context) {
        this.list = list;
        //this.context = context;
    }

    @Override
    public OtherResources_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.other_resources_layout, parent, false);
        OtherResources_View_Holder holder = new OtherResources_View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(final OtherResources_View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.txtOtherResources.setText(list.get(position).title);
        holder.txtOtherResources.setOnClickListener(new View.OnClickListener() {
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
    public void insert(int position, OtherResourcesData data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(OtherResourcesData data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}