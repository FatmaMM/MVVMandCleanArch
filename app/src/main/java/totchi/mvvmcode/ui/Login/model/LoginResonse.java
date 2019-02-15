package totchi.mvvmcode.ui.Login.model;

import com.google.gson.annotations.SerializedName;

public class LoginResonse {
    @SerializedName("status")
    boolean stats;
    @SerializedName("data")
    User user;
    @SerializedName("error")
    String error;

    public boolean isStats() {
        return stats;
    }

    public void setStats(boolean stats) {
        this.stats = stats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
