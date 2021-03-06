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

        binding.setNumber(12);
        binding.setBindy(model);
        binding.setListener(new Listener(binding));

        // Dynamic Binding
        // To fully take advantage of data binding library
        // you can bind to a type dynamically. Therefore you do not need to know the specific type
        // you just need to know the variable exists and it will take any object value (no need to cast)

        // The BR class is generated at compile time so it knows about defined variables within your layout

        BindingModel model2 = new BindingModel("Some message text", "a subtitle");

        binding.setVariable(io.daio.databinding.BR.model, model2);

        return binding.getRoot();

    }

    // Create a listener that implements OnClickListener
    public class Listener implements View.OnClickListener {

        private FragmentMainBinding binding;

        // Pass in the binding on constructor so that we can get access
        // to the bound properties
        public Listener(FragmentMainBinding binding) {
            this.binding = binding;
        }

        // in the onclick we can then get the number from the binding and
        // increment and set the number again
        // this then updates the view by the binding
        @Override
        public void onClick(View v) {
            int number = binding.getNumber();
            binding.setNumber(++number);
        }
    }
}
