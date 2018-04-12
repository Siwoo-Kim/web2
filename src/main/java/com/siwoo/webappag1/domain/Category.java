package com.siwoo.webappag1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siwoo.webappag1.domain.embedded.BasicTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Setter @ToString(exclude = "topics")
@Getter @Entity
@EqualsAndHashCode(of={"id","name","URL"})
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 700)
    private String introduction;

    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToOne
    @JoinColumn(name ="webpage_id")
    private WebPage webPage;

    private String prerequisite;

    @Column(length = 1000)
    private String description;

    private BasicTime basicTime;

    private URL url;

    @JsonIgnore
    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Topic> topics = new ArrayList<>();

    public void addTopic(Topic topic) {
        this.topics.add(topic);
        if(topic.getCategory() != null && topic.getCategory() != this) {
            topic.getCategory().getTopics().remove(topic);
            topic.setCategory(this);
        }
    }
}
