package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해주세요";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LAST_WEEK_LOTTO_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String RESULT_TITLE_MESSAGE = "\n당첨 통계\n----------";
    private static final String CHANGE_LINE = "\n";
    private static final String LOTTO_RESULT_MESSSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String SECOND_RANK_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d)원- %d개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.";

    public static String requestMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return SCANNER.nextLine();
    }

    public static void displayLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT_MESSAGE);
    }

    public static void displayLottoGroup(Lottos lottos) {
        ArrayList<Lotto> lottoGroup = lottos.getLottoGroup();
        for (int i = 0; i < lottoGroup.size(); i++) {
            System.out.print(lottoGroup.get(i).getLottoNumbers() + CHANGE_LINE);
        }
    }

    public static String requestWinningNumber() {
        System.out.println(LAST_WEEK_LOTTO_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String requestBonusBallNumber() {
        System.out.println(BONUS_BALL_MESSAGE);
        return SCANNER.nextLine();
    }

    public static void displayResultMessage() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public static void displayResult(Rank rank, int count) {
        System.out.printf(findMessage(rank), rank.getMatchCount(), rank.getPrize(), count);
    }

    private static String findMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return SECOND_RANK_RESULT_MESSAGE;
        }
        return LOTTO_RESULT_MESSSAGE;
    }

    public static void displayEarningRate(String earningRate) {
        System.out.printf(EARNING_RATE_MESSAGE, earningRate);
    }
}
