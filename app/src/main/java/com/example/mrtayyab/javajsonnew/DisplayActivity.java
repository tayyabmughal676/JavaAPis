package com.example.mrtayyab.javajsonnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String name = Objects.requireNonNull(getIntent().getExtras()).getString("hero_name");
        String desc = getIntent().getExtras().getString("hero_desc");
        String studio = getIntent().getExtras().getString("hero_studio");
        String cate= getIntent().getExtras().getString("hero_category");
        String epis = getIntent().getExtras().getString("hero_episode");
        String img = getIntent().getExtras().getString("hero_img");


        TextView Name = findViewById(R.id.nameDisplay);
        TextView Desc = findViewById(R.id.descDisplay);
        TextView Studio = findViewById(R.id.studioDisplay);
        TextView Cate = findViewById(R.id.categoreiesDisplay);

        ImageView Img = findViewById(R.id.imageDisplay);



        Name.setText(name);
        Desc.setText(desc);
        Studio.setText(studio);
        Cate.setText(cate);
//        Name.setText(epis);


        Picasso.get().load(img).into(Img);





    }
}
