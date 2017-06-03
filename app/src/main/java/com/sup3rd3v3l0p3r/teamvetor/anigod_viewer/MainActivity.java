package com.sup3rd3v3l0p3r.teamvetor.anigod_viewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Aa;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_AtoZ;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ba;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Cha;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Da;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ga;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Gga;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ha;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ka;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ma;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Na;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Pa;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ra;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Sa;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ssa;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Ta;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Va;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_Za;
import com.sup3rd3v3l0p3r.teamvetor.anigod_viewer.AniList.AniList_all;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    public void aniView(View v){
        startActivity(new Intent(this,aniView.class));
    }
    public void aniList_All(View v){
        startActivity(new Intent(this,AniList_all.class));
    }
    public void aniList_Ga(View v){startActivity(new Intent(this,AniList_Ga.class));}
    public void aniList_Gga(View v){startActivity(new Intent(this,AniList_Gga.class));}
    public void aniList_Na(View v){startActivity(new Intent(this,AniList_Na.class));}
    public void aniList_Da(View v){startActivity(new Intent(this,AniList_Da.class));}
    public void aniList_Ra(View v){startActivity(new Intent(this,AniList_Ra.class));}
    public void aniList_Ma(View v){startActivity(new Intent(this,AniList_Ma.class));}
    public void aniList_Ba(View v){startActivity(new Intent(this,AniList_Ba.class));}
    public void aniList_Va(View v){startActivity(new Intent(this,AniList_Va.class));}
    public void aniList_Sa(View v){startActivity(new Intent(this,AniList_Sa.class));}
    public void aniList_Ssa(View v){startActivity(new Intent(this,AniList_Ssa.class));}
    public void aniList_Aa(View v){startActivity(new Intent(this,AniList_Aa.class));}
    public void aniList_Za(View v){startActivity(new Intent(this,AniList_Za.class));}
    public void aniList_Cha(View v){startActivity(new Intent(this,AniList_Cha.class));}
    public void aniList_Ka(View v){startActivity(new Intent(this,AniList_Ka.class));}
    public void aniList_Ta(View v){startActivity(new Intent(this,AniList_Ta.class));}
    public void aniList_Pa(View v){startActivity(new Intent(this,AniList_Pa.class));}
    public void aniList_Ha(View v){startActivity(new Intent(this,AniList_Ha.class));}
    public void aniList_AtoZ(View v){startActivity(new Intent(this,AniList_AtoZ.class));}


}
