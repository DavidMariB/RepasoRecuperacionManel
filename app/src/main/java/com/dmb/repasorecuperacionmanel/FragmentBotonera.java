package com.dmb.repasorecuperacionmanel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBotonera.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBotonera#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBotonera extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Button btnPersonalData,btnHobbies;
    ImageButton btnInfo;
    String userName,userAge,userSex,userReading,userRating;

    FragmentManager fm;
    FragmentTransaction ft;

    public FragmentBotonera() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBotonera.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBotonera newInstance(String param1, String param2) {
        FragmentBotonera fragment = new FragmentBotonera();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment_botonera, container, false);

        btnPersonalData = v.findViewById(R.id.btn_dades_personals);
        btnHobbies = v.findViewById(R.id.btn_aficions);
        btnInfo = v.findViewById(R.id.btn_info);

        btnPersonalData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
                ft = fm.beginTransaction();
                ft.add(R.id.mainFragment,FragmentDadesPersonals.newInstance("",""));
                ft.addToBackStack(null);
                ft.commit();
                Toast.makeText(getContext(), "Datos Personales", Toast.LENGTH_SHORT).show();
            }
        });

        btnHobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
                ft = fm.beginTransaction();
                ft.add(R.id.mainFragment,FragmentHobbies.newInstance("",""));
                ft.addToBackStack(null);
                ft.commit();
                Toast.makeText(getContext(),"Aficiones",Toast.LENGTH_SHORT).show();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity userData = (MainActivity) getActivity();

                Intent intent = new Intent(userData,ShowDataActivity.class);
                startActivity(intent);

                userName = userData.name;
                userAge = userData.age;
                userSex = userData.sex;
                userReading = userData.reading;
                userRating = userData.rating;

                intent.putExtra("userName",userName);
                intent.putExtra("userAge",userAge);
                intent.putExtra("userSex",userSex);
                intent.putExtra("userReading",userReading);
                intent.putExtra("userRating",userRating);

                startActivity(intent);
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
