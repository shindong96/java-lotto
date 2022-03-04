package model.lottonumber;

import java.util.List;

import model.result.Rank;

public class LottoNumbers {
	private static final int LOTTO_SIZE = 6;

	private final List<LottoNumber> numbers;

	private LottoNumbers(List<LottoNumber> numbers) {
		this.numbers = numbers;
	}

	public static LottoNumbers from(LottoNumbersGenerationStrategy lottoNumbersGenerationStrategy) {
		List<LottoNumber> generatedLottoNumbers = lottoNumbersGenerationStrategy.generate(LOTTO_SIZE);

		return new LottoNumbers(generatedLottoNumbers);
	}

	public static LottoNumbers valueOf(LottoNumbers numbers) {
		return new LottoNumbers(numbers.getNumbers());
	}

	public long countMatchedNumbers(List<LottoNumber> winningNumbers) {
		return numbers.stream()
			.filter(winningNumbers::contains)
			.count();
	}

	public Rank validateMatchWithBonus(LottoNumber number) {
		if (numbers.contains(number)) {
			return Rank.SECOND;
		}
		return Rank.THIRD;
	}

	public List<LottoNumber> getNumbers() {
		return this.numbers;
	}
}
