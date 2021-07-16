package com.socialnetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class User {
    private LinkedList<String> friends = new LinkedList<>();
    private HashMap<String,Post> posts = new HashMap<>();
    private String username;
    private String userId;

    public User(String userId, String name) {
        this.username = name;
        this.userId = userId;
    }

    public void addFriend(String userId){
        friends.push(userId);
    }

    public LinkedList<String> getFriends() {
        return friends;
    }

    public void addPost(Post post){
        posts.put(post.getId(),post);
    }

    public HashMap<String,Post> getPosts() {
        return posts;
    }

    public String getId(){
        return userId;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getName(){
        return this.username;
    }


}
