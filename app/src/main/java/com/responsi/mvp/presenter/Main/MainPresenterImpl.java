package com.responsi.mvp.presenter.Main;




import com.responsi.mvp.model.People;
import com.responsi.mvp.network.ApiService;
import com.responsi.mvp.network.PeopleService;
import com.responsi.mvp.view.activity.main.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private People people;
    private ApiService service = new ApiService();

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void load() {
        service
                .getNetwork()
                .create(PeopleService.class)
                .getData()
                .enqueue(new Callback<People>() {
                    @Override
                    public void onResponse(Call<People> call, Response<People> response) {
                        people = response.body();

                        if (people.getResults() != null) {
                            mainView.onLoad(people);
                        }
                    }

                    @Override
                    public void onFailure(Call<People> call, Throwable t) {

                    }
                });
    }

}
