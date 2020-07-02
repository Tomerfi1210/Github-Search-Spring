package com.hadassah.demo.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;

@Entity
public class GitHubUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "login is mandatory")
    private String login;
    @NotBlank(message = "link is mandatory")
    private String link;
    @NotBlank(message = "number is mandatory")
    private int searchCounter;

    private int followers;

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    //two constructors .
    public GitHubUser(){}
    public GitHubUser(String login,String link){
        this.login =login;
        this.link = link;
        this.searchCounter =1;
    }

    public void inc_search_counter() {this.searchCounter++;}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSearchCounter() {
        return searchCounter;
    }

    public void setSearchCounter(int searchCounter) {
        this.searchCounter = searchCounter;
    }

    public void inc() {
        this.searchCounter++;
    }

}
