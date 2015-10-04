package com.jenzz.materialpreference;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.text.TextUtils.isEmpty;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.jenzz.materialpreference.Typefaces.getRobotoMedium;

import com.alexcruz.papuhwalls.Preferences;
import com.alexcruz.papuhwalls.R;

public class PreferenceCategory extends android.preference.PreferenceCategory {

  Preferences Preferences;

  public PreferenceCategory(Context context) {
    super(context);
  }

  public PreferenceCategory(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public PreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(LOLLIPOP)
  public PreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override
  protected View onCreateView(ViewGroup parent) {
    LayoutInflater layoutInflater =
        (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
    return layoutInflater.inflate(R.layout.mp_preference_category, parent, false);
  }

  @Override
  protected void onBindView(View view) {
    super.onBindView(view);
    this.Preferences = new Preferences(getContext());

    CharSequence title = getTitle();
    TextView titleView = (TextView) view.findViewById(R.id.title);
    titleView.setText(title);
    titleView.setTextColor(Preferences.Accent());
    titleView.setVisibility(!isEmpty(title) ? VISIBLE : GONE);
    titleView.setTypeface(getRobotoMedium(getContext()));
  }
}
