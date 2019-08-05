package com.g7.junit;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SharedPreferencesHelperTest {


    @Mock
    SharedPreferencesHelper mockSharedPreferenceHelper;

    @Mock
    SharedPreferenceEntry sharedPreferenceEntry;


    @Before
    public void Init() {

        sharedPreferenceEntry=new SharedPreferenceEntry("",null,"");
        mockSharedPreferenceHelper=createMockSharedPreferenceHelper()

    }

    private SharedPreferenceEntry createMockSharedPreferenceHelper() {
        when(sharedPreferenceEntry.getName()).thenReturn("");
        when(sharedPreferenceEntry.getName()).thenReturn("");
        when(sharedPreferenceEntry.getName()).thenReturn("");
       return
    }

    @Test
    public void sharedPreferenceHelper_saveAndReadPersonalData(){
            // Save the personal information to SharedPreferences
            boolean success = mMockSharedPreferencesHelper.savePersonalInfo(mSharedPreferenceEntry);

            assertThat("Checking that SharedPreferenceEntry.save... returns true",
                    success, is(true));

            // Read personal information from SharedPreferences
            SharedPreferenceEntry savedSharedPreferenceEntry =
                    mMockSharedPreferencesHelper.getPersonalInfo();

            // Make sure both written and retrieved personal information are equal.
            assertThat("Checking that SharedPreferenceEntry.name has been persisted and read correctly",
                    mSharedPreferenceEntry.getName(),
                    is(equalTo(savedSharedPreferenceEntry.getName())));
            assertThat("Checking that SharedPreferenceEntry.dateOfBirth has been persisted and read "
                            + "correctly",
                    mSharedPreferenceEntry.getDateOfBirth(),
                    is(equalTo(savedSharedPreferenceEntry.getDateOfBirth())));
            assertThat("Checking that SharedPreferenceEntry.email has been persisted and read "
                            + "correctly",
                    mSharedPreferenceEntry.getEmail(),
                    is(equalTo(savedSharedPreferenceEntry.getEmail())));
        }

}
