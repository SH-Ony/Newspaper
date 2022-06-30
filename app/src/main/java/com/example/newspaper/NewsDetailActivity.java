package com.example.newspaper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    String title,description,content,imgurl,url;

    private TextView titletv,subtv,contenttv;
    private ImageView newsiv;
    private Button readbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        title=getIntent().getStringExtra("title");
        content=getIntent().getStringExtra("content");
        description=getIntent().getStringExtra("description");
        imgurl=getIntent().getStringExtra("image");
        Log.e("tag",imgurl);
        url=getIntent().getStringExtra("url");

        titletv=findViewById(R.id.tvnewsdetailtitle);
        subtv=findViewById(R.id.tvsubdec);
        contenttv=findViewById(R.id.tvcontent);
        newsiv=findViewById(R.id.ivnews);
        readbtn=findViewById(R.id.btnfullnews);

        titletv.setText(title);
        subtv.setText(description);
        contenttv.setText(content);
        //Picasso.get().load(imgurl).into(newsiv);
        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }
}