package tashsmit.c4q.nyc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A placeholder fragment containing a simple mFragmentView.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    View mFragmentView;
    WeatherFragment mWeatherFragment;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_main, container, false);
        View weatherCard = mFragmentView.findViewById(R.id.weather_card);
        weatherCard.setOnClickListener(this);

        return mFragmentView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.weather_card:
                mWeatherFragment = new WeatherFragment();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.your_placeholder, mWeatherFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
