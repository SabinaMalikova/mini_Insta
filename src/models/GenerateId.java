package models;

public class GenerateId {
    public static Long userId = 0L;
    public static Long postId = 0L;


    public static Long genPostId(){
        return ++postId;
    }

    public static Long genUserId(){
        return ++userId;
    }


}
