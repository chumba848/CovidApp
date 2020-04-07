package bsl.co.ke.covidapp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import com.facebook.stetho.json.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.android.material.navigation.NavigationView;
import com.scaledrone.lib.Listener;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

import java.lang.reflect.Member;
import java.util.Random;

import bsl.co.ke.covidapp.R;
import bsl.co.ke.covidapp.ui.model.MemberData;
import bsl.co.ke.covidapp.ui.model.Message;
import bsl.co.ke.covidapp.ui.model.MessageAdapter;

public class ChatActivity extends AppCompatActivity implements RoomListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private String channelID = "Tbtdp25qCdRYBpyr";
    private String roomName = "observable-room";
    private EditText editText;
    private Scaledrone scaledrone;
    MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        // This is where we write the mesage
        editText = (EditText) findViewById(R.id.editText);
        getSupportActionBar().setTitle("MY PROFILE");


        MemberData data = new MemberData(getRandomName(), getRandomColor());

        scaledrone = new Scaledrone(channelID, data);
        scaledrone.connect(new Listener() {
            @Override
            public void onOpen() {
                System.out.println("Scaledrone connection open");
                // Since the MainActivity itself already implement RoomListener we can pass it as a target
                scaledrone.subscribe(roomName, ChatActivity.this);
            }

            @Override
            public void onOpenFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onFailure(Exception ex) {
                System.err.println(ex);
            }

            @Override
            public void onClosed(String reason) {
                System.err.println(reason);
            }
        });

    }

    private String getRandomName() {
        String[] adjs = {"autumn", "hidden", "bitter", "misty", "silent", "empty", "dry", "dark", "summer", "icy", "delicate", "quiet", "white", "cool", "spring", "winter", "patient", "twilight", "dawn", "crimson", "wispy", "weathered", "blue", "billowing", "broken", "cold", "damp", "falling", "frosty", "green", "long", "late", "lingering", "bold", "little", "morning", "muddy", "old", "red", "rough", "still", "small", "sparkling", "throbbing", "shy", "wandering", "withered", "wild", "black", "young", "holy", "solitary", "fragrant", "aged", "snowy", "proud", "floral", "restless", "divine", "polished", "ancient", "purple", "lively", "nameless"};
        String[] nouns = {"waterfall", "river", "breeze", "moon", "rain", "wind", "sea", "morning", "snow", "lake", "sunset", "pine", "shadow", "leaf", "dawn", "glitter", "forest", "hill", "cloud", "meadow", "sun", "glade", "bird", "brook", "butterfly", "bush", "dew", "dust", "field", "fire", "flower", "firefly", "feather", "grass", "haze", "mountain", "night", "pond", "darkness", "snowflake", "silence", "sound", "sky", "shape", "surf", "thunder", "violet", "water", "wildflower", "wave", "water", "resonance", "sun", "wood", "dream", "cherry", "tree", "fog", "frost", "voice", "paper", "frog", "smoke", "star"};
        return (
                adjs[(int) Math.floor(Math.random() * adjs.length)] +
                        "_" +
                        nouns[(int) Math.floor(Math.random() * nouns.length)]
        );
    }

    private String getRandomColor() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer("#");
        while(sb.length() < 7){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, 7);
    }

    public void sendMessage(View view) {
        String message = editText.getText().toString();
        if (message.length() > 0) {
            scaledrone.publish("observable-room", message);
            editText.getText().clear();
        }
    }




    @Override
    public void onOpen(com.scaledrone.lib.Room room) {
        System.out.println("Conneted to room");

    }

    @Override
    public void onOpenFailure(com.scaledrone.lib.Room room, Exception ex) {
        System.err.println(ex);

    }

    @Override
    public void onMessage(com.scaledrone.lib.Room room, com.scaledrone.lib.Message message) {

    }
}
