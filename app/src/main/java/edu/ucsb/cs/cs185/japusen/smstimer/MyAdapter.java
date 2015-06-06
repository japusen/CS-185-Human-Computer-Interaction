package edu.ucsb.cs.cs185.japusen.smstimer;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ImageViewHolder>{
    LinkedList<String> texts;
    Context context;

    MyAdapter(Context context, LinkedList<String> texts){
        this.context = context;
        this.texts = texts;
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        ImageViewHolder ivh = new ImageViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int i) {
        holder.text.setText(texts.get(i));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text;

        ImageViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            text = (TextView)itemView.findViewById(R.id.text_view);
//            image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // item clicked
//                    Intent intent = new Intent(context, Multitouch.class);
//                    intent.putExtra("PATH", image.getTag().toString());
//                    context.startActivity(intent);
//                }
//            });
        }
    }
}