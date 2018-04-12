package com.siwoo.webappag1.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter @Setter @ToString
@Embeddable
@EqualsAndHashCode(of={"title","content"})
public class Document {

    private String title;
    @Column(length = 1000)
    private String content;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    protected Document() {}

}
