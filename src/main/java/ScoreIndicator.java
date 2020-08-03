import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        frameList.forEach(frame -> lineScore+= frame.getScore());
        return lineScore;
    }

    private void convertLineResult(String lineResult){
        String[] frameResults = lineResult.split(" ");
        IntStream.range(0,frameResults.length).forEach(i-> frameList.add(Frame.createFrame(frameResults[i])));
        this.analyseLine();
    }

    private void analyseLine(){
        frameList.get(frameList.size()-1).setLastFrame(true);
        IntStream.range(0,frameList.size()).forEach(i ->{
            if(i == frameList.size()-1){
                Frame frame = frameList.get(i);
                frame.bonusLastFrame();
            }else {
                if(frameList.get(i).isStrike()) {
                    frameList.get(i).bonus(frameList.get(i + 1).getFirstThrowScore());
                    if(frameList.get(i + 1).getSecondThrowScore()==-1){
                        if(i==frameList.size()-2){
                            frameList.get(i).bonus(frameList.get(i + 1).getSecondThrowScore());
                        }else {
                            frameList.get(i).bonus(frameList.get(i + 2).getFirstThrowScore());
                        }

                    }else {
                        frameList.get(i).bonus(frameList.get(i + 1).getSecondThrowScore());
                    }
                }
                if(frameList.get(i).isSpare()) {
                    frameList.get(i).bonus(frameList.get(i + 1).getFirstThrowScore());
                }

            }
        });
    }

}
