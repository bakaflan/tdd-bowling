
public class Frame {
    private int score;
    private String[] throwScore;
    private boolean isStrike;
    private boolean isSpare;
    private boolean isLastFrame;

    public Frame() {
        this.score = 0;
        this.throwScore = new String[3];
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

    public int getScore() {
        return score;
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

    public int getFirstThrowScore(){
        if(throwScore[0].equals("X")){
            return 10;
        }
        return Integer.valueOf(throwScore[0]);
    }

    public int getSecondThrowScore(){
        if(isLastFrame){
            if(throwScore[1].equals("X")){
                return 10;
            }
            return Integer.valueOf(throwScore[1]);
        }
        if(throwScore[0].equals("X")){
            return 10;
        }
        if(throwScore[1].equals("/")){
            return -1;
        }
        return Integer.valueOf(throwScore[1]);
    }



    public void bonus(int bonus){
        this.score += bonus;
    }

    public void bonusLastFrame(){
        if(throwScore.length!=3){
            return;
        }
        int tempScore = this.score;
        if(throwScore[1].equals("X")){
            tempScore+=10;
        }
        if(throwScore[1].equals("/")){
            tempScore+= 10;
            if(!throwScore[2].equals("X")){
                tempScore+= Integer.valueOf(throwScore[2]);
            }
        }
        if(throwScore[2].equals("X")){
            tempScore+=10;
        }
        if(throwScore[2].equals("/")){
            tempScore+=10;
        }


        this.score = tempScore;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setLastFrame(boolean lastFrame) {
        isLastFrame = lastFrame;
    }
}
