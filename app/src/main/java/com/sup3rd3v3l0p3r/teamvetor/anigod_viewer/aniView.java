package com.sup3rd3v3l0p3r.teamvetor.anigod_viewer;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class aniView extends AppCompatActivity {
    String htmlPageUrl = "";
    String htmlContentInStringFormat = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ani_view);

        VideoView videoView = (VideoView) findViewById(R.id.vidioView);
        final MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);//동영상 재생 설정

        Intent intent = getIntent();
        htmlPageUrl = intent.getStringExtra("URL");

        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();
    }

    class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        public Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect(htmlPageUrl).get();
                Elements links = doc.select("source[src]");

                for (Element link : links)
                    htmlContentInStringFormat = link.attr("abs:src");

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Void result) {
            VideoView videoView = (VideoView) findViewById(R.id.vidioView);
            Uri uri = Uri.parse(htmlContentInStringFormat);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        }
    }
}
