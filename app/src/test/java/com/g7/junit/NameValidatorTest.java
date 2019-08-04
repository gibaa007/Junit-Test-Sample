package com.g7.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.*;

@RunWith(MockitoJUnitRunner.class)
public class NameValidatorTest {

    @InjectMocks
    NameValidator mockNameValidator;

    @Test
    public void isValidName_emptyInput_returnFalse(){
        assertFalse(mockNameValidator.isValidName(""));
    }

    @Test
    public void isValidName_correctInput_returnTrue(){
        assertTrue(mockNameValidator.isValidName("Gibin"));
    }

    @Test
    public void isValidName_numberInput_returnFalse(){
        assertFalse(mockNameValidator.isValidName("323"));
    }

    @Test
    public void isValidName_numberTextInput_returnFalse(){
        assertFalse(mockNameValidator.isValidName("hgfe3"));
    }
}
