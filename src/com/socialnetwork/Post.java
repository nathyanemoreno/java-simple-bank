package com.socialnetwork;

import java.util.ArrayList;
import java.util.HashMap;

public class Post {
    private ArrayList<String> likesListUsers = new ArrayList<>();
    private HashMap<String, HashMap<String, Comment>> comments = new HashMap<>();
    private HashMap<String, ArrayList<String>> likes = new HashMap<>();
    private String postId;
    private String postText;

    public Post(String postId, String postText) {
        this.postId = postId;
        this.postText = postText;
    }

    public String getId(){
        return this.postId;
    }

    public void addComment(String userIdCommentary, Comment comment){
        HashMap<String,Comment> commentHashMap = new HashMap<>();
        commentHashMap.put(userIdCommentary,comment);
        comments.put(comment.getId(), commentHashMap);
    }

    public String getPostText(){
        return this.postText;
    }

    public void likePost(String userIdPost) {
        this.likesListUsers.add(userIdPost);
        this.likes.put(this.postId, likesListUsers);
    }

    public HashMap<String, ArrayList<String>> getUserLikes(){
        return this.likes;
    }
    public HashMap<String, HashMap<String, Comment>> getComments() {
        return comments;
    }
}
