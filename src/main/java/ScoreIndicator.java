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
        this.frameList.forEach(frame -> this.lineScore+= frame.getScore());
        return this.lineScore;
    }

    private void convertLineResult(String lineResult){
        String[] frameResults = lineResult.split(" ");
        IntStream.range(0,frameResults.length).forEach(i-> this.frameList.add(Frame.createFrame(frameResults[i])));
        this.analyseLine();
    }

    private void analyseLine(){
        IntStream.range(0,frameList.size()-1).forEach(i ->{
            if(frameList.get(i).isStrike()){
                frameList.get(i).bonus(frameList.get(i+1).getScore());
            }
            if(frameList.get(i).isSpare()){
                frameList.get(i).bonus(frameList.get(i+1).getFirstThrowScore());
            }
        });
    }

}
