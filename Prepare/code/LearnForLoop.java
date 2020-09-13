package Prepare.code;

public class LearnForLoop {

    public static void main(String[] args) {
        int loopCount = 10;
        loop(loopCount);
        loop2(loopCount);
        doubleLoop1(loopCount);
        doubleLoop2(loopCount);
    }

    private static void doubleLoop1(int loopCount) {
        StringBuilder out = new StringBuilder("double loop:\n");
        for (int i = 0; i < loopCount; i++) {
            for (int j = i + 1; j < loopCount; j++) {
                out.append(i).append("-").append(j).append(",");
            }
            out.append("\n");
        }
        System.out.println(out.toString());
    }

    private static void doubleLoop2(int loopCount) {
        StringBuilder out = new StringBuilder("double loop2:\n");
        for (int i = 0; i < loopCount - 1; i++) {
            for (int j = i + 1; j < loopCount; j++) {
                out.append(i).append("-").append(j).append(",");
            }
            out.append("\n");
        }
        System.out.println(out.toString());
    }

    private static void loop(int loopCount) {
        StringBuilder out = new StringBuilder("loop: ");
        for (int i = 0; i < loopCount; i++) {
            out.append(i).append(",");
        }
        System.out.println(out.toString());
    }

    private static void loop2(int loopCount) {
        StringBuilder out = new StringBuilder("loop2: ");
        for (int i = 0; i < loopCount - 1; i++) {
            out.append(i).append(",");
        }
        System.out.println(out.toString());
    }
}




