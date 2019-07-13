package com.responsi.mvp.view.activity.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.responsi.mvp.R;
import com.responsi.mvp.model.People;
import com.responsi.mvp.model.ResultsItem;
import com.responsi.mvp.presenter.Main.MainPresenterImpl;
import com.responsi.mvp.view.adapter.RV_Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  MainView {
    private RecyclerView rv;
    private RV_Adapter adapter = new RV_Adapter();
    private MainPresenterImpl presenter;
    private List<ResultsItem> item = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findView();
    }

    private void findView() {
        rv = findViewById(R.id.rv_Main);
        rv.setAdapter(adapter);
    }

    private void init() {
        presenter = new MainPresenterImpl(this);
        presenter.load();
        adapter.setAct(this);
    }

    @Override
    public void onLoad(People people) {
        item.addAll(people.getResults());
        adapter.setData(item);
        adapter.notifyDataSetChanged();
    }





}
