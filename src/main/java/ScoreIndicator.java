import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScoreIndicator {

    String lineResult;
    List<Integer> frameScore;
    List<Frame> frameList;
    int lineScore;

    public ScoreIndicator() {
        this.frameScore = new ArrayList<>();
        this.frameList = new ArrayList<>();
        this.lineScore = 0;
    }


    public int calculateLine(String lineResult) {
        convertLineResult(lineResult);
        this.frameList.forEach(i -> this.lineScore+= i.getScore());
        return this.lineScore;
    }

    public void convertLineResult(String lineResult){
        String[] frameResults = lineResult.split(" ");
        IntStream.range(0,frameResults.length).forEach(i-> this.frameList.add(Frame.createFrame(frameResults[i])));
    }

}
