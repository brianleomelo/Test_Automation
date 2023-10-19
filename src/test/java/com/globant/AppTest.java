package com.globant;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    public Logger log = Logger.getLogger(AppTest.class);

    @Test
    @Parameters({"string1","string2"})
    public void testParameters(String a, String b){
        Assert.assertEquals(a,"Hello");
        Assert.assertEquals(b,"Globant");
        //log.info(a);
        //log.info(b);
    }

    @DataProvider (name="trasnlateHello")
    public static Object[][] inputData(){
        return new Object[][] {{"Hello"},{"Hola"},{"Ciao"}};
    }

    @Test(dataProvider = "trasnlateHello")
    public void testTranslate(String data){
        log.info(data);
    }

}
