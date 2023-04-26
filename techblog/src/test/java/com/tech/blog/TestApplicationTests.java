package com.tech.blog;

import com.tech.blog.dao.AdditionalUserDataRepository;
import com.tech.blog.dao.UserRepository;
import com.tech.blog.junit.*;
import com.tech.blog.service.user.UserService;
import com.tech.blog.service.user.UserServiceImpl;
import com.tech.blog.user.Role;
import com.tech.blog.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestApplicationTests {

    @Mock
    private OperatiiDB operatiiDB; //  creaza un obiectul de tipul interfetei ce nu contine nimic real
    private OperatiiDobanda operatiiDobanda = new OperatiiDobanda();
    ///////////////////////////////////////////
    @Mock
    private UserRepository userRepository;

    @Mock
    private AdditionalUserDataRepository additionalUserDataRepository;
    ///////////////////////////////////////////
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
    void testUserRiscDobandaMediu(){
        UserJUnit user = new UserJUnit("Vali", Risk.RISC_MEDIU);
        when(operatiiDB.getUser()).thenReturn(user);
        OperatiiDobanda operatiiDobanda = new OperatiiDobanda(operatiiDB);
        assertTrue(operatiiDobanda.dobandaUser() == 50.0);
        verify(operatiiDB).getUser(); // verifica ca o anumita metoda s-a chemat; de obicei metodele cu parametrii ca sa verificam daca am chemat metodele cu parametrii corecti
    }

    @Test
    void testUserRiscDobandaMic(){
        UserJUnit user = new UserJUnit("Adi", Risk.RISC_MIC);
        when(operatiiDB.getUser()).thenReturn(user);
        OperatiiDobanda operatiiDobanda = new OperatiiDobanda(operatiiDB);
        assertTrue(operatiiDobanda.dobandaUser() == 20.0);
        verify(operatiiDB).getUser(); // verifica ca o anumita metoda s-a chemat; de obicei metodele cu parametrii ca sa verificam daca am chemat metodele cu parametrii corecti
    }

    @Test
    void testUserRiscDobandaMare(){
        UserJUnit user = new UserJUnit("Adi", Risk.RISC_RIDICAT);
        when(operatiiDB.getUser()).thenReturn(user);
        OperatiiDobanda operatiiDobanda = new OperatiiDobanda(operatiiDB);
        assertTrue(operatiiDobanda.dobandaUser() == 100.0);
        verify(operatiiDB).getUser(); // verifica ca o anumita metoda s-a chemat; de obicei metodele cu parametrii ca sa verificam daca am chemat metodele cu parametrii corecti
    }

    @Test
    void testTechBlog(){
        User user = new User(true, "test@mock.com", "1234", Role.USER);
        UserService userService = new UserServiceImpl(userRepository, additionalUserDataRepository);
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User test_user = userService.getUserById(1);
        assertTrue(test_user.getIdUser() == user.getIdUser());
        verify(userRepository).findById(1);
    }
}
