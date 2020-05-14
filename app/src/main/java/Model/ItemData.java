package Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ItemData implements Parcelable {

    private String category;
    private String title;
    private String price;
    private String location;
    private ArrayList<String> tags;
    //private String mainPic;
    private ArrayList<String> pictures;
    private String description;
    private String seller;
    private String sellerPoints;

    public ItemData(String category, String title, String price, String location, ArrayList<String> tags, ArrayList<String> pictures, String description) {
        this.category = category;
        this.title = title;
        this.price = price;
        this.location = location;
        this.tags = tags;
        this.pictures = pictures;
        this.description = description;
    }

    public ItemData(String category, String title, String price, String location, ArrayList<String> tags, ArrayList<String> pictures, String description, String seller, String sellerPoints) {
        this.category = category;
        this.title = title;
        this.price = price;
        this.location = location;
        this.tags = tags;
        this.pictures = pictures;
        this.description = description;
        this.seller = seller;
        this.sellerPoints = sellerPoints;
    }


    protected ItemData(Parcel in) {
        category = in.readString();
        title = in.readString();
        price = in.readString();
        location = in.readString();
        tags = in.createStringArrayList();
        pictures = in.createStringArrayList();
        description = in.readString();
    }

    public static final Creator<ItemData> CREATOR = new Creator<ItemData>() {
        @Override
        public ItemData createFromParcel(Parcel in) {
            return new ItemData(in);
        }

        @Override
        public ItemData[] newArray(int size) {
            return new ItemData[size];
        }
    };

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void addTags(String tags) {
        this.tags.add(tags);
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public void addPictures(String pictures) {
        this.pictures.add(pictures);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSellerPoints() {
        return sellerPoints;
    }

    public void setSellerPoints(String sellerPoints) {
        this.sellerPoints = sellerPoints;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(category);
        parcel.writeString(title);
        parcel.writeString(price);
        parcel.writeString(location);
        parcel.writeStringList(tags);
        parcel.writeStringList(pictures);
        parcel.writeString(description);
    }
}
