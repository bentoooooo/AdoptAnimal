package pt.ipbeja.adoptanimal;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



/**
 * A simple {@link Fragment} subclass.
 */
public class ListAnimal extends ListFragment {

    OnListSelectedListener mCallback;

    public interface OnListSelectedListener {
        public void onContentSelected(int position);
    }

    public ListAnimal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, Animals.ListAnimal);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
        //Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_headlines, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);

        mCallback.onContentSelected(pos);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnListSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}