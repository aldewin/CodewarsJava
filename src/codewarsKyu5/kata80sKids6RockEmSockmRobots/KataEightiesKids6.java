package codewarsKyu5.kata80sKids6RockEmSockmRobots;

import java.util.HashMap;
import java.util.Map;

public class KataEightiesKids6 {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Rocky", 100, 20, new String[] { "punch", "punch", "laser", "missile" });
        Robot robot2 = new Robot("Missile Bob", 100, 21, new String[] { "missile", "missile", "missile", "missile" });
        Map<String, Integer> tactics = new HashMap<>(3, 1f);
        tactics.put("punch", 20);
        tactics.put("laser", 30);
        tactics.put("missile", 35);

        System.out.println(fight(robot1, robot2, tactics));
    }

    public static String fight(Robot robot1, Robot robot2, Map<String, Integer> tactics) {
        int robot1Attacks = 0, robot2Attacks = 0;
        int robot1Health = robot1.getHealth(), robot2Health = robot2.getHealth();

        boolean startFight = true;
        boolean goFight = true;

        if (robot1.getSpeed() < robot2.getSpeed())
            startFight = false;

        while (goFight) {
            if (startFight && robot1Attacks < robot1.getTactics().length) {
                robot2Health -= tactics.get(robot1.getTactics()[robot1Attacks]);
                robot1Attacks++;
            } else if (robot2Attacks < robot2.getTactics().length) {
                robot1Health -= tactics.get(robot2.getTactics()[robot2Attacks]);
                robot2Attacks++;
            }
            startFight = !startFight;

            if ((robot1Attacks >= robot1.getTactics().length && robot2Attacks >= robot2.getTactics().length) || robot1Health <= 0 || robot2Health <= 0)
                goFight = false;
        }

        if (robot1Health > robot2Health)
            return robot1.getName() + " has won the fight.";
        else if (robot2Health > robot1Health)
            return robot2.getName() + " has won the fight.";
        else return "The fight was a draw.";
    }
}
