package com.infanzon.collaborativestorybuilder.DataClasses;

import java.util.List;

public class Story {
    private String storyId;
    private String title;
    private List<String> contributors;
    private List<String> content;

    // Constructor
    public Story(String storyId, String title, List<String> contributors, List<String> content) {
        this.storyId = storyId;
        this.title = title;
        this.contributors = contributors;
        this.content = content;
    }

    // Getters and Setters
    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContributors() {
        return contributors;
    }

    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
