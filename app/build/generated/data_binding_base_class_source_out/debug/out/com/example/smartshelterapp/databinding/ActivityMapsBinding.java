package com.example.smartshelterapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smartshelterapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMapsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button direction;

  @NonNull
  public final Button goMove;

  @NonNull
  public final Button goTemp;

  private ActivityMapsBinding(@NonNull LinearLayout rootView, @NonNull Button direction,
      @NonNull Button goMove, @NonNull Button goTemp) {
    this.rootView = rootView;
    this.direction = direction;
    this.goMove = goMove;
    this.goTemp = goTemp;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_maps, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMapsBinding bind(@NonNull View rootView) {

    int id;
    missingId: {
      id = R.id.direction;
      Button direction = ViewBindings.findChildViewById(rootView, id);
      if (direction == null) {
        break missingId;
      }

      id = R.id.goMove;
      Button goMove = ViewBindings.findChildViewById(rootView, id);
      if (goMove == null) {
        break missingId;
      }

      id = R.id.goTemp;
      Button goTemp = ViewBindings.findChildViewById(rootView, id);
      if (goTemp == null) {
        break missingId;
      }

      return new ActivityMapsBinding((LinearLayout) rootView, direction, goMove, goTemp);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
