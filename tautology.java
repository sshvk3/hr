import java.util.Scanner;

public class Main {
    static char[] expression;
    static int[] variableOrder = new int[300];
    static boolean[] variableValues = new boolean[10];

    static class Info {
        int p;
        boolean v;

        Info() {
        }

        Info(int p, boolean v) {
            this.p = p;
            this.v = v;
        }
    }

    static Info check(int l) {
        if (Character.isLowerCase(expression[l])) {
            return new Info(l + 1, variableValues[variableOrder[expression[l]]]);
        }
        if (expression[l] == 'N') {
            Info t = check(l + 1);
            return new Info(t.p, !t.v);
        }
        if (expression[l] == 'K') {
            Info t = check(l + 1);
            Info t2 = check(t.p);
            return new Info(t2.p, t.v && t2.v);
        }
        if (expression[l] == 'A') {
            Info t = check(l + 1);
            Info t2 = check(t.p);
            return new Info(t2.p, t.v || t2.v);
        }
        if (expression[l] == 'C') {
            Info t = check(l + 1);
            Info t2 = check(t.p);
            return new Info(t2.p, (t.v && !t2.v) ? false : true);
        }
        if (expression[l] == 'E') {
            Info t = check(l + 1);
            Info t2 = check(t.p);
            return new Info(t2.p, t.v == t2.v);
        }
        return new Info(0, false);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        variableOrder['p'] = 0;
        variableOrder['q'] = 1;
        variableOrder['r'] = 2;
        variableOrder['s'] = 3;
        variableOrder['t'] = 4;

        while (true) {
            expression = scanner.next().toCharArray();
            int all = (1 << 5) - 1;
            int n = expression.length;

            if (n == 1 && expression[0] == '0')
                break;

            boolean ok = true;

            for (int i = 0; i <= all; i++) {
                for (int j = 0; j < 5; j++)
                    variableValues[j] = ((i >> j) & 1) == 1;

                if (!check(0).v) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "tautology" : "not");
        }
    }
}