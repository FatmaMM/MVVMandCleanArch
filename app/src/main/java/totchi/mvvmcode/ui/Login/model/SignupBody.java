package totchi.mvvmcode.ui.Login.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SignupBody implements Parcelable {
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("password_confirmation")
    private String confirmPass;
    @SerializedName("cash_number")
    private String cashNum;
    @SerializedName("back_id")
    private String back_id;
    @SerializedName("front_id")
    private String front_id;
    @SerializedName("sid")
    private String sid;

    protected SignupBody(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        password = in.readString();
        confirmPass = in.readString();
        cashNum = in.readString();
        back_id = in.readString();
        front_id = in.readString();
        sid = in.readString();
    }

    public SignupBody() {
    }

    public static final Creator<SignupBody> CREATOR = new Creator<SignupBody>() {
        @Override
        public SignupBody createFromParcel(Parcel in) {
            return new SignupBody(in);
        }

        @Override
        public SignupBody[] newArray(int size) {
            return new SignupBody[size];
        }
    };

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getCashNum() {
        return cashNum;
    }

    public void setCashNum(String cashNum) {
        this.cashNum = cashNum;
    }

    public String getBack_id() {
        return back_id;
    }

    public void setBack_id(String back_id) {
        this.back_id = back_id;
    }

    public String getFront_id() {
        return front_id;
    }

    public void setFront_id(String front_id) {
        this.front_id = front_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(confirmPass);
        parcel.writeString(cashNum);
        parcel.writeString(back_id);
        parcel.writeString(front_id);
        parcel.writeString(sid);
    }
}
