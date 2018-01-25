package com.dmb.repasorecuperacionmanel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentDadesPersonals.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentDadesPersonals#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDadesPersonals extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText name,age;
    RadioButton rbMale,rbFemale;
    Button btnSaveData;
    String getName,getAge,getSex,checkSex;
    Boolean emptyFields;

    private sendPersonalData spd;

    public FragmentDadesPersonals() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDadesPersonals.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDadesPersonals newInstance(String param1, String param2) {
        FragmentDadesPersonals fragment = new FragmentDadesPersonals();
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
        View v = inflater.inflate(R.layout.fragment_fragment_dades_personals, container, false);

        name = v.findViewById(R.id.etName);
        age = v.findViewById(R.id.etAge);
        btnSaveData = v.findViewById(R.id.btnSaveData);
        rbMale = v.findViewById(R.id.rbMale);
        rbFemale = v.findViewById(R.id.rbFemale);

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spd = (sendPersonalData) getActivity();
                if(checkFields()){
                    getName = name.getText().toString();
                    getAge = age.getText().toString();
                    getSex = checkSex();

                    spd.getPersonalData(getName,getAge,getSex);
                    Toast.makeText(getContext(),"Datos guardados correctamente",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(),"Debes rellenar todos los campos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }

    private boolean checkFields(){
        getName = name.getText().toString();
        getAge = age.getText().toString();
        if (TextUtils.isEmpty(getName)|| TextUtils.isEmpty(getAge)){
            emptyFields = false;
        }else{
            emptyFields = true;
        }
        return emptyFields;
    }

    private String checkSex(){
        getName = name.getText().toString();
        if(rbMale.isChecked()){
            checkSex = "Masculino";
        }else if(rbFemale.isChecked()){
            checkSex = "Femenino";
        }else{
            checkSex = "Nain";
        }
        return checkSex;
    }

    public interface sendPersonalData{
        void getPersonalData(String getName,String getAge,String getSex);
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
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
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
