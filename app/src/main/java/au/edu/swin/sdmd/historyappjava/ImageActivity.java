package au.edu.swin.sdmd.historyappjava;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class defines the image detail view of our app.
 *
 * @author nronald
 * June 2018, updated June 2019
 */

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initialiseUI();
    }

    private void initialiseUI() {

        // The values are extracted from the bundle passed to the class, using the constants
        // defined in MainActivity. Recall ids were passed, so we have to use resources to get the
        // actual values.
        Bundle extras = getIntent().getExtras();

        // A solution for not using hardcoded key strings is to create a Constants class, but we
        // are taking the shortcut here.
        String title = getResources().getString(extras.getInt("title"));
        String author = getResources().getString(extras.getInt("author"));
        // Note this call requires API 21
        Drawable image = getResources().getDrawable(extras.getInt("image"), getBaseContext().getTheme());

        // The views are retrieved ready for updating.
        TextView tvTitle = findViewById(R.id.image_title);
        TextView tvAuthor = findViewById(R.id.image_author);
        ImageView ivImage = findViewById(R.id.image);

        // The views are updated using the values retrieved from resources.
        tvTitle.setText(title);
        tvAuthor.setText(author);
        ivImage.setImageDrawable(image);

    }
}