package kasei.springcloud.common;

public class UniversalResponse {

    private int state;
    private String msg;
    private Object data;

    public UniversalResponse() {
    }

    public UniversalResponse(int state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
