package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.Test;

import business.businessFreizeitbad.Freizeitbad;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class FreizeitbadTest {

    BooleanSupplier bs;
    Freizeitbad fzb;


    @BeforeEach
    void setUp() throws Exception{
        this.fzb = new Freizeitbad("Stadtbad","7.0", "17.0", "25", "24");
    }
    @AfterEach
    void tearDown() throws Exception{
        this.fzb = null;
    }


    @Test
    void test() {
        bs = () -> fzb.getBeckenlaenge()==25;
        assertTrue(bs.getAsBoolean());
    }
}
