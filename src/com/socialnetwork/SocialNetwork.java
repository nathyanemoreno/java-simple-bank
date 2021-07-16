package com.socialnetwork;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SocialNetwork {
    public HashMap<String, User> users = new HashMap<>();
    public String name;

    public SocialNetwork(String name){
        this.name = name;
        assert name != null;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addFriendly(String userId, String userId2) {
        User user1 = this.getUsers().get(userId);
        User user2 = this.getUsers().get(userId2);

        user1.addFriend(userId2);
        user2.addFriend(userId);
    }

    public void addPost(String userId, Post post){
       this.getUsers().get(userId).addPost(post);
    }

    public void addComment(String userIdCommentary,String userIdPost, String postId, Comment comment ){
        this.getUsers().get(userIdPost).getPosts().get(postId).addComment(userIdCommentary,comment);
    }

    public void liked(String userId, String userIdPost, String postId){
        this.users.get(userIdPost).getPosts().get(postId).likePost(userId);
    }

    public HashMap<String, User> getUsers() {
        return this.users;
    }


    public void printUpdates() {
        this.getUsers().forEach((s, user) -> user.getPosts().forEach((z, post) -> {
            System.out.println(Colors.CYAN_BOLD + "_________________");
            System.out.println(user.getName() + "\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯" + Colors.ANSI_RESET);
            System.out.println(Colors.WHITE_BOLD + post.getPostText() + Colors.ANSI_RESET);
            StringBuilder usersStringBuild = new StringBuilder();
            try {
                ArrayList<String> arrayLikeList = post.getUserLikes().get(post.getId());
                for (String userId : post.getUserLikes().get(post.getId())) {
                    usersStringBuild.append(this.getUsers().get(userId).getName());
                    if (arrayLikeList.lastIndexOf(userId) + 1 != arrayLikeList.size()) {
                        usersStringBuild.append(",");
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("No likes.");
            }
            if (!usersStringBuild.toString().equals("")) {
                System.out.println(Colors.PURPLE + usersStringBuild.toString() + " liked this post." + Colors.ANSI_RESET);
            }

            post.getComments().forEach((w, comment) -> comment.forEach((userPosted, commentText) -> {
                System.out.println(Colors.BLUE + "\t" +
                        this.getUsers().get(userPosted).getName()
                        + Colors.YELLOW
                        + " - " + commentText.getComment()
                        + Colors.ANSI_RESET);
//                        System.out.println(commentText.getComment());
            }));
        }));

    }

//    public static void setUsers(HashMap<String, User> users) {
//        SocialNetwork.users = users;
//    }

}
