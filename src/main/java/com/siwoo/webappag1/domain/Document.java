package com.siwoo.webappag1.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter @Setter @ToString(exclude = "topic")
@Entity @Table(name = "tbl_document")
@EqualsAndHashCode(of={"title","content"})
public class Document {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(length = 1000)
    private String content;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name ="document_code",
    joinColumns = @JoinColumn(name="document_id"))
    @MapKeyColumn(name = "code_name")
    @Column(name = "code_value")
    private Map<String,String> codes = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Document(String title, String content, Map codes) {
        this.title = title;
        this.content = content;
        this.codes = codes;
    }

    protected Document() {}

}
