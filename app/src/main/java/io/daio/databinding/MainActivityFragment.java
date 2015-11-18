package io.daio.databinding;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.daio.databinding.databinding.FragmentMainBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        BindingModel model = new BindingModel("This is a message", "This is a subtitle");

        // I have configured the datasource in the fragment layout xml to
        // take any model that is of type BindingInterface
        // the set method is defined based on the name of your <data> in the xml
        // e.g. if you called your <data name="someData"> the method would be
        // binding.setSomeData(someDataType)
        binding.setBindingInterface(model);
        return binding.getRoot();

    }
}
