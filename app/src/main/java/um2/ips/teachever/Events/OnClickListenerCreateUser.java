package um2.ips.teachever.Events;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import um2.ips.teachever.Entities.Eleve;
import um2.ips.teachever.Entities.Parent;
import um2.ips.teachever.R;
import um2.ips.teachever.bdd.tabEleveController;
import um2.ips.teachever.bdd.tabParentController;

public class OnClickListenerCreateUser implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        final Context context = view.getRootView().getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.user_input_form, null, false);
        final RadioGroup RadioGroupUserCreate = (RadioGroup) formElementsView.findViewById(R.id.RadioGroupUserCreate);
//        final RadioButton RadioEleve = (RadioButton) formElementsView.findViewById(R.id.RadioGroupUserCreate).findViewById(R.id.radio_eleve);
        final RadioButton RadioEleve = RadioGroupUserCreate.findViewById(R.id.radio_eleve);
        final RadioButton RadioParent = RadioGroupUserCreate.findViewById(R.id.radio_parent);
        //        final RadioButton RadioParent = (RadioButton) formElementsView.findViewById(R.id.RadioGroupUserCreate).findViewById(R.id.radio_parent);
        final EditText editTextUserFirstname = (EditText) formElementsView.findViewById(R.id.editTextUserFirstname);
        final EditText editTextUserLastname = (EditText) formElementsView.findViewById(R.id.editTextUserLastname);
        final EditText editTextUserEmail = (EditText) formElementsView.findViewById(R.id.editTextUserEmail);
        final EditText editTextUserPassword = (EditText) formElementsView.findViewById(R.id.editTextUserPassword);
        final Spinner spinnerUserCreate = (Spinner) formElementsView.findViewById(R.id.spinnerUserCreate);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.Annee_Scolaire, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerUserCreate.setAdapter(adapter);

        RadioGroupUserCreate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radio_eleve) {
                    spinnerUserCreate.setVisibility(spinnerUserCreate.VISIBLE);
                } else if (checkedId == R.id.radio_parent) {
                    spinnerUserCreate.setVisibility(spinnerUserCreate.INVISIBLE);
                }

            }
        });

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Create Student")
                .setPositiveButton("Créer", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {

                    String UserFirstname = editTextUserFirstname.getText().toString();
                    String UserLastname = editTextUserLastname.getText().toString();
                    String UserEmail = editTextUserEmail.getText().toString();
                    String UserPassword = editTextUserPassword.getText().toString();



                    if (RadioEleve.isChecked()) {
                        String Annee = spinnerUserCreate.toString();
                        Eleve eleve = new Eleve(UserLastname, UserFirstname, UserEmail, UserPassword, Annee);
                        boolean createSuccessful = new tabEleveController(context).create(eleve);
                        if(createSuccessful){
                            Toast.makeText(context, "Eleve information was saved.", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "Unable to save Eleve information.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Parent parent = new Parent(UserLastname, UserFirstname, UserEmail, UserPassword);
                        boolean createSuccessful = new tabParentController(context).create(parent);
                        if(createSuccessful){
                            Toast.makeText(context, "Parent information was saved.", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "Unable to save parent information.", Toast.LENGTH_SHORT).show();
                        }
                    }


                    dialog.cancel();

                }

            }).show();



    }


}
