package com.rhino.unittesting;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * @author LuoLin
 * @since Create on 2018/6/7.
 */
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = new Intent();
            intent.putExtra("url", "http://www.baidu.com");
            return intent;
        }

        @Override
        protected void beforeActivityLaunched() {
            super.beforeActivityLaunched();
            Log.d("RHINO", "beforeActivityLaunched");
        }

        @Override
        protected void afterActivityLaunched() {
            super.afterActivityLaunched();
            Log.d("RHINO", "afterActivityLaunched");
        }

        @Override
        protected void afterActivityFinished() {
            super.afterActivityFinished();
            Log.d("RHINO", "afterActivityFinished");
        }

    };



    @Before
    public void setUp() throws Exception {
        Log.d("RHINO", "setUp");
        delay(1000);
    }

    @After
    public void tearDown() throws Exception {
        delay(10000);
        Log.d("RHINO", "tearDown");
    }

    @Test
    public void emptyTest() {
        Log.d("RHINO", "emptyTest");
    }

    @Test
    public void testProjectName() {
        Log.d("RHINO", "testProjectName");

        testProjectName("四川100变电项目");

        testProjectName("四川100KV变电项目");
        testProjectName("四川100Kv变电项目");
        testProjectName("100kv四川变电项目");
        testProjectName("四川变电项目100kV");

        testProjectName("四川V变电项目");

        testProjectName("四川100V变电项目");
        testProjectName("100v四川变电项目");

    }

    private void testProjectName(String name) {
        delay(1000);
        onView(withId(R.id.edit)).perform(replaceText(name), closeSoftKeyboard());
        onView(withText("保存")).perform(click());
    }

    private void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
