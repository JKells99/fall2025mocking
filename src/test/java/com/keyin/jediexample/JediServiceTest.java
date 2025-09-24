package com.keyin.jediexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JediServiceTest {
    JediTrainingService jediTrainingService;

    @Mock
    ForceMeter mockForceMeter;

    @BeforeEach
    void setUp() {
        jediTrainingService = new JediTrainingService(mockForceMeter);
    }

    @Test
    void testStrongPadawan(){
        when(mockForceMeter.getForceLevel("Luke")).thenReturn(100);
        String result = jediTrainingService.assessPadawan("Luke");
        Assertions.assertEquals("Strong with the force Luke is ", result);
        System.out.println(result);
    }

    @Test
    void testWeakPadawan(){
        when(mockForceMeter.getForceLevel("Luke")).thenReturn(1);
        String result = jediTrainingService.assessPadawan("Luke");
        Assertions.assertEquals("Much to lean they do Luke", result);
    }
}
