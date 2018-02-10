package com.example.jasonlalonde.assignment2;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Jason Lalonde on 2/9/2018.
 */
@RunWith(AndroidJUnit4.class)
public class SimpleEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);
    @Test
    public void start() {
        // TEST 1: beginning. once the app opens checks to see everything is there
        onView(withText("password")).check(matches(isDisplayed()));
        onView(withText("Validate")).check(matches(isDisplayed()));
        onView(withText("Not Strong")).check(matches(isDisplayed()));

        //TEST 2: checking the button click
        onView(withId(R.id.validate)).perform(click());

        //TEST 3: checking a Very Strong password
        String pw = "HEYooo123@#"; //everything for good password
        onView(withId(R.id.password)).perform(clearText());
        onView(withId(R.id.password)).perform(replaceText(pw));
        onView(withId(R.id.validate)).perform(click());
        onView(withText("Very Strong")).check(matches(isDisplayed()));

        //TEST 4: checking a Strong password
        pw = "heYoo!qweew"; // no digit, but has everything else
        onView(withId(R.id.password)).perform(clearText());
        onView(withId(R.id.password)).perform(replaceText(pw));
        onView(withId(R.id.validate)).perform(click());
        onView(withText("Strong")).check(matches(isDisplayed()));

        //TEST 5: checking a Good password
        pw = "heYoo1"; // no special char and is not length 8, but has everything else
        onView(withId(R.id.password)).perform(clearText());
        onView(withId(R.id.password)).perform(replaceText(pw));
        onView(withId(R.id.validate)).perform(click());
        onView(withText("Good")).check(matches(isDisplayed()));

        //TEST 6: checking a Weak password
        pw = "111"; // has digit and is not password but nothing else
        onView(withId(R.id.password)).perform(clearText());
        onView(withId(R.id.password)).perform(replaceText(pw));
        onView(withId(R.id.validate)).perform(click());
        onView(withText("Weak")).check(matches(isDisplayed()));

        //TEST 7: checking a Very Weak password
        pw = "password"; // length is 8, but has nothing else
        onView(withId(R.id.password)).perform(clearText());
        onView(withId(R.id.password)).perform(replaceText(pw));
        onView(withId(R.id.validate)).perform(click());
        onView(withText("Very Weak")).check(matches(isDisplayed()));

        //TEST 8: checking a Bad password
        pw = ""; //has nothing
        onView(withId(R.id.password)).perform(clearText());
        onView(withId(R.id.password)).perform(replaceText(pw));
        onView(withId(R.id.validate)).perform(click());
        onView(withText("Bad")).check(matches(isDisplayed()));
    }
}
