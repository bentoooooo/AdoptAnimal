package pt.ipbeja.adoptanimal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentAnimal extends Fragment {

    public ContentAnimal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content_animal, container, false);
    }

    @Override public void onStart() {
        super.onStart();
        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            int currentPosition = args.getInt("position");
            updateContentView(currentPosition);
        }
        else{
            updateContentView(0);
        }
    }

    public void updateContentView( int position){
        TextView content = (TextView) getActivity().findViewById(R.id.txtContent);
        content.setText(Animals.ListContent.get(position));
        ImageView photo = (ImageView) getActivity().findViewById(R.id.imageAnimal);
        photo.setImageResource(Animals.ListPhoto.get(position));
    }
}

