package com.tech.blog;

import com.tech.blog.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestApplicationTests {

    @Mock
    private OperatiiDB operatiiDB; //  creaza un obiectul de tipul interfetei ce nu contine nimic real
    private OperatiiDobanda operatiiDobanda = new OperatiiDobanda();

    @Test
    void contextLoads() {

    }

    @Test
    void testDobandaMica(){
        double valDobanda = operatiiDobanda.calculDobanda(TipDobanda.MIC);
        double expectedValDobanda = 20.0;
        assertTrue(valDobanda == expectedValDobanda);
    }

    @Test
    void testDobandaMediu(){
        double valDobanda = operatiiDobanda.calculDobanda(TipDobanda.MEDIU);
        double expectedValDobanda = 50.0;
        assertTrue(valDobanda == expectedValDobanda);
    }

    @Test
    void testDobandaMare(){
        double valDobanda = operatiiDobanda.calculDobanda(TipDobanda.MARE);
        double expectedValDobanda = 100.0;
        assertTrue(valDobanda == expectedValDobanda);
    }

    @Test
    void testUserRiscDobanda(){
        User user = new User("Vali", Risk.RISC_MEDIU);
        when(operatiiDB.getUser()).thenReturn(user);
        OperatiiDobanda operatiiDobanda = new OperatiiDobanda(operatiiDB);
        assertTrue(operatiiDobanda.dobandaUser() == 50.0);
        verify(operatiiDB).getUser(); // verifica ca o anumita metoda s-a chemat; de obicei metodele cu parametrii ca sa verificam daca am chemat metodele cu parametrii corecti
    }
}
