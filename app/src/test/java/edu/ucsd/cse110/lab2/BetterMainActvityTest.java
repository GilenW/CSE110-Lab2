package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActvityTest {
    @Test
    public void test_one_plus_one(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);
        scenario.onActivity(activity -> {
            Button button_1 = activity.findViewById(R.id.btn_one);
            Button button_plus =activity.findViewById(R.id.btn_plus);
            Button button_equal =activity.findViewById(R.id.btn_equals);
            button_1.performClick();
            button_plus.performClick();
            button_1.performClick();
            button_equal.performClick();
            TextView res = activity.findViewById(R.id.display);
            assertEquals(res.getText().toString(),"2");


        });
    }
}
