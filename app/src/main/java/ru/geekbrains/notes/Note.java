package ru.geekbrains.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private String title;
    private String content;
    private String creationDate;
   // private String mId;     //10
   private String id;

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public Note(String title, String content, String creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    protected Note(Parcel in) {
        title = in.readString();
        content = in.readString();
        creationDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(creationDate);
    }

    public String getId() {     //10
       // return mId;
        return id;
    }

    public void setId(String id) {      //10
        //mId = id;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreationDate() {
        return creationDate;
    }

}
