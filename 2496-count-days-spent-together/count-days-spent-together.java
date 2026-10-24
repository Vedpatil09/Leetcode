
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = { 0, 31, 28, 31, 30, 31, 30,
                       31, 31, 30, 31, 30, 31 };

        int aStart = getDay(arriveAlice, days);
        int aEnd = getDay(leaveAlice, days);
        int bStart = getDay(arriveBob, days);
        int bEnd = getDay(leaveBob, days);

        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);

        return Math.max(0, end - start + 1);
    }

    private int getDay(String date, int[] days) {
        int month = (date.charAt(0) - '0') * 10
                  + (date.charAt(1) - '0');

        int day = (date.charAt(3) - '0') * 10
                + (date.charAt(4) - '0');

        int total = day;

        for (int i = 1; i < month; i++) {
            total += days[i];
        }

        return total;
    }
}
