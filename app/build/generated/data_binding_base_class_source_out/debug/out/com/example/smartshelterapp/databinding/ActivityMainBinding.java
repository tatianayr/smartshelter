package com.example.smartshelterapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smartshelterapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button goLogin;

  @NonNull
  public final Button goSignUp;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ScrollView main;

  @NonNull
  public final TextView textView3;

  private ActivityMainBinding(@NonNull ScrollView rootView, @NonNull Button goLogin,
      @NonNull Button goSignUp, @NonNull ImageView imageView5, @NonNull ScrollView main,
      @NonNull TextView textView3) {
    this.rootView = rootView;
    this.goLogin = goLogin;
    this.goSignUp = goSignUp;
    this.imageView5 = imageView5;
    this.main = main;
    this.textView3 = textView3;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {

    int id;
    missingId: {
      id = R.id.goLogin;
      Button goLogin = ViewBindings.findChildViewById(rootView, id);
      if (goLogin == null) {
        break missingId;
      }

      id = R.id.goSignUp;
      Button goSignUp = ViewBindings.findChildViewById(rootView, id);
      if (goSignUp == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      ScrollView main = (ScrollView) rootView;

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      return new ActivityMainBinding((ScrollView) rootView, goLogin, goSignUp, imageView5, main,
          textView3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
