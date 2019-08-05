package com.g7.junit;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SharedPreferencesHelperTest {


    private static final String TEST_NAME = "Test name";

    private static final String TEST_EMAIL = "test@email.com";

    private static final Calendar TEST_DATE_OF_BIRTH = Calendar.getInstance();

    static {
        TEST_DATE_OF_BIRTH.set(1980, 1, 1);
    }


    private SharedPreferencesHelper mMockSharedPreferencesHelper;

    private SharedPreferenceEntry sharedPreferenceEntry;


    @Before
    public void Init() {

        sharedPreferenceEntry = new SharedPreferenceEntry(TEST_NAME, TEST_DATE_OF_BIRTH,
                TEST_EMAIL);
        mMockSharedPreferencesHelper = createMockSharedPreferenceHelper();

    }

    private SharedPreferencesHelper createMockSharedPreferenceHelper() {
        when(mMockSharedPreferences.getString(eq(SharedPreferencesHelper.KEY_NAME), anyString())).thenReturn(sharedPreferenceEntry.getName());
        when(mMockSharedPreferences.getString(eq(SharedPreferencesHelper.KEY_EMAIL), anyString())).thenReturn(sharedPreferenceEntry.getEmail());
        when(mMockSharedPreferences.getLong(eq(SharedPreferencesHelper.KEY_DOB), anyLong())).thenReturn(sharedPreferenceEntry.getDateOfBirth().getTimeInMillis());

        // Mocking a successful commit.
        when(mMockEditor.commit()).thenReturn(true);

        // Return the MockEditor when requesting it.
        when(mMockSharedPreferences.edit()).thenReturn(mMockEditor);
        return new SharedPreferencesHelper(mMockSharedPreferences);
    }

    @Test
    public void sharedPreferenceHelper_saveAndReadPersonalData() {
        // Save the personal information to SharedPreferences
        boolean success = mMockSharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry);

        Assert.assertTrue("Checking that SharedPreferenceEntry.save... returns true", success);

        // Read personal information from SharedPreferences
        SharedPreferenceEntry savedSharedPreferenceEntry = mMockSharedPreferencesHelper.getPersonalInfo();

        // Make sure both written and retrieved personal information are equal.
        assertThat(sharedPreferenceEntry.getName(), is(equalTo(savedSharedPreferenceEntry.getName())));
        assertThat(sharedPreferenceEntry.getDateOfBirth(), is(equalTo(savedSharedPreferenceEntry.getDateOfBirth())));
        assertThat(sharedPreferenceEntry.getEmail(), is(equalTo(savedSharedPreferenceEntry.getEmail())));
    }

}
