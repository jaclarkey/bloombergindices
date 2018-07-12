package hello;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Index {

    List<Data> data;
    Meta meta;

    public List<Data> getData() {
		return data;
	}
    
	public void setData(List<Data> data) {
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

    

    @Override
    public String toString() {
        return "{data:" + data +',' +
                "meta:" + meta + '\'' +
                '}';
    }
}
