package StartAtGoogle.week3.DesignPatterns.Structural;

public class Response {
    private int code;
    private String body;

    public Response(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public Response(int code) {
        this.code = code;
        this.body = "";
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", body='" + body + '\'' +
                '}';
    }
}
