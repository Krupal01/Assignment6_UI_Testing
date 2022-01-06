package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void TestViewMainActivity(){

        //EditText view and operation test
        onView(allOf(withId(R.id.etName),isDisplayed())).perform(replaceText("chike"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etPassword),isDisplayed())).perform(replaceText("password"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etPhone),isDisplayed())).perform(replaceText("123456789"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etMail),isDisplayed())).perform(replaceText("xyz@gmail.com"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etAddress),isDisplayed())).perform(replaceText("india"),closeSoftKeyboard());
        onView(allOf(withId(R.id.etCountry),isDisplayed())).perform(replaceText("india"),closeSoftKeyboard());

        //textView view test
        onView(allOf(withId(R.id.tvGender),isDisplayed()));
        onView(allOf(withId(R.id.tvHobby),isDisplayed()));

        //Edittext click test
        onView(allOf(withId(R.id.etDob),isDisplayed())).perform(click());

        // Dialog Button click test
        onView(allOf(withId(android.R.id.button1),withText("OK"))).perform(click());

        //Radio Button View and click test
        onView(allOf(withId(R.id.rbMale),isDisplayed())).perform(click());
        onView(allOf(withId(R.id.rbFemale),isDisplayed())).perform(click());

        //CheckBox View and Click test
        onView(allOf(withId(R.id.chPlaying),isDisplayed())).perform(click());
        onView(allOf(withId(R.id.chReading),isDisplayed())).perform(click());
        onView(allOf(withId(R.id.chWriting),isDisplayed())).perform(click());

    }
}
