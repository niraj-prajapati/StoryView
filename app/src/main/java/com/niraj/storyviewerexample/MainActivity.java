/*
 * Created by Niraj Prajapati on 30/4/21 12:07 PM
 * Copyright (c) 2021. All rights reserved.
 * Last modified at 30/4/21 12:07 PM
 */

package com.niraj.storyviewerexample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.niraj.storyviewer.data.Story;
import com.niraj.storyviewer.data.StoryUser;
import com.niraj.storyviewer.screen.StoryViewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnOpenStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenStories = findViewById(R.id.btnOpenStories);

        btnOpenStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<StoryUser> storyUsers = new ArrayList<>();
                ArrayList<Story> stories = new ArrayList<>();
                stories.add(new Story("https://player.vimeo.com/external/403295268.sd.mp4?s=3446f787cefa52e7824d6ce6501db5261074d479&profile_id=165&oauth2_token_id=57447761", 0L));
                stories.add(new Story("https://player.vimeo.com/external/409206405.sd.mp4?s=0bc456b6ff355d9907f285368747bf54323e5532&profile_id=165&oauth2_token_id=57447761", 0L));
                stories.add(new Story("https://player.vimeo.com/external/403295710.sd.mp4?s=788b046826f92983ada6e5caf067113fdb49e209&profile_id=165&oauth2_token_id=57447761", 0L));
                stories.add(new Story("https://player.vimeo.com/external/394678700.sd.mp4?s=353646e34d7bde02ad638c7308a198786e0dff8f&profile_id=165&oauth2_token_id=57447761", 0L));
                stories.add(new Story("https://player.vimeo.com/external/405333429.sd.mp4?s=dcc3bdec31c93d87c938fc6c3ef76b7b1b188580&profile_id=165&oauth2_token_id=57447761", 0L));
                stories.add(new Story("https://player.vimeo.com/external/363465031.sd.mp4?s=15b706ccd3c0e1d9dc9290487ccadc7b20fff7f1&profile_id=165&oauth2_token_id=57447761", 0L));
                stories.add(new Story("https://player.vimeo.com/external/422787651.sd.mp4?s=ec96f3190373937071ba56955b2f8481eaa10cce&profile_id=165&oauth2_token_id=57447761", 0L));

                storyUsers.add(new StoryUser("user 1","https://randomuser.me/api/portraits/men/1.jpg",stories));

                StoryViewActivity.Companion.setStoryUserList(storyUsers);
                StoryViewActivity.Companion.setCurrentPage(3);
                StoryViewActivity.Companion.build(MainActivity.this);
            }
        });
    }
}