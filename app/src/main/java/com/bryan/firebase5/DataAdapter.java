package com.bryan.firebase5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DataAdapter extends FirebaseRecyclerAdapter<Data, DataAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public DataAdapter(@NonNull FirebaseRecyclerOptions<Data> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Data model) {
        holder.name.setText(model.getName());
        holder.course.setText(model.getCourse());
        holder.email.setText(model.getEmail());
        Glide.with(holder.purl.getContext()).load(model.getPurl()).into(holder.purl);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data, parent, false);
        return new myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView purl;
        TextView name, course, email;
        List<Data> mListData;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            purl = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name_text_view);
            course = itemView.findViewById(R.id.course_text_view);
            email = itemView.findViewById(R.id.email_text_view);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
//            Intent intent = new Intent(v.getContext(), ItemView.class);
//            intent.putExtra("name", mListData.get(position).getName()); // sending name to the cardview
//            intent.putExtra("pic",mListData.get(position).getPurl()); // sending pics to the cardview
//            v.getContext().startActivity(intent); //start next activity from view
        }
    }
}
