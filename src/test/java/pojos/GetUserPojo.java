package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserPojo {

    private GetUserDataPojo data;
    private GetUserSupportPojo support;

    public GetUserPojo() {
    }

    public GetUserPojo(GetUserDataPojo data, GetUserSupportPojo support) {
        this.data = data;
        this.support = support;
    }

    public GetUserDataPojo getData() {
        return data;
    }

    public void setData(GetUserDataPojo data) {
        this.data = data;
    }

    public GetUserSupportPojo getSupport() {
        return support;
    }

    public void setSupport(GetUserSupportPojo support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "GetUserPojo{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
