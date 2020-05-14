package Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class User implements Parcelable {

    private String name;
    private String username;
    private String password;
    private String points;
    private String email;
    private String phone;
    private String profilePic;

    private ArrayList<ItemData> favorites;
    private ArrayList<ItemData> activePostsSell;
    private ArrayList<ItemData> activePostsBuy;
    private ArrayList<ItemData> bought;
    private ArrayList<ItemData> sold;

    public User(String name, String username, String password, String points, String email, String phone,
                String pic, ArrayList<ItemData> favorites, ArrayList<ItemData> activePostsSell, ArrayList<ItemData> activePostsBuy,
                ArrayList<ItemData> bought, ArrayList<ItemData> sold) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.points = points;
        this.email = email;
        this.phone = phone;
        this.profilePic = pic;
        this.favorites = favorites;
        this.activePostsSell = activePostsSell;
        this.activePostsBuy = activePostsBuy;
        this.bought = bought;
        this.sold = sold;
    }

    protected User(Parcel in) {
        name = in.readString();
        username = in.readString();
        password = in.readString();
        points = in.readString();
        email = in.readString();
        phone = in.readString();
        profilePic = in.readString();
        favorites = in.createTypedArrayList(ItemData.CREATOR);
        activePostsSell = in.createTypedArrayList(ItemData.CREATOR);
        activePostsBuy = in.createTypedArrayList(ItemData.CREATOR);
        bought = in.createTypedArrayList(ItemData.CREATOR);
        sold = in.createTypedArrayList(ItemData.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String pic) {
        this.profilePic = pic;
    }

    public ArrayList<ItemData> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<ItemData> favorites) {
        this.favorites = favorites;
    }

    public ArrayList<ItemData> getActivePostsSell() {
        return activePostsSell;
    }

    public void setActivePostsSell(ArrayList<ItemData> activePostsSell) {
        this.activePostsSell = activePostsSell;
    }

    public ArrayList<ItemData> getActivePostsBuy() {
        return activePostsBuy;
    }

    public void setActivePostsBuy(ArrayList<ItemData> activePostsBuy) {
        this.activePostsBuy = activePostsBuy;
    }

    public ArrayList<ItemData> getBought() {
        return bought;
    }

    public void setBought(ArrayList<ItemData> bought) {
        this.bought = bought;
    }

    public ArrayList<ItemData> getSold() {
        return sold;
    }

    public void setSold(ArrayList<ItemData> sold) {
        this.sold = sold;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(points);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(profilePic);
        parcel.writeTypedList(favorites);
        parcel.writeTypedList(activePostsSell);
        parcel.writeTypedList(activePostsBuy);
        parcel.writeTypedList(bought);
        parcel.writeTypedList(sold);
    }
}
