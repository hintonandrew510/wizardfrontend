package web.page.strategicmarketingpagethree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import web.page.PublishController;

public class StrategicMarketingHelper {

	private String bestMonths;
	private String poorestMonths;
	private String bestDays;
	private StrategicMarketingPageThreeModel strategicMarketingPageThreeModel;

	public StrategicMarketingHelper(StrategicMarketingPageThreeModel strategicMarketingPageThreeModel) {

		this.strategicMarketingPageThreeModel = strategicMarketingPageThreeModel;
	}

	

	public void setBestMonths(String bestMonths) {
		this.bestMonths = bestMonths;
	}



	public void setPoorestMonths(String poorestMonths) {
		this.poorestMonths = poorestMonths;
	}

	public String getBestDays() {
		StringBuilder builder = new StringBuilder();
		boolean mon = this.strategicMarketingPageThreeModel.isBestMonday();
		boolean tue = this.strategicMarketingPageThreeModel.isBestTuesday();
		boolean wed = this.strategicMarketingPageThreeModel.isBestWednesday();
		boolean thu = this.strategicMarketingPageThreeModel.isBestThursday();
		boolean fri = this.strategicMarketingPageThreeModel.isBestFriday();
		boolean sat = this.strategicMarketingPageThreeModel.isBestSaturday();
		boolean sun = this.strategicMarketingPageThreeModel.isBestSunday();
		
		mLog.info("jan " + mon);
		mLog.info("feb " + tue);

		if (mon) {
			builder.append("Monday");
		}

		mLog.info("builder " + builder.toString());
		if (tue) {
			if (mon) {
				builder.append(", Tuesday");
			} else {
				builder.append("Tuesday");
			}

		}
		mLog.info("builder " + builder.toString());
		if (wed) {
			if (mon || tue) {
				builder.append(", Wednesday");
			} else {
				builder.append("Wednesday");
			}

		}

		if (thu) {
			if (mon || tue || wed) {
				builder.append(", Thursday");
			} else {
				builder.append("Thursday");
			}

		}

		if (fri) {
			if (mon || tue || wed || thu) {
				builder.append(", Friday");
			} else {
				builder.append("Friday");
			}

		}

		if (sat) {
			if (mon || tue || wed || thu || fri) {
				builder.append(", Saturday");
			} else {
				builder.append("Saturday");
			}

		}
		if (sun) {
			if (mon || tue || wed || thu || fri || sat) {
				builder.append(", Sunday");
			} else {
				builder.append("Sunday");
			}

		}

		return builder.toString();
	}

	public void setBestDays(String bestDays) {
		this.bestDays = bestDays;
	}

	private static final Logger mLog = LoggerFactory.getLogger(StrategicMarketingHelper.class.getName());

	public  String getPoorestMonths() {
		StringBuilder builder = new StringBuilder();
		boolean jan = this.strategicMarketingPageThreeModel.isPoorestJanuary();
		boolean feb = this.strategicMarketingPageThreeModel.isPoorestFebruary();
		boolean mar = this.strategicMarketingPageThreeModel.isPoorestMarch();
		boolean apr = this.strategicMarketingPageThreeModel.isPoorestApril();
		boolean may = this.strategicMarketingPageThreeModel.isPoorestMay();
		boolean jun = this.strategicMarketingPageThreeModel.isPoorestJune();
		boolean jul = this.strategicMarketingPageThreeModel.isPoorestJuly();
		boolean aug = this.strategicMarketingPageThreeModel.isPoorestAugust();
		boolean sep = this.strategicMarketingPageThreeModel.isPoorestSeptember();
		boolean oct = this.strategicMarketingPageThreeModel.isPoorestOctober();
		boolean nov = this.strategicMarketingPageThreeModel.isPoorestNovember();
		boolean dec = this.strategicMarketingPageThreeModel.isPoorestDecember();
		mLog.info("jan " + jan);
		mLog.info("feb " + feb);

		if (jan) {
			builder.append("January");
		}

		mLog.info("builder " + builder.toString());
		if (feb) {
			if (jan) {
				builder.append(", February");
			} else {
				builder.append("February");
			}

		}
		mLog.info("builder " + builder.toString());
		if (mar) {
			if (jan || feb) {
				builder.append(", March");
			} else {
				builder.append("March");
			}

		}

		if (apr) {
			if (jan || feb || mar) {
				builder.append(", April");
			} else {
				builder.append("April");
			}

		}

		if (may) {
			if (jan || feb || mar || apr) {
				builder.append(", May");
			} else {
				builder.append("May");
			}

		}

		if (jun) {
			if (jan || feb || mar || apr || may) {
				builder.append(", June");
			} else {
				builder.append("June");
			}

		}
		if (jul) {
			if (jan || feb || mar || apr || may || jun) {
				builder.append(", July");
			} else {
				builder.append("July");
			}

		}

		if (aug) {
			if (jan || feb || mar || apr || may || jun || jul) {
				builder.append(", August");
			} else {
				builder.append("August");
			}

		}

		if (sep) {
			if (jan || feb || mar || apr || may || jun || jul || aug) {
				builder.append(", September");
			} else {
				builder.append("September");
			}

		}

		if (oct) {
			if (jan || feb || mar || apr || may || jun || jul || aug || sep) {
				builder.append(", October");
			} else {
				builder.append("October");
			}

		}

		if (nov) {
			if (jan || feb || mar || apr || may || jun || jul || aug || sep || oct) {
				builder.append(", November");
			} else {
				builder.append("November");
			}

		}

		if (dec) {
			if (jan || feb || mar || apr || may || jun || jul || aug || sep || oct || nov) {
				builder.append(", December");
			} else {
				builder.append("December");
			}

		}

		return builder.toString();
	}

	public  String getBestMonths() {
		StringBuilder builder = new StringBuilder();
		boolean jan = strategicMarketingPageThreeModel.isBestJanuary();
		boolean feb = strategicMarketingPageThreeModel.isBestFebruary();
		boolean mar = strategicMarketingPageThreeModel.isBestMarch();
		boolean apr = strategicMarketingPageThreeModel.isBestApril();
		boolean may = strategicMarketingPageThreeModel.isBestMay();
		boolean jun = strategicMarketingPageThreeModel.isBestJune();
		boolean jul = strategicMarketingPageThreeModel.isBestJuly();
		boolean aug = strategicMarketingPageThreeModel.isBestAugust();
		boolean sep = strategicMarketingPageThreeModel.isBestSeptember();
		boolean oct = strategicMarketingPageThreeModel.isBestOctober();
		boolean nov = strategicMarketingPageThreeModel.isBestNovember();
		boolean dec = strategicMarketingPageThreeModel.isBestDecember();
		mLog.info("jan " + jan);
		mLog.info("feb " + feb);

		if (jan) {
			builder.append("January");
		}

		mLog.info("builder " + builder.toString());
		if (feb) {
			if (jan) {
				builder.append(", February");
			} else {
				builder.append("February");
			}

		}
		mLog.info("builder " + builder.toString());
		if (mar) {
			if (jan || feb) {
				builder.append(", March");
			} else {
				builder.append("March");
			}

		}

		if (apr) {
			if (jan || feb || mar) {
				builder.append(", April");
			} else {
				builder.append("April");
			}

		}

		if (may) {
			if (jan || feb || mar || apr) {
				builder.append(", May");
			} else {
				builder.append("May");
			}

		}

		if (jun) {
			if (jan || feb || mar || apr || may) {
				builder.append(", June");
			} else {
				builder.append("June");
			}

		}
		if (jul) {
			if (jan || feb || mar || apr || may || jun) {
				builder.append(", July");
			} else {
				builder.append("July");
			}

		}

		if (aug) {
			if (jan || feb || mar || apr || may || jun || jul) {
				builder.append(", August");
			} else {
				builder.append("August");
			}

		}

		if (sep) {
			if (jan || feb || mar || apr || may || jun || jul || aug) {
				builder.append(", September");
			} else {
				builder.append("September");
			}

		}

		if (oct) {
			if (jan || feb || mar || apr || may || jun || jul || aug || sep) {
				builder.append(", October");
			} else {
				builder.append("October");
			}

		}

		if (nov) {
			if (jan || feb || mar || apr || may || jun || jul || aug || sep || oct) {
				builder.append(", November");
			} else {
				builder.append("November");
			}

		}

		if (dec) {
			if (jan || feb || mar || apr || may || jun || jul || aug || sep || oct || nov) {
				builder.append(", December");
			} else {
				builder.append("December");
			}

		}

		return builder.toString();
	}
}
