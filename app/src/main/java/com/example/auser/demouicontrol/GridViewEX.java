package com.example.auser.demouicontrol;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEX extends AppCompatActivity {
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_ex);
        gridView=findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

    }
    class ImageAdapter extends BaseAdapter{
int[] imageResIds ={
        R.drawable.img001,R.drawable.img002,R.drawable.img003,
        R.drawable.img004,R.drawable.img005,R.drawable.img006,
        R.drawable.img007,R.drawable.img008,R.drawable.img009,
        R.drawable.img010,R.drawable.img011,R.drawable.img012,

};
Context mCtx;
ImageAdapter(Context context){
    mCtx =context;

}
        @Override
        public int getCount() {
            return imageResIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgView=new ImageView(mCtx);
            imgView.setLayoutParams(new GridView.LayoutParams(150,150));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setImageResource(imageResIds[position]);

            return imgView;
        }
    }
}
