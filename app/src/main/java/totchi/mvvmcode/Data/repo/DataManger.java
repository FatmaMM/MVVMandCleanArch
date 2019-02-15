package totchi.mvvmcode.Data;

import javax.inject.Inject;

import io.reactivex.Single;
import totchi.mvvmcode.ui.Login.model.LoginResonse;
import totchi.mvvmcode.ui.Login.model.SignupBody;
import totchi.mvvmcode.Data.Model.RemoteService.IHelpService;

public class DataManger {
    IHelpService iHelpService;

    @Inject
    public DataManger(IHelpService iHelpService) {
        this.iHelpService = iHelpService;
    }

    public Single<LoginResonse> login(SignupBody body, String language) {
        return iHelpService.login(body, language);
    }

}