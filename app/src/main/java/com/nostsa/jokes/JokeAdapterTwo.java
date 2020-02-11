package com.nostsa.jokes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class JokeAdapterTwo extends ArrayAdapter<Joke>{
    ArrayList<Joke> jokes;
        int resource;
        Context context;

public JokeAdapterTwo(  Context context, int resource,   ArrayList<Joke> jokes) {
        super(context, resource, jokes);
        this.jokes=jokes;
        this.context=context;
        this.resource=resource;
        }


    @Override
    public View getView(int position,   View convertView,   ViewGroup parent) {

        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_item,null,true);
        }

        Joke joke=jokes.get(position);

        TextView category= (TextView) convertView.findViewById(R.id.category);
        category.setText(joke.getCategory());

        TextView type= (TextView) convertView.findViewById(R.id.type);
        type.setText(joke.getType());

        TextView onejoke = (TextView) convertView.findViewById(R.id.monadiko);
        onejoke.setText(joke.getOnejoke());





        return convertView;
    }

    @Override
    public void notifyDataSetChanged() // Create this function in your adapter class
    {
        super.notifyDataSetChanged();
    }
}
