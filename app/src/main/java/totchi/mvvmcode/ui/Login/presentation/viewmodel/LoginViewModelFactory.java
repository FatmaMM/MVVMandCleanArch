package totchi.mvvmcode.ui.Login.presentation.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    LoginViewModel viewModel;

    @Inject
    public LoginViewModelFactory(LoginViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) viewModel;
    }
}
