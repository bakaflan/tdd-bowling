import java.util.stream.IntStream;

public class Frame {
    private int score;
    private String[] throwScore;
    private boolean isStrike;
    private boolean isSpare;

    public Frame() {
        this.score = 0;
        this.throwScore = new String[2];
        this.isStrike = false;
        this.isSpare = false;
    }

    public static Frame createFrame(String frameResult){
        Frame frame = new Frame();
        frame.convert(frameResult);
        return frame;
    }

    public void convert(String frameResult){
        this.throwScore = frameResult.split("");
        this.analyseFrame();
    }

    private void analyseFrame(){
        if(throwScore[0].equals("X")){
            this.isStrike = true;
            this.score =10;
            return;
        }
        if(throwScore[1].equals("/")){
            this.isSpare = true;
            this.score =10;
            return;
        }
        this.score = Integer.valueOf(throwScore[0])+Integer.valueOf(throwScore[1]);
    }

    public int getScore() {
        return score;
    }
}
