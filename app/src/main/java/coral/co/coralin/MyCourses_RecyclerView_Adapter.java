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
 * Created by joelferman on 5/2/16.
 */
public class MyCourses_RecyclerView_Adapter extends RecyclerView.Adapter<MyCourses_View_Holder> {
    List<MyCoursesData> list = Collections.emptyList();
    Context context;

    public MyCourses_RecyclerView_Adapter(List<MyCoursesData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyCourses_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        MyCourses_View_Holder holder = new MyCourses_View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(final MyCourses_View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
        holder.imageView.setImageResource(list.get(position).imageId);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLesson = new Intent(context, LessonsActivity.class);
                context.startActivity(goLesson);
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
    public void insert(int position, MyCoursesData data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(MyCoursesData data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}