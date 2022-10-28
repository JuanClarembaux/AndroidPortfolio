package com.example.portfolio.model;

import java.util.ArrayList;

public class ReposRespuesta {
    private ArrayList<GithubRepo> results;

    public ArrayList<GithubRepo> getResults(){
        return results;
    }

    public void setResults(ArrayList<GithubRepo> results){
        this.results = results;
    }
}
