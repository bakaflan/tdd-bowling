import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Line;

public class BowlingGameTest {
    ScoreIndicator indicator;

    @BeforeEach
    void setUp(){
        indicator = new ScoreIndicator();
    }


    @Test
    void should_calcultate_frame_score_when_pin_in_one_frame_and_return_4(){
        String frameResult = "22";
        Assertions.assertEquals(4,indicator.calculateLine(frameResult));
    }

    @Test
    void should_calcultate_line_score_when_pin_in_one_frame_and_return_4(){
        String frameResult = "22 22";
        Assertions.assertEquals(8,indicator.calculateLine(frameResult));
    }

    @Test
    void should_calcultate_score_when_spare_in_one_frame_and_return_14(){
        String lineResult = "2/ 54";//(10+5)+9=24
        Assertions.assertEquals(24,indicator.calculateLine(lineResult));
    }

    @Test
    void should_calcultate_score_when_strike_in_one_frame_and_return_19(){
        String lineResult = "X/ 54";//(10+5+4)+9=28
        Assertions.assertEquals(28,indicator.calculateLine(lineResult));
    }
}
