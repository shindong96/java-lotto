package model.lotto;

import utils.InputValidateUtils;

public class LottoCount {
	private static final int ZERO = 0;
	private static final int UNIT = 1000;
	private static final String LOTTO_COUNT_BLANK_ERROR_MESSAGE = "[Error]: 금액을 입력해주세요.";
	private static final String LOTTO_COUNT_NUMBER_ERROR_MESSAGE = "[Error]: 금액은 숫자를 입력해주세요.";
	private static final String LOTTO_COUNT_UNIT_ERROR_MESSAGE = "[Error]: 금액은 천원 단위여야 합니다.";

	private int count;

	public LottoCount(String money) {
		InputValidateUtils.inputBlank(money, LOTTO_COUNT_BLANK_ERROR_MESSAGE);
		InputValidateUtils.inputNumber(money, LOTTO_COUNT_NUMBER_ERROR_MESSAGE);
		this.count = makeMoneyToNumber(money);
	}

	// public LottoCount(int money) {
	// 	this.count = makeMoneyToNumber2(money);
	// }
	//
	// private int makeMoneyToNumber2(int money) {
	// 	validateThousandUnitInputMoney2(money);
	// 	return money / UNIT;
	// }
	//
	// private void validateThousandUnitInputMoney2(int money) {
	// 	if (money % UNIT != 0 || money == 0) {
	// 		throw new IllegalArgumentException(LOTTO_COUNT_UNIT_ERROR_MESSAGE);
	// 	}
	// }

	private int makeMoneyToNumber(String money) {
		validateThousandUnitInputMoney(money);
		return Integer.parseInt(money) / UNIT;
	}

	private void validateThousandUnitInputMoney(String money) {
		if (Integer.parseInt(money) % UNIT != 0 || Integer.parseInt(money) == 0) {
			throw new IllegalArgumentException(LOTTO_COUNT_UNIT_ERROR_MESSAGE);
		}
	}

	public boolean isZero() {
		return count == ZERO;
	}

	public void reduceCountOfRemain() {
		count--;
	}

	public int getCount() {
		return count;
	}
}

