package codewarsKyu5;

public class KataLeagueOrder {
    public static void main(String[] args) {

    }

    public static int[] computeRanks(int number, int[][] games) {
        int[][] table = new int[number][3];

        for (int[] team : games) {
            // зачисляем очки
            if (team[2] > team[3])
                table[team[0]][0] += 2;
            else if (team[3] > team[2])
                table[team[1]][0] += 2;
            else {
                table[team[0]][0]++;
                table[team[1]][0]++;
            }
            // подлсчитываем разницу голов
            table[team[0]][1] += team[1] - team[2];
            table[team[1]][1] += team[1] - team[2];
            // подсчитываем сколько голов было забито
            table[team[0]][2] += team[2];
            table[team[1]][2] += team[3];
        }

        int[] ranks = new int[number];
        for (int i = 0; i < number; i++) {

        }
        return ranks;
    }
}
