package com.beone.samplemvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.beone.samplemvp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainView {

  private MainPresenter mainPresenter;
  private ActivityMainBinding activityMainBinding;
  private static String TAG = MainActivity.class.getSimpleName();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(activityMainBinding.getRoot());
    mainPresenter = new MainPresenter(this);

    mainPresenter.onFinished(new DataModel("Billy"));

    activityMainBinding.textviewTitlecenter.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mainPresenter.onItemClicked("Get Click From Presenter");
        Log.d(TAG, "onClick: ");
      }
    });
  }

  @Override
  public void showProgress() {
    activityMainBinding.textviewTitlecenter.setText("Loading");
  }

  @Override
  public void hideProgress() {
    activityMainBinding.textviewTitlecenter.setText("Not Loading Again");
  }

  @Override
  public void setItem(DataModel item) {
    activityMainBinding.textviewTitlecenter.setText(item.getNama());
  }

  @Override
  public void showMessage(String message) {
    activityMainBinding.textviewTitlecenter.setText(message);
  }

  @Override
  protected void onResume() {
    mainPresenter.onResume();
    super.onResume();
  }

  @Override
  protected void onDestroy() {
    mainPresenter.onDestroy();
    super.onDestroy();
  }
}
