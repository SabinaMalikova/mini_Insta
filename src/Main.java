import enums.Gender;
import models.GenerateId;
import models.Post;
import models.User;
import service.serviceImpl.PostServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);
        PostServiceImpl postService = new PostServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        while (true) {
            System.out.println("      ACTIONS: \n" +
                    "1. registration. \n" +
                    "2. login.\n" +
                    "3. get user by email.\n" +
                    "4. get all users.\n" +
                    "5. exit\n" +
                    "     choose an action: ");
            int choice = scannerNum.nextInt();
            switch (choice) {
                case 1: {
                    User user = new User();
                    System.out.println("Write full name: ");
                    user.setFullName(scannerStr.nextLine());
                    System.out.println("Write gender: M or F ");
                    user.setGender(Gender.valueOf(scannerStr.nextLine()));
                    System.out.println("write email: ");
                    user.setEmail(scannerStr.nextLine());
                    System.out.println("Write password: ");
                    user.setPassword(scannerStr.nextLine());
                    user.setId(GenerateId.genUserId());
                    System.out.println("Your ID: "+user.getId());
                    userService.registration(user);
                    break;
                }
                case 2: {
                    System.out.println("Write email: ");
                    String email = new Scanner(System.in).nextLine();
                    System.out.println("Write password: ");
                    String password = new Scanner(System.in).nextLine();
                    if (userService.login(email, password).equals("successfully")) {
                        boolean isTrue = false;
                        while (!isTrue) {
                            System.out.println("""
                                    operation completed successfully!
                                           choose an action:
                                    1. add post to user
                                    2. delete post by Id
                                    2. get post by user Id
                                    4. exit""");
                            switch (scannerNum.nextInt()) {
                                case 1 -> {
                                    Post post = new Post();
                                    post.setId(GenerateId.genPostId());
                                    System.out.println("Write imgUrl: ");
                                    post.setImgUrl(scannerStr.nextLine());
                                    System.out.println("Write description:");
                                    post.setDescription(scannerStr.nextLine());
                                    System.out.println("Write user ID for add post: ");
                                    System.out.println(postService.addPostToUser(scannerNum.nextLong(), post));
                                }
                                case 2 -> {
                                    System.out.println("Write post ID:");
                                    System.out.println(postService.deletePostById(scannerNum.nextLong()));
                                }
                                case 3 -> {
                                    System.out.println("Write user ID: ");
                                    System.out.println(postService.getPostByUserId(scannerNum.nextLong()));
                                }
                                case 4 -> {
                                    isTrue = true;
                                    break;
                                }
                            }
                        }
                    }
                }break;
                case 3: {
                    System.out.println("Write user email: ");
                    System.out.println(userService.getUserByEmail(scannerStr.nextLine()));
                    break;
                }
                case 4: {
                    System.out.println(userService.getAllUsers());
                    break;
                }
                case 5: {
                    System.out.println("have a nice day! ");
                    return;
                }
                default:
                    System.err.println("no such option!");
            }
        }
    }
}
