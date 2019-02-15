package totchi.mvvmcode.ui.Login.presentation.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Patterns;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import totchi.mvvmcode.ui.Login.domain.LoginUseCase;
import totchi.mvvmcode.ui.Login.model.LoginResonse;
import totchi.mvvmcode.ui.Login.model.SignupBody;

public class LoginViewModel extends ViewModel {
    @Inject
    LoginUseCase loginUseCase;
    //    SignupBody body = new SignupBody();
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginResonse> userMutableLiveData;
    private MutableLiveData<Throwable> errorState;

    @Inject
    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;

    }


    public MutableLiveData<LoginResonse> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
            errorState = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }


    public void validateSignupBody(SignupBody body) {
        if (!Patterns.EMAIL_ADDRESS.matcher(body.getEmail()).matches()) {
//            getMvpView().emailSetError();
            EmailAddress.setValue("error email");
        } else if (body.getPassword().length() < 6) {
//            getMvpView().passSetError();
            Password.setValue("error password");
        } else {
            onClick(body);
        }
    }

    public void onClick(SignupBody body) {
        loginUseCase.login(body, "en").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<LoginResonse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(LoginResonse loginResonse) {
                            userMutableLiveData.setValue(loginResonse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorState.setValue(e);
                    }
                });

    }
}
