import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScoreIndicator {

    String lineResult;
    List<Integer> frameScore;

    public ScoreIndicator() {
        this.frameScore = new ArrayList<>();
    }

    public void init(){
        this.frameScore = new ArrayList<>();
    }

    public int calculateFrame(String frameResult) {
        String[] throwResults = frameResult.split("");
        return IntStream.range(0, frameResult.length()).map(i -> Integer.valueOf(throwResults[i])).sum();
    }

    public int calculateLine(String lineResult) {

        String[] frameResults = lineResult.split(" ");
        IntStream.range(0,frameResults.length).forEach(i -> frameScore.add(calculateFrame(frameResults[i])));
        return frameScore.stream().mapToInt(i -> i).sum();
    }
}
