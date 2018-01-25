package com.dmb.repasorecuperacionmanel;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dmb.repasorecuperacionmanel.FragmentDadesPersonals.sendPersonalData;
import com.dmb.repasorecuperacionmanel.FragmentHobbies.sendHobbies;

public class MainActivity extends AppCompatActivity implements sendPersonalData, sendHobbies, FragmentBotonera.OnFragmentInteractionListener{

    public static boolean showingFragment;

    String name,age,sex,reading,rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm;
        FragmentTransaction ft;
        fm = getFragmentManager();
        ft = fm.beginTransaction();

        if(showingFragment){
            ft.remove(getFragmentManager().findFragmentById(R.id.mainFragment));
            ft.commit();
            showingFragment = false;
        }else {
            super.onBackPressed();
        }
    }

    public void onFragmentInteraction(Uri uri){}

    public void getPersonalData(String name, String age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void getHobbies(String reading, String rating){
        this.reading = reading;
        this.rating = rating;
    }

    @Override
    public void onResume(){
        super.onResume();
    }
}
