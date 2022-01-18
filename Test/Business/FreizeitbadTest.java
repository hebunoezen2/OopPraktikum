package Business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Business.businessFreizeitbad.Freizeitbad;

class FreizeitbadTest {


    BooleanSupplier bs;
    Freizeitbad fb;


    @BeforeEach
    void setUp() throws Exception{
        this.fb = new Freizeitbad("Stadtbad","7.0", "17.0", "25", "24");
    }
    @AfterEach
    void tearDown() throws Exception{
        this.fb = null;
    }


    @Test
    void test() {
        bs = () -> fb.getBeckenlaenge()==25;
        assertTrue(bs.getAsBoolean());
    }
}
