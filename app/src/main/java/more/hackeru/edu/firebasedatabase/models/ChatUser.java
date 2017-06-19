package more.hackeru.edu.firebasedatabase.models;

import com.google.firebase.auth.FirebaseUser;

/**
 * Chat User class.
 */

public class ChatUser {
    //properties:
    private String displayName;
    private String profileImage = "http://donatered-asset.s3.amazonaws.com/assets/default/default_user-884fcb1a70325256218e78500533affb.jpg";

    //Default Constructor:
    public ChatUser() {
    }

    public ChatUser(FirebaseUser user) {
        this.displayName = user.getDisplayName();

        if (user.getPhotoUrl() != null)
            this.profileImage = user.getPhotoUrl().toString();
    }

    //Getters and Setters:
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "ChatUser{" +
                "displayName='" + displayName + '\'' +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
