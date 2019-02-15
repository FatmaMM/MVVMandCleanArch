package totchi.mvvmcode.Data.Model.RemoteService;


import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import totchi.mvvmcode.ui.Login.model.LoginResonse;
import totchi.mvvmcode.ui.Login.model.SignupBody;

public interface IHelpService {
    String BASE_URL = "http://18.219.90.255";
    String LINK = "api/v1/";
    String LANG = "lang";

    @POST(LINK + "users/login")
    Single<LoginResonse> login(@Body SignupBody body, @Query(LANG) String lang);

    class Creator {
        public static IHelpService newIHelpService() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
            return retrofit.create(IHelpService.class);
        }
    }

}
