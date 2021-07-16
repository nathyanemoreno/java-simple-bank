package com.socialnetwork;

public class Comment {
    private String commentId;
    private String comment;

    public Comment(String commentId, String comment){
       this.commentId = commentId;
       this.comment = comment;
    }

    public String getId(){
        return commentId;
    }

    public String getComment(){ return this.comment; }

}
