package view;

import java.util.Scanner;

public class LottoControllerInputView {
	private static final String INPUT_MONEY_MESSAGE = "구입급액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
	public static final String INPUT_MANUAL_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String INPUT_MANUAL_LOTTOS_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";

	private final Scanner scanner = new Scanner(System.in);

	public String inputMoney() {
		System.out.println(INPUT_MONEY_MESSAGE);
		return scanner.nextLine();
	}

	public void requireWinningNumbersMessage() {
		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
	}

	public String inputBonusBall() {
		System.out.println(INPUT_BONUS_BALL_MESSAGE);
		return scanner.nextLine();
	}

	public String inputManualLottoCount() {
		System.out.println(INPUT_MANUAL_COUNT_MESSAGE);
		return scanner.nextLine();
	}

	public void requireManualLottoMessage() {
		System.out.println(INPUT_MANUAL_LOTTOS_MESSAGE);
	}
}
