package presentation.commonui;

public class RunTip {

    public static void makeTip() {
        TipPanel t = new TipPanel();
        Thread thread = new Thread(t);
        thread.start();
    }

    public static void makeTip(String str) {
        TipPanel t = new TipPanel(str);
        Thread thread = new Thread(t);
        thread.start();
    }


}
