package com.beone.samplemvp;

public class MainPresenter {

  private MainView mainView;

  public MainPresenter(MainView mainView) {
    this.mainView = mainView;
  }

  void onResume() {
    if (mainView != null) {
      mainView.showProgress();
    }
  }

  void onItemClicked(String item) {
    if (mainView != null) {
      mainView.showMessage("GetClick");
    }
  }

  void onDestroy() {
    mainView = null;
  }

  void onFinished(DataModel item) {
    if (mainView != null) {
      mainView.setItem(item);
      mainView.hideProgress();
    }
  }

  public MainView getMainView() {
    return mainView;
  }
}
