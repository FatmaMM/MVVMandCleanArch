package totchi.mvvmcode.ui.Login.presentation.loginui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import totchi.mvvmcode.ui.Login.model.LoginResonse;
import totchi.mvvmcode.ui.Login.model.SignupBody;
import totchi.mvvmcode.R;
import totchi.mvvmcode.ui.Base.BaseActivity;
import totchi.mvvmcode.ui.Login.presentation.viewmodel.LoginViewModel;
import totchi.mvvmcode.ui.Login.presentation.viewmodel.LoginViewModelFactory;

public class LoginActivity extends BaseActivity {
    LoginViewModel viewModel;
    @BindView(R.id.login)
    Button loginbt;
    @BindView(R.id.email)
    EditText emailet;
    @BindView(R.id.password)
    EditText passet;
    @Inject
    LoginViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        activityComponent().inject(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);

        viewModel.EmailAddress.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                emailet.setError(viewModel.EmailAddress.getValue());
            }
        });

        viewModel.Password.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                passet.setError(viewModel.Password.getValue());
            }
        });

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignupBody body = new SignupBody();
                body.setPassword(passet.getText().toString());
                body.setEmail(emailet.getText().toString());
                viewModel.validateSignupBody(body);
            }
        });

        viewModel.getUser().observe(this, new Observer<LoginResonse>() {
            @Override
            public void onChanged(@Nullable LoginResonse loginResonse) {
                Toast.makeText(LoginActivity.this, loginResonse.getUser().getFirst_name() + " " + loginResonse.getUser().getLast_name(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
