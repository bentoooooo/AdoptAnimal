package pt.ipbeja.adoptanimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bento on 01/02/2017.
 */
public class MainActivityTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPhoneOperator() throws Exception {
        String str = MainActivity.testPhoneOperator();
        char c;
        String phoneString = "";
        boolean okPhone = false;
        int counter = 0;
        for (int i = 0; i < str.length() ; i++) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                phoneString += c;
                counter++;
            }
            if (counter == 2)
            {
                break;
            }
        }
        int phone = Integer.parseInt(phoneString);

        for (int i = 0; i < 9 ; i++) {
            switch (phone) {
                case 91:
                    okPhone = true;
                    break;
                case 92:
                    okPhone = true;
                    break;
                case 93:
                    okPhone = true;
                    break;
                case 96:
                    okPhone = true;
                    break;
            }
        }
        assertEquals(true, okPhone);
    }

}