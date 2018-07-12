package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attributes {
	double coupon, weight;
	String issuer, maturity_date;
	
	public double getCoupon() {
		return coupon;
	}
	public void setCoupon(double coupon) {
		this.coupon = coupon;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(String maturity_date) {
		this.maturity_date = maturity_date;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "attributes:{" +
        "coupon:'" + coupon + '\'' +
        ", issuer:'"+ issuer + '\'' +
        ", maturity_date:'"+ maturity_date + '\'' +
        ", weight:'"+ weight + '\'' + "}";
	}

}
