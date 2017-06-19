package more.hackeru.edu.firebasedatabase.models;

/**
 * A Chat Item:
 * <p>
 * //In Order to save an Object to the database:
 * <p>
 * 1) Must have an empty Default Constructor.
 * 2) Must have public getters and setters.
 */

public class ChatItem {
    private String message;
    private String userID;
    private String profileImage = "http://donatered-asset.s3.amazonaws.com/assets/default/default_user-884fcb1a70325256218e78500533affb.jpg";
    private String date;

    //Default constructor for robots (Reflection)
    public ChatItem() {
    }

    //Constructor:
    public ChatItem(String message, String userID, String profileImage, String date) {
        this.message = message;
        this.userID = userID;
        if (profileImage != null)
            this.profileImage = profileImage;
        this.date = date;
    }

    //Getters And Setters:
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        if (profileImage != null)
            this.profileImage = profileImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatItem{" +
                "message='" + message + '\'' +
                ", userID='" + userID + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
