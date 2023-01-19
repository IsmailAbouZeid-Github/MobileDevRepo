package com.example.lab_1_cosc435;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[];
    int images[] = {R.drawable.chad,R.drawable.home,R.drawable.royale,R.drawable.poseidon};
    boolean following = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bolding Some of the Text
        TextView textView = findViewById(R.id.txt_followedby);
        SpannableString spannableString = new SpannableString("Followed By Ismail Abou Zeid and Khalil Farhat");
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        //End of Bolding
        recyclerView = findViewById(R.id.recyclerview);
        s1 = getResources().getStringArray(R.array.picture_captions);

        MyAdapter myAdapter = new MyAdapter(this,s1,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void onClick(View v){
        Button button = findViewById(R.id.btn_follow);
        TextView txtview = findViewById(R.id.txt_followersnbr);
        String txt = "";
        String btn_txt = "";
        int color;
        if (!following){
            txt = "Now Following omararabi100";
            color = R.color.teal_200;
            btn_txt = "Unfollow";
            following = true;
            txtview.setText("172");
        }
        else {
            txt = "Unfollowed omararabi100";
            color = R.color.purple_500;
            btn_txt = "Follow";
            following = false;
            txtview.setText("171");
        }
        Toast.makeText(this,txt,Toast.LENGTH_SHORT).show();
        v.setBackgroundColor(getResources().getColor(color));

        button.setText(btn_txt);

    }
}