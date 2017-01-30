package pt.ipbeja.adoptanimal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListAnimal extends ListFragment {


    public ListAnimal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, animals.animal);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if (getActivity().findViewById(R.id.fragment_list_animal) != null) {
            Toast.makeText(getActivity().getBaseContext(), "Clicked Portrait." + animals.animal[position],
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity().getBaseContext(), "Clicked Landscape." + animals.animal[position],
                    Toast.LENGTH_SHORT).show();
        }

    }
}