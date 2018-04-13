package com.siwoo.webappag1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siwoo.webappag1.domain.embedded.BasicTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="tbl_topic")
@Getter @Setter @ToString(exclude = "documents")
public class Topic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        if(document.getTopic() != this) {
            document.setTopic(this);
        }
        if(!documents.contains(document)) {
            this.documents.add(document);
        }
    }
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="tbl_topic_references",
            joinColumns = @JoinColumn(name="id"))
    @OrderColumn(name="col_idx")
    List<URL> references = new ArrayList<>();

    @Column(name ="topic_rate")
    private Double rate = 0.0;
    @Column(name ="topic_hit")
    private Integer hit = 0;
    @Column(name ="topic_likes")
    private Integer likes = 0;
    private BasicTime basicTime;


    public void setCategory(Category category) {
        this.category = category;
        if(!category.getTopics().contains(this)) {
            category.addTopic(this);
        }
    }

}
