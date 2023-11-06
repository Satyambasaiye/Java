package Com.core;

public enum MessPlan {
	MONTHLY (3000,1), QUARTERLY (11700,3), HALFYEAR (17500,6), YEARLY (32000,12)	;
	int rate;
	int months;
	private MessPlan(int rate,int months) {
		this.rate=rate;
		this.months=months;
		// TODO Auto-generated constructor stub
	}
	public void setRate(int rate,int months) {
		this.rate = rate;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
}
