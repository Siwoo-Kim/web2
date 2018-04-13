package com.siwoo.webappag1.web;

import com.siwoo.webappag1.web.session.Visitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/visit")
public class VisitorController {

    @Resource(name="visitorFactory")
    ObjectFactory visitorFactory;

    @GetMapping("/{type}/{topicId}")
    public void visit(@PathVariable("type") String type, @PathVariable("topicId") Long id) {
        Visitor.Type _type = Visitor.Type.valueOf(type.toUpperCase());
        log.warn(_type + "");
        if(id != null) {
            Visitor visitor = (Visitor) visitorFactory.getObject();
            visitor.addTopic(_type, id);
        }
    }

    @GetMapping()
    public void visit() {
        Visitor visitor = (Visitor) visitorFactory.getObject();
        log.warn(visitor + "");

    }


}
