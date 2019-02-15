package totchi.mvvmcode.ui.Login.domain;

import javax.inject.Inject;

import io.reactivex.Single;
import totchi.mvvmcode.Data.DataManger;
import totchi.mvvmcode.ui.Login.model.LoginResonse;
import totchi.mvvmcode.ui.Login.model.SignupBody;

public class LoginUseCase {
    @Inject
    DataManger manger;

    @Inject
    public LoginUseCase(DataManger manger) {
        this.manger = manger;
    }

    public Single<LoginResonse> login(SignupBody body, String lang) {
        return manger.login(body, lang);
    }
}
