package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Meta {
	
	Stats stats;

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{" +
        "meta:'" + stats + '\'' +
        '}';
	}

}
