package com.example.wbdvsp2101anirudhserverjava.services;

import com.example.wbdvsp2101anirudhserverjava.models.Widget;
import com.example.wbdvsp2101anirudhserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
//import java.util.UUID;
import java.util.Optional;
import java.util.Random;

@Service
public class WidgetService {
   //private List<Widget> widgets;
    //private final String TOPIC_ID = "604991ce9fcc120017b7dd74";
    //private final String APPLE_TEXT = "Sweet Apple";

    @Autowired
    WidgetRepository repository;

    /*public WidgetService() {
        widgets = new ArrayList<>();
        Widget w1 = new Widget();
        Widget w2 = new Widget();
        Widget w3 = new Widget();
        Widget w4 = new Widget();

        w1.setTopicId(TOPIC_ID);
        w1.setId(new Random().nextInt());
        w1.setType("HEADING");
        w1.setText("Heading");
        w1.setSize(1);
        widgets.add(w1);

        w2.setTopicId(TOPIC_ID);
        w2.setId(new Random().nextInt());
        w2.setType("HEADING");
        w2.setText("Heading");
        w2.setSize(3);
        widgets.add(w2);

        w3.setTopicId(TOPIC_ID);
        w3.setId(new Random().nextInt());
        w3.setType("PARAGRAPH");
        w3.setSize(1);
        w3.setText("Paragraph" + APPLE_TEXT);
        widgets.add(w3);

        w4.setTopicId(TOPIC_ID);
        w4.setId(new Random().nextInt());
        w4.setType("PARAGRAPH");
        w4.setSize(1);
        w4.setText("Paragraph" + APPLE_TEXT);
        widgets.add(w4);
    }*/

    // implement crud operations
    public Widget createWidget(String topicID, Widget widget) {
        widget.setTopicId(topicID);
        //widget.setId(new Random().nextInt());

        return repository.save(widget);
    }

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        return repository.findAllByTopicId(topicId);
    }

    public Widget findWidgetById(String widgetId) {
        /*for(Widget w: widgets) {
            if(w.getId().equals(Integer.parseInt(widgetId))) {
                return w;
            }
        }
        return null;*/
        Optional<Widget> widget = repository.findById(Integer.parseInt(widgetId));
        return widget.orElse(null);
    }

    public Integer updateWidget(String widgetId, Widget newWidget) {
        /*for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(Integer.parseInt(widgetId))) {
                widgets.set(i, newWidget);
                return 1;
            }
        }
        return -1;*/
        Widget originalWidget = findWidgetById(widgetId);
        if (originalWidget == null) return 0;
        if (newWidget.getText() != null) originalWidget.setText(newWidget.getText());
        if (newWidget.getTopicId() != null) originalWidget.setTopicId(newWidget.getTopicId());
        if (newWidget.getType() != null) originalWidget.setType(newWidget.getType());
        if (newWidget.getSize() != null) originalWidget.setSize(newWidget.getSize());
        if (newWidget.getUrl() != null) originalWidget.setUrl(newWidget.getUrl());
        if (newWidget.getWidth() != null) originalWidget.setWidth(newWidget.getWidth());
        if (newWidget.getHeight() != null) originalWidget.setHeight(newWidget.getHeight());
        if (newWidget.getValue() != null) originalWidget.setValue(newWidget.getValue());
        if (newWidget.getOrdered() != null) originalWidget.setOrdered(newWidget.getOrdered());

        repository.save(originalWidget);
        return 1;
    }

    public Integer deleteWidget(String widgetId) {
        /*int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(Integer.parseInt(widgetId))) {
                index = i;
            }
        }
        if(index >= 0) {
            widgets.remove(index);
            return 1;
        }
        return -1;*/
        Integer wid = Integer.parseInt(widgetId);
        if (wid == null) return 0;
        repository.deleteById(wid);
        return 1;
    }
}
