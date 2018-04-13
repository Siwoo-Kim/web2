package com.siwoo.webappag1.web.session;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter @ToString
public class Visitor {

    @Setter
    private String name = "Guest";
    @Setter
    private String email;
    private List<Long> visitedTopic = new ArrayList<>();
    private List<Long> likedTopic = new ArrayList<>();

    public enum Type {
        VISIT, LIKED
    }

    private static final int MAX_SIZE = 5;

    public void addTopic(Type type, Long topicId) {
        switch (type) {
            case VISIT: addVisitedTopic(topicId); return;
            case LIKED: addLikedTopic(topicId);
        }
    }

    private void addVisitedTopic(Long topicId) {
        if(visitedTopic.contains(topicId)) {
            return;
        }
        if(visitedTopic.size() >= MAX_SIZE) {
            visitedTopic.remove(0);
            visitedTopic.add(topicId);
            return;
        }
        visitedTopic.add(topicId);
    }

    private void addLikedTopic(Long topicId) {
        if(likedTopic.contains(topicId)) {
            return;
        }
        if(likedTopic.size() >= MAX_SIZE) {
            likedTopic.remove(0);
            likedTopic.add(topicId);
            return;
        }
        likedTopic.add(topicId);
    }
}
