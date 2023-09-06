package com.muhammet.Java8SpringTest.mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class MockTestIslemleri {

    @Test
    void testStandart(){
        System.out.println("Test İşlemi yapılıyor.");
    }

    /**
     * Herhangi bir varlığı taklit edebilen ve onu asiyonlarından sıyıran bir nesnedir.
     * ayrıca taklit yaparak nesnenin davranışlarını kontrol edebiliriz. Burada birim
     * test için önemli olan, dış etmenlerin etkilerinden korunma görevini üstlenir.
     */
    @Test
    void ilkMockTest(){
        List<String> userList = List.of("Muhammet", "Ahmet", "Mehmet");
        List<String> otherUserList = new ArrayList<>();
        otherUserList.add("Demet");
        otherUserList.add("Fatma");
        otherUserList.add("Ayşe");
        System.out.println("User List : " + userList);
        System.out.println("--------------------------");
        System.out.println("Other User List : " + otherUserList);
        System.out.println("--------------------------");
        System.out.println("2. kullanıcı....: " + userList.get(1));
        /**
         * Mock ladığpınız bir nesne kendi görevlerini yerine getirmez. Yani,
         * hiç bir methodu çalışmaz. Onlar sadece tanımlıdır. işlem yapmazlar.
         * Peki o zaman nasıl test edeceğiz. İşte burada soyutlamanını yönetilmesi
         * devreye giriyor.
         */
        List<String> mockList = mock(ArrayList.class);
        mockList.add("Muhammet");
        mockList.add("Ahmet");
        mockList.add("Mehmet");
        System.out.println("--------------------------");
        System.out.println("2. kullanıcı....: "+ mockList.get(1));
       // Mockito.when(mockList.get(2)).thenReturn("Mehmet");
        when(mockList.get(anyInt())).thenReturn("Mehmet");
        System.out.println("3. Kullanıcı.....: "+ mockList.get(2));
        System.out.println("1. Kullanıcı.....: "+ mockList.get(0));

    }

    @Test
    void mockVerify(){
        List<String> mockList = mock(ArrayList.class);
        mockList.add("Muhammet");
        mockList.clear();

        verify(mockList).add("Muhammet");
        verify(mockList).clear();
    }
}
