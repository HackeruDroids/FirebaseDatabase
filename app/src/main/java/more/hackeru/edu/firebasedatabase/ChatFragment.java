package more.hackeru.edu.firebasedatabase;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import more.hackeru.edu.firebasedatabase.models.ChatItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    //properties:
    FirebaseUser mUser;
    FirebaseDatabase mDatabase;

    @BindView(R.id.etMessage)
    EditText etMessage;
    @BindView(R.id.btnSend)
    Button btnSend;
    @BindView(R.id.rvChat)
    RecyclerView rvChat;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        unbinder = ButterKnife.bind(this, view);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnSend)
    public void onSendClicked() {
        String uid = mUser.getUid();
        //May be null
        Uri photoUrl = mUser.getPhotoUrl();

        String img = null;
        if (photoUrl != null) {
            img = photoUrl.toString();
        }
        //get the message from the EditText.
        String message = etMessage.getText().toString();
        //Custom Object.
        ChatItem item = new ChatItem(message, uid, img, new Date().toString());
        //push a new row to the ChatItems Table.
        mDatabase.getReference("ChatItems").push().setValue(item);
        //empty the EditText:
        etMessage.setText(null);
    }
}
