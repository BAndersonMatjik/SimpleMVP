package com.beone.samplemvp;

import java.util.List;

public interface MainView {

  void showProgress();

  void hideProgress();

  void setItem(DataModel item);

  void showMessage(String message);


}
