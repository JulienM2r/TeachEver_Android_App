package um2.ips.teachever.Events;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import um2.ips.teachever.Activities.MainActivity;
import um2.ips.teachever.Controller.tabEleveController;
import um2.ips.teachever.R;

public class OnClickListenerUserLogin implements View.OnClickListener {
    tabEleveController tabE = new tabEleveController();
    @Override
    public void onClick(View view) {
        final Context context = view.getRootView().getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.user_login_form, null, false);
        final EditText editTextUserEmail = (EditText) formElementsView.findViewById(R.id.editTextUserEmail);
        final EditText editTextUserPassword = (EditText) formElementsView.findViewById(R.id.editTextUserPassword);


        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Connexion")
                .setPositiveButton("Connexion", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {


                    String UserEmail = editTextUserEmail.getText().toString();
                    String UserPassword = editTextUserPassword.getText().toString();
                    MainActivity.IsLogged = tabE.connect(UserEmail, UserPassword);
                    //boolean IsLogged = tabEleveController.connect(UserEmail, UserPassword);
                    if(MainActivity.IsLogged){
                        Toast.makeText(context, "Bienvenue !", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Email ou Mot de passe incorrect.", Toast.LENGTH_SHORT).show();
                    }

                    dialog.cancel();
                }
            }).show();
    }
}
