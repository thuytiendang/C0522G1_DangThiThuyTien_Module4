package com.example.music.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {

    private Integer id;

    @NotBlank
    @Size(max = 800, message = "Not over 800 characters.")
    @Pattern(regexp = "[a-zA-Z0-9 \\+]*$")
    private String name;

    @NotBlank
    @Size(max = 300, message = "Not over 300 characters.")
    @Pattern(regexp = "[a-zA-Z0-9 \\+]*$")
    private String singer;


    @NotBlank
    @Size(max = 1000, message = "Not over 1000 characters.")
    @Pattern(regexp = "[a-zA-Z0-9, \\+]*$")
    private String typeOfMusic;
    private String link;

    public MusicDto() {
    }

    public MusicDto(Integer id, String name, String singer, String typeOfMusic, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.typeOfMusic = typeOfMusic;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
