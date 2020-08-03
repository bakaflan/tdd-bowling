import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {
    ScoreIndicator indicator;

    @BeforeEach
    void setUp(){
        indicator = new ScoreIndicator();
    }

    @Test
    void should_calcultate_score_if_pin_in_one_frame_and_return_4(){
        String throwResult = "22";
        Assertions.assertEquals(4,indicator.calculate(throwResult));
    }

    @Test
    void should_calcultate_score_if_spare_in_one_frame_and_return_14(){
        String throwResult = "2/ 54";
        Assertions.assertEquals(4,indicator.calculate(throwResult));
    }

    @Test
    void should_calcultate_score_if_strike_in_one_frame_and_return_19(){
        String throwResult = "X/ 54";
        Assertions.assertEquals(4,indicator.calculate(throwResult));
    }
}
