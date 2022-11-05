package StartAtGoogle.week3.DesignPatterns.Structural;

import java.io.IOException;
import java.net.MalformedURLException;

public class main {
    public static void main(String[] args) throws Exception {

        String get = "https://reqres.in/api/unknown/2";
        Response getRes = facadeHTTP.get(get);
        System.out.print("get: ");
        System.out.println(getRes);

        // post
        String post = "https://reqres.in/api/users";
        Response postRes = facadeHTTP.post(post, "Dvir", "Looking");
        System.out.print("post: ");
        System.out.println(postRes);

        // put
        String put = "https://reqres.in/api/users/2";
        Response putRes = facadeHTTP.put(put, "Rany", "Looking");
        System.out.print("put: ");
        System.out.println(putRes);

        // patch
        String patch = "https://reqres.in/api/users/2";
        Response patchRes = facadeHTTP.patch(patch, "DAvid", "Looking");
        System.out.print("patch: ");
        System.out.println(patchRes);

        // delete
        String delete = "https://reqres.in/api/users/2";
        Response deleteRes = facadeHTTP.delete(delete);
        System.out.print("delete: ");
        System.out.println(deleteRes);

    }
}
