package com.brasco.simwechat;

import android.os.Bundle;

public class PostActivity extends IBActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ActionBar("My Posts");
    }
}