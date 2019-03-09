package com.wth.testapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;

import com.wth.testapp.Api.ApiService;
import com.wth.testapp.Api.Client;
import com.wth.testapp.Model.Person;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public static ProgressDialog pd;
    private RecyclerView RW;
    private MyAdapter adapter;
    public static final String[] mails = {
            "utanis@viita-concept.com",
            "mtarhan@viita-concept.com",
            "akoroglu@viita-concept.com",
            "scomert@viita-concept.com",
            "ecoskun1@viita-concept.com",
            "esakut@viita-concept.com",
            "ddincer@viita-concept.com",
            "hkocak1@viita-concept.com"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        pd = new ProgressDialog(this);
//        pd.setMessage("Wait");
//        pd.show();
//        RW = findViewById(R.id.recyclerview);
//        RW.setHasFixedSize(true);
//        RW.setLayoutManager(new LinearLayoutManager(this));
//        FetchData f = new FetchData(adapter);
//        f.generate();
//        adapter = new MyAdapter(this, f.getPersonList());
//        pd.dismiss();
        Log.v("meggagee", getPersons().get(2).getFirstName());
    }

    public Activity getActivity() {
        Context context = this;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }


    public List<Person> getPersons() {
        final List<Person> personList = new ArrayList<Person>();
        000
        return personList;
    }


}