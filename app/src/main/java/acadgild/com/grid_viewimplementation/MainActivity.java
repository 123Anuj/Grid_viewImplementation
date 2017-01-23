package acadgild.com.grid_viewimplementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView mygrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mygrid= (GridView) findViewById(R.id.grid_view);
        mygrid.setAdapter(new Adapt(this));
    }
}
