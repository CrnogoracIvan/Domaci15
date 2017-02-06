package Fragmenti;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Provajderi_Liste.ProvajderJela;

import com.example.ivancrnogorac.domacizadatak15.R;

/**
 * Created by androiddevelopment on 6.2.17..
 */

public class ListFragment extends Fragment {

    //prvo se rucno postavi na kraju nova metoda pa se onda kreiran ovo:
    OnItemSelectedListener listener;

    // onCreate method is a life-cycle method that is called when creating the fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "listFragment.onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "ListFragmetn.onActivityCreated()", Toast.LENGTH_SHORT).show();

        // Loads jela from array resource
        final List<String> imenaJela = ProvajderJela.getImenaJela();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, imenaJela);
        ListView listView = (ListView) getActivity().findViewById(R.id.listaJela);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);

        // Updates DetailFragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });

    }

    // Container activity must implement this interface
    //Rucno pravljenje metode OnItemSelectedListener
    public interface OnItemSelectedListener {

        public void onItemSelected(int position);
    }

    // onCreateView method is a life-cycle method that is called to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "ListFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.list_fragment_layaout, container, false);

        return view;
    }

}
