package com.g7.junit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailValidatorTest {

    @InjectMocks
    EmailValidator mockEmailValidator;

    @Test
    public void emailValidator_correctInput_returnTrue(){
        assertTrue(mockEmailValidator.isValidEmail("abc@gmail.com"));
    }

    @Test
    public void emailValidator_withSubdomain_returnTrue(){
        assertTrue(mockEmailValidator.isValidEmail("abc@gmail.co.in"));
    }

    @Test
    public void emailValidator_withoutSuffix_returnFalse(){
        assertFalse(mockEmailValidator.isValidEmail("abc@gmail"));
    }

    @Test
    public void emailValidator_withExtraChars_returnFalse(){
        assertFalse(mockEmailValidator.isValidEmail("abc@gmail..com"));
    }

    @Test
    public void emailValidator_noUserName_returnFalse(){
        assertFalse(mockEmailValidator.isValidEmail("@gmail.com"));
    }

    @Test
    public void emailValidator_noInput_returnFalse(){
        assertFalse(mockEmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_nullInput_returnFalse(){
        assertFalse(mockEmailValidator.isValidEmail(null));
    }
}
