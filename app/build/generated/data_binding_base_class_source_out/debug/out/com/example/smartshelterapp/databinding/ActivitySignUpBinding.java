package com.example.smartshelterapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivitySignUpBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final EditText age;

  @NonNull
  public final EditText firstName;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final EditText lastName;

  @NonNull
  public final EditText password;

  @NonNull
  public final Button registerBtn;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final EditText userName;

  private ActivitySignUpBinding(@NonNull ScrollView rootView, @NonNull EditText age,
      @NonNull EditText firstName, @NonNull ImageView imageView, @NonNull EditText lastName,
      @NonNull EditText password, @NonNull Button registerBtn, @NonNull TextView textView2,
      @NonNull EditText userName) {
    this.rootView = rootView;
    this.age = age;
    this.firstName = firstName;
    this.imageView = imageView;
    this.lastName = lastName;
    this.password = password;
    this.registerBtn = registerBtn;
    this.textView2 = textView2;
    this.userName = userName;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignUpBinding bind(@NonNull View rootView) {
    int id;
    missingId: {
      id = R.id.age;
      EditText age = ViewBindings.findChildViewById(rootView, id);
      if (age == null) {
        break missingId;
      }

      id = R.id.firstName;
      EditText firstName = ViewBindings.findChildViewById(rootView, id);
      if (firstName == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.lastName;
      EditText lastName = ViewBindings.findChildViewById(rootView, id);
      if (lastName == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.registerBtn;
      Button registerBtn = ViewBindings.findChildViewById(rootView, id);
      if (registerBtn == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.userName;
      EditText userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      return new ActivitySignUpBinding((ScrollView) rootView, age, firstName, imageView, lastName,
          password, registerBtn, textView2, userName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
