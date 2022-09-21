package com.example.music.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

interface First {
}

interface Second {
}

interface Third {
}

@GroupSequence(value = {MusicDto.class, First.class, Second.class, Third.class})
public class MusicDto {

    private Integer id;

    @NotBlank(groups = First.class)
    @Size(max = 800, message = "Not over 800 characters.", groups = Second.class)
    @Pattern(regexp = "[a-zA-Z0-9 \\+]*$", groups = Third.class)
    private String name;

    @NotBlank(groups = First.class)
    @Size(max = 300, message = "Not over 300 characters.", groups = Second.class)
    @Pattern(regexp = "[a-zA-Z0-9 \\+]*$", groups = Third.class)
    private String singer;


    @NotBlank(groups = First.class)
    @Size(max = 1000, message = "Not over 1000 characters.", groups = Second.class)
    @Pattern(regexp = "[a-zA-Z0-9, \\+]*$", groups = Third.class)
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
