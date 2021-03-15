package ru.geekbrains.notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private int imageIndex;
    private String noteName;

    public Note(int imageIndex, String noteName){
        this.imageIndex = imageIndex;
        this.noteName = noteName;
    }

    protected Note(Parcel in) {
        imageIndex = in.readInt();
        noteName = in.readString();
    }

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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageIndex);
        dest.writeString(noteName);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public int getImageIndex() {
        return imageIndex;
    }

    public String getNoteName() {
        return noteName;
    }


}
