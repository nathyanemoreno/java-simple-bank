package com.socialnetwork;

public class App {
    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork("Instagram");

        Button btnCreateAccount = new Button("Exec code", () -> {
            socialNetwork.addUser(new User("u1", "Nathyane"));
            socialNetwork.addUser(new User("u2", "Alexandre"));
            socialNetwork.addUser(new User("u3", "Aline"));

            socialNetwork.addFriendly("u1","u2");
            socialNetwork.addFriendly("u1","u3");

            socialNetwork.addPost("u1", new Post("p1", "Tomando café!"));
            socialNetwork.addPost("u2", new Post("p2", "Amizade é tudo de bom!"));
            socialNetwork.addPost("u2", new Post("p3", "Passeando com eu cachorro"));

            socialNetwork.addComment ("u3", "u1", "p1", new Comment ("c1",
                    "Com pão de queijo ? tudo di bão"));

            socialNetwork.liked("u3", "u2", "p2");
            socialNetwork.liked("u1", "u2", "p2");

        });

        Button btnGetUsers = new Button("Print updates", () -> {
            System.out.println(socialNetwork.getUsers());
            System.out.println(socialNetwork.getUsers().get("u1").getFriends());
            System.out.println(socialNetwork.getUsers().get("u1").getPosts().get("p1").getComments());
            socialNetwork.printUpdates();
        });
        new MainFrame(btnCreateAccount, btnGetUsers);

    }

}
