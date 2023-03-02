package com.nrahul32.controllerDemo.dto;

import java.util.Objects;

public class IdeaDTO {
    public IdeaDTO(int id, String title, String description, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    private int id;
    private String title;
    private String description;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "IdeaDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdeaDTO ideaDTO)) return false;
        return getId() == ideaDTO.getId() && Objects.equals(getTitle(), ideaDTO.getTitle()) && Objects.equals(getDescription(), ideaDTO.getDescription()) && Objects.equals(getAuthor(), ideaDTO.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getAuthor());
    }
}
