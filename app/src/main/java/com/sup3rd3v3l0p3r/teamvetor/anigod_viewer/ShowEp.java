package com.sup3rd3v3l0p3r.teamvetor.anigod_viewer;

/**
 * Created by dlals on 2017-06-03.
 */

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ShowEp extends AppCompatActivity {

    ListView listview;
    ListViewAdapter adapter;


    private String htmlContentInStringFormat;
    private String htmlPageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.ani_list);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        htmlPageUrl = intent.getStringExtra("URL");

        adapter = new ListViewAdapter();
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                Toast.makeText(getApplicationContext(),item.getTitle() ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), aniView.class);
                intent.putExtra("URL",item.getUrl());
                startActivity(intent);
            }
        }) ;

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
                adapter = new ListViewAdapter();

                Document doc = Jsoup.connect(htmlPageUrl).get();
                Elements links = doc.select("table tbody tr td a");

                for (Element link : links)
                    adapter.addItem(link.attr("title"),"",link.attr("href"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("END", "끝");
            return null;
        }

        @Override
        public void onPostExecute(Void result) {
            listview = (ListView) findViewById(R.id.listview1);
            listview.setAdapter(adapter);
        }
    }
}

