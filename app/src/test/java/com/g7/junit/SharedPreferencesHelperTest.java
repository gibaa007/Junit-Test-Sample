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

        sharedPreferenceEntry=setSharedPreferenceEntry();

    }

    private SharedPreferenceEntry setSharedPreferenceEntry() {
        when(sharedPreferenceEntry.getName()).thenReturn("")
    }

    @Test
    public void sharedPreferenceHelper_saveAndReadPersonalDate(){

    }

}
