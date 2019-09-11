package com.example.lokacar.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lokacar.Menu;
import com.example.lokacar.R;
import com.example.lokacar.data.bo.Agence;
import com.example.lokacar.data.bo.Gerant;
import com.example.lokacar.data.bo.Location;
import com.example.lokacar.data.bo.Vehicule;
import com.example.lokacar.data.dal.AgenceDao;
import com.example.lokacar.data.dal.GerantDao;
import com.example.lokacar.data.dal.VehiculeDao;
import com.example.lokacar.ui.login.LoginViewModel;
import com.example.lokacar.ui.login.LoginViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private GerantDao gerantDao;
    private AgenceDao agenceDao;
    private VehiculeDao vehiculeDao;
    private List<Gerant> listeGerant;
    private TextView loginError;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        // Init dao
        gerantDao = new GerantDao(LoginActivity.this);
        vehiculeDao = new VehiculeDao(LoginActivity.this);
        loginError = (TextView) findViewById(R.id.textViewError);

        // Init des données
        initData();

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                loadingProgressBar.setVisibility(View.VISIBLE);
//                loginViewModel.login(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//                Intent intent = new Intent (LoginActivity.this, Menu.class);
//                startActivity(intent);

                Intent intent = new Intent (LoginActivity.this, Menu.class);
                listeGerant = new ArrayList<>();
                listeGerant = gerantDao.selectAll();
                for (Gerant gerant:listeGerant) {
                    if ( gerant.getLogin().toString().equalsIgnoreCase(usernameEditText.getText().toString())
                            &&
                            gerant.getMdp().toString().equalsIgnoreCase(passwordEditText.getText().toString()) )
                    {
                        Log.i("GERANT", gerant.toString());
                        agenceDao = new AgenceDao(LoginActivity.this);
                        Agence agence = agenceDao.selectById(gerant.getId()) ;
                        intent.putExtra("nomAgence", agence.getNomAgence());
                        intent.putExtra("gerant", gerant.getNom() + " " + gerant.getPrenom());
                        startActivity(intent);
                        break;
                    }else {
                        loginError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    public void initData() {

        // 1ère insertion dans la base Gérant pour pouvoir s'identifier :
        Gerant gerant = new Gerant("MOREL", "Patrick", null,
                "0635259481", "patrick.morel2017@campus-eni.fr", "morel", "mdptest");
        gerantDao.insertGerant(gerant);
        gerantDao.insertGerant(new Gerant("Doe", "John", null, "0652859574",
                "john.doe@gmail.com", "admin", "admin"));

        // 1ère insertion dans la base Agence :
        Agence agence = new Agence("RENNES", null, new Gerant(1));
        agenceDao = new AgenceDao(LoginActivity.this);
        agenceDao.insertAgence(agence);

        // Insert VOITURE
//        vehiculeDao.insert(new Vehicule("AA-123-CD", "Audi", null, 80000,
//                false, true, null, new Agence(1, null, null, null)));
//        vehiculeDao.insert(new Vehicule("AB-456-EF", "Peugeot", null, 100000,
//                false, true, null, new Agence(1, null, null, null)));
//        vehiculeDao.insert(new Vehicule("AC-789-GH", "Citroën", null, 210000,
//                false, true, null, new Agence(1, null, null, null)));
    }
}
