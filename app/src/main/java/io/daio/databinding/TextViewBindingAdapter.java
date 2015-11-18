package io.daio.databinding;

import android.databinding.BindingAdapter;
import android.widget.TextView;


public class TextViewBindingAdapter {

    // Create a custom binding to a text view to allow setting numbers without parsing
    // this is done with the @BindingAdapter annotation
    // this is then referenced in the xml TextView as app:NumberText="@{some data source}"
    // the app: prefix is redundant here and will actually be defined by the auto schema
    // bind="http://schemas.android.com/apk/res-auto" on the view
    // see fragment_main
    @BindingAdapter("bind:numberText")
    public static void setNumberText(TextView textView, int number) {
        textView.setText(String.valueOf(number));
    }

}
