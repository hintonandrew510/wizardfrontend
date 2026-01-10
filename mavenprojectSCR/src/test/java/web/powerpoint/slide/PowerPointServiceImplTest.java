/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package web.powerpoint.slide;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.model.WizardData;

/**
 *
 * @author andrewhinton
 */
@SpringBootTest
public class PowerPointServiceImplTest {

    @Autowired
    private PowerPointService service;

    public PowerPointServiceImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of buildPowerPointDocument method, of class PowerPointServiceImpl.
     */
    @Test
    public void testBuildPowerPointDocument() {
        System.out.println("buildPowerPointDocument");
        int id = 129;
     
        String expResult = "";
        String result = service.buildPowerPointDocument(id);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSlidesData method, of class PowerPointServiceImpl.
     */
    //@Test
    public void testGetSlidesData() {
        System.out.println("getSlidesData");
        Iterable<WizardData> dataPages = null;
        List<SlideInterface> expResult = null;
       // List<SlideInterface> result = PowerPointServiceImpl.getSlidesData(dataPages);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
