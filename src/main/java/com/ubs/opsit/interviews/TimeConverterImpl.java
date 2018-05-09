package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter {

	private static final char CHAR_Y = 'Y';
	private static final char CHAR_O = 'O';
	private static final char CHAR_R = 'R';
	private static final String NEW_LINE = System.getProperty("line.separator");

	public String convertTime(String aTime) {

		char[] first = new char[] { CHAR_O, CHAR_O, CHAR_O, CHAR_O };
		char[] second = new char[] { CHAR_O, CHAR_O, CHAR_O, CHAR_O };
		char[] third = new char[] { CHAR_O, CHAR_O, CHAR_O, CHAR_O, CHAR_O, CHAR_O, CHAR_O, CHAR_O, CHAR_O, CHAR_O,
				CHAR_O };
		char[] forth = new char[] { CHAR_O, CHAR_O, CHAR_O, CHAR_O };

		String[] time = aTime.split(":");
		Integer hour = Integer.valueOf(time[0]);
		Integer minute = Integer.valueOf(time[1]);
		Integer seconds = Integer.valueOf(time[2]);

		int h = hour.intValue();
		for (int i = 0; h > 0 && i < first.length && h / 5 > 0; i++) {
			first[i] = CHAR_R;
			h -= 5;
		}

		for (int i = 0; i < second.length && h > 0; i++) {
			second[i] = CHAR_R;
			h -= 1;
		}

		int m, m1;
		m = m1 = minute.intValue();
		for (int i = 0; m > 0 && i < third.length && m / 5 > 0; i++) {
			third[i] = CHAR_Y;
			m -= 5;

			if (m1 > 0 && m1 / 15 > 0 && (i == 2 || i == 5 || i == 8)) {
				third[i] = CHAR_R;
				m1 -= 15;
			}
		}

		for (int i = 0; i < forth.length && m > 0; i++) {
			forth[i] = CHAR_Y;
			m -= 1;
		}

		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append((seconds.intValue() % 2 == 1) ? CHAR_O : CHAR_Y);
		strbuilder.append(NEW_LINE);
		strbuilder.append(String.valueOf(first));
		strbuilder.append(NEW_LINE);
		strbuilder.append(String.valueOf(second));
		strbuilder.append(NEW_LINE);
		strbuilder.append(String.valueOf(third));
		strbuilder.append(NEW_LINE);
		strbuilder.append(String.valueOf(forth));

		return strbuilder.toString();
	}

}
