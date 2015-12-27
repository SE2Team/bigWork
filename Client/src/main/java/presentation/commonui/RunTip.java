package presentation.commonui;

public class RunTip {

    public static void makeTip() {
        TipPanel t = new TipPanel();
        Thread thread = new Thread(t);
        thread.start();
    }


}
