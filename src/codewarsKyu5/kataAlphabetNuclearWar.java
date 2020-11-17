package codewarsKyu5;

public class kataAlphabetNuclearWar {
    public static void main(String[] args) {
        System.out.println(alphabetWar("[ab]adfd[dd]##[abe]dedf[ijk]d#d[h]#"));
    }

    public static String alphabetWar(String battlefield) {
        char[] battleArray = battlefield.toCharArray();
        int[] powerAlphabet = powerSymbol(battleArray);

        for (int i = 0; i < battleArray.length; i++) {
            if (battleArray[i] == '#') {
                battleArray[i] = 0;

                boolean searchShelters = false; boolean isShelters = false;
                for (int j = i + 1; j < battleArray.length; j++) {
                    if (powerAlphabet[j] == 0 || (searchShelters && powerAlphabet[j] > 0))
                        continue;

                    if (battleArray[j] == '[')
                        isShelters = true;
                    else if (battleArray[j]==']') {
                        isShelters = false;
                        searchShelters = true;
                    } else if (isShelters)
                        powerAlphabet[j]--;
                    else if (!searchShelters || powerAlphabet[j] < 0)
                        powerAlphabet[j]++;
                }

                searchShelters = false; isShelters = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (powerAlphabet[j] == 0 || (searchShelters && powerAlphabet[j] > 0))
                        continue;

                    if (battleArray[j] == ']')
                        isShelters = true;
                    else if (battleArray[j] == '[') {
                        isShelters = false;
                        searchShelters = true;
                    } else if (isShelters)
                        powerAlphabet[j]--;
                    else if (!searchShelters || powerAlphabet[j] < 0)
                        powerAlphabet[j]++;
                }
            }
        }

        StringBuilder resultWar = new StringBuilder();
        for (int i = 0; i < powerAlphabet.length; i++) {
            if (battleArray[i] == ']' || battleArray[i] == '[')
                continue;

            if (powerAlphabet[i] != 0)
                resultWar.append(battleArray[i]);
        }
        return resultWar.toString();
    }

    private static int[] powerSymbol(char[] battleArray) {
        int[] power = new int[battleArray.length];

        boolean isMorePower = false;
        for (int i = 0; i < battleArray.length; i++) {
            if (battleArray[i] == '#' && !isMorePower)
                continue;

            if (battleArray[i] == '[') {
                isMorePower = true;
                power[i] = 1;
            } else if (battleArray[i] == ']') {
                isMorePower = false;
                power[i] = 1;
            }  else if (isMorePower) {
                power[i] = 2;
            } else
                power[i] = -1;
        }
        return power;
    }
}


/*
            {"[a]#[b]#[c]", "ac"},                               +
            {"[a]#b#[c][d]", "d"},                               +
            {"[a][b][c]", "abc"},                                +
            {"##a[a]b[c]#", "c"},                                +
            {"abde[fgh]ijk", "abdefghijk"},                      +
            {"ab#de[fgh]ijk", "fgh"},                            +
            {"ab#de[fgh]ij#k", ""},                              +
            {"##abde[fgh]ijk", ""},                              +
            {"##abcde[fgh]", ""},                                +
            {"abcde[fgh]", "abcdefgh"},                          +
            {"##abde[fgh]ijk[mn]op", "mn"},                      +
            {"#abde[fgh]i#jk[mn]op", "mn"},                      +
            {"[ab]adfd[dd]##[abe]dedf[ijk]d#d[h]#", "abijk"}     +
 */