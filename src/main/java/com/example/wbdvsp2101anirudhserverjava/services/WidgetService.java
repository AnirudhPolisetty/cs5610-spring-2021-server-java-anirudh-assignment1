package com.example.wbdvsp2101anirudhserverjava.services;

import com.example.wbdvsp2101anirudhserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
//import java.util.UUID;
import java.util.Random;

@Service
public class WidgetService {
    private List<Widget> widgets;
    private final String TOPIC_ID = "604991ce9fcc120017b7dd74";
    private final String APPLE_TEXT = "Sweet Apple";

    public WidgetService() {
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
    }

    public Widget createWidget(String topicID, Widget widget) {
        widget.setTopicId(topicID);
        widget.setId(new Random().nextInt());
        widgets.add(widget);
        return widget;
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(topicId)) {
                ws.add(w);
            }
        }
        return ws;
    }

    public Widget findWidgetById(String widgetId) {
        for(Widget w: widgets) {
            if(w.getId().equals(Integer.parseInt(widgetId))) {
                return w;
            }
        }
        return null;
    }

    public Integer updateWidget(String widgetId, Widget newWidget) {
        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(Integer.parseInt(widgetId))) {
                widgets.set(i, newWidget);
                return 1;
            }
        }
        return -1;
    }

    public Integer deleteWidget(String widgetId) {
        int index = -1;
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
        return -1;
    }
}
