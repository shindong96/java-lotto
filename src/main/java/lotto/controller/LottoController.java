package lotto.controller;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.RandomLottoGenerator;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.lotto.WinningStatistics;
import lotto.domain.number.Payout;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final RandomLottoGenerator LOTTO_GENERATOR = RandomLottoGenerator.getInstance();

    public static void run() {
        Payout payout = inputPayout();
        LottoTicket lottoTicket = buyLotto(payout);
        WinningNumbers winningNumbers =
            WinningNumbers.valueOf(inputLastWeekLottoNumber(), inputBonusNumber());

        calculateStatistics(winningNumbers, lottoTicket);
    }

    private static Payout inputPayout() {
        OutputView.payout();
        Payout payOut = Payout.valueOf(InputView.getStringInputFromUser());

        return payOut;
    }

    private static LottoTicket buyLotto(Payout payout) {
        LottoTicket lottoTicket = LOTTO_GENERATOR.buyLottoTicket(payout);
        OutputView.payOuted(lottoTicket.count());
        OutputView.boughtLotties(lottoTicket);

        return lottoTicket;
    }

    private static String inputLastWeekLottoNumber() {
        OutputView.lastWeekLottoNumber();

        return InputView.getStringInputFromUser();
    }

    private static String inputBonusNumber() {
        OutputView.bonusNumber();

        return InputView.getStringInputFromUser();
    }

    private static void calculateStatistics(WinningNumbers winningNumbers,
        LottoTicket lottoTicket) {
        OutputView.statistics(lottoTicket.getWinningStatistics(winningNumbers));
    }
}
