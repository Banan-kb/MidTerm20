package com.example.midterm20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.midterm20.R;

public class Activity3 extends ListActivity {

    Integer[] Animals={R.drawable.cub2, R.drawable.deer8, R.drawable.jir1, R.drawable.lioness5, R.drawable.lynx7};

    int [] sounds= new int[]{R.raw.track16,R.raw.track11,R.raw.track12,R.raw.track13,R.raw.track14};

    ImageView img1;
    MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttn23= (Button) findViewById(R.id.bttnAct23);
        Button bttn13= (Button) findViewById(R.id.bttnAct13);

        //GridView grid= (GridView) findViewById(R.id.gridView);
        final ImageView imgL= (ImageView) findViewById(R.id.imageLarge);

        mediaPlayer1= new MediaPlayer();
        mediaPlayer1= MediaPlayer.create(this, sounds[0]);

        String [] att= {"a", "b", "C"};
        setListAdapter(new ArrayAdapter<Integer>(this,
                R.layout.activity_main,
                R.id.text,
                Animals));
//        grid.setAdapter(new ImageAdapter(this));
//
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                imgL.setImageResource(Animals[position]);
//
//                mediaPlayer1.pause();
//
//                mediaPlayer1= new MediaPlayer();
//
//                mediaPlayer1= MediaPlayer.create(Activity3.this, sounds[position]);
//
//                mediaPlayer1.start();
//
//
//
//            }
//        });

        bttn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this, Activity2.class));

            }
        });

        bttn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this, MainActivity.class));

            }
        });
    }

       protected void onListItemClick(ListView l, View v, int position, long id){
        switch (position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://artic.edu")));
                break;
            case 1:
                img1.setImageResource(Animals[position]);
                break;
            case 2:
                img1.setImageResource(Animals[position]);
                break;
            case 3:
                img1.setImageResource(Animals[position]);
                break;
            case 4:
                img1.setImageResource(Animals[position]);
                break;
        }
    }


//    public class ImageAdapter extends BaseAdapter{
//        private Context context;
//
//        public ImageAdapter(Context c){
//            context= c;
//
//        }
//
//        @Override
//        public int getCount() {
//            return Animals.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            img1 = new ImageView(context);
//            img1.setImageResource(Animals[position]);
//            img1.setScaleType(ImageView.ScaleType.FIT_XY);
//            img1.setLayoutParams(new GridView.LayoutParams(330,330));
//            return img1;
//
//        }
//    }
}
