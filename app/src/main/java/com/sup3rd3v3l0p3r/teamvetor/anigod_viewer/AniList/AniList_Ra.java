package com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.ListViewAdapter;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.ListViewItem;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.R;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.ShowEp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AniList_Ra extends AppCompatActivity {

    ListView listview;
    ListViewAdapter adapter;


    private String htmlContentInStringFormat;
    private String htmlPageUrl = "http://ani.today/leftside";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.ani_list);
        super.onCreate(savedInstanceState);

        adapter = new ListViewAdapter();
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                Toast.makeText(getApplicationContext(),item.getTitle() ,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ShowEp.class);
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
                Elements links = doc.select("div[data-category^=2] div[data-category^=ㄹ] a[href]");

                for (Element link : links)
                    adapter.addItem( link.text().trim(),"",link.attr("abs:href"));
//                    htmlContentInStringFormat += (link.attr("abs:href") + "(" + link.text().trim() + ")\n");
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

